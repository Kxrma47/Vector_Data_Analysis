SELECT DISTINCT p."osm_id" AS poi_id, p."shop" AS shop_type, p.geom AS poi_geom
FROM poi_point_4326 AS p
JOIN railway_station_point_4326 AS t ON ST_DWithin(p.geom, t.geom, 200)
WHERE p."shop" IS NOT NULL;
