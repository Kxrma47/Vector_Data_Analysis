SELECT h."name" AS street_name, COUNT(r."osm_id") AS tram_stop_count, ST_Centroid(h.geom) AS geom
FROM highway_line_4326 AS h
JOIN railway_station_point_4326 AS r ON ST_DWithin(h.geom, r.geom, 100)
WHERE h."name" IS NOT NULL
GROUP BY h."name", h.geom
ORDER BY tram_stop_count DESC
LIMIT 10;
