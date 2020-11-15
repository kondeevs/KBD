SELECT DISTINCT project.city
FROM project
UNION DISTINCT
SELECT part.city
FROM part
UNION DISTINCT
SELECT provider.city
FROM provider
;
