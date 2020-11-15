SELECT DISTINCT sg.student_group_code
FROM teacher_student_group AS tsg
         LEFT JOIN student_group AS sg ON tsg.student_group_code = sg.student_group_code
         LEFT JOIN teacher AS t ON tsg.personal_number = t.personal_number
WHERE sg.specialty = t.specialty;