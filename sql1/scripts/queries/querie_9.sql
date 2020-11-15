SELECT DISTINCT name_subject, student_group_name
FROM subject AS s
         LEFT JOIN teacher_student_group AS tsg ON tsg.subject_code_number = s.subject_code_number
         LEFT JOIN student_group sg on tsg.student_group_code = sg.student_group_code
WHERE audience_number BETWEEN 100 AND 200;