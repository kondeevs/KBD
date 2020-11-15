SELECT DISTINCT t.last_name
FROM teacher AS t
         LEFT JOIN teacher_student_group AS tsg ON t.personal_number = tsg.personal_number
WHERE audience_number LIKE 210;