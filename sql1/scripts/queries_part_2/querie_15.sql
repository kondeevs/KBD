SELECT provider_id, COUNT(project_id)
FROM provider_part_project
WHERE provider_id = 'П1'
GROUP BY provider_id;
