SELECT DISTINCT provider_id
FROM provider_part_project
WHERE part_id IN (
    SELECT ppp.part_id
    FROM provider_part_project AS ppp
    WHERE ppp.provider_id IN (
        SELECT DISTINCT provider_id
        FROM provider_part_project
                 LEFT JOIN part p ON provider_part_project.part_id = p.part_id
        WHERE p.color = 'Красный'
    )
);