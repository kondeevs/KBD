SELECT  provider_id, ppp.project_id
FROM provider_part_project AS ppp
    LEFT JOIN project AS p ON ppp.project_id = p.project_id
WHERE provider_id = 'П1';
