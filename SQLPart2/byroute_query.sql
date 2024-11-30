SELECT h."osm_id" AS highway_id, h."name" AS highway_name, ST_Simplify(h.geom, 10) AS geom
FROM highway_line_4326 AS h
JOIN poi_point_4326 AS p
ON h.geom && p.geom AND ST_DWithin(h.geom, p.geom, 100)
WHERE h."name" IS NOT NULL;
