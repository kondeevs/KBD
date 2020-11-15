SELECT DISTINCT part_id
FROM provider_part_project AS ppp
         LEFT JOIN project AS p ON ppp.project_id = p.project_id
         LEFT JOIN provider AS pr ON ppp.provider_id = pr.provider_id
WHERE p.city = 'Лондон' AND pr.city = 'Лондон';