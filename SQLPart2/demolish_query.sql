SELECT p."osm_id" AS poi_id, p."name" AS poi_name, b."osm_id" AS building_id, p.geom
FROM building_polygon_4326 AS b
JOIN poi_point_4326 AS p ON ST_Intersects(b.geom, p.geom)
WHERE ST_Intersects(b.geom, p.geom);
