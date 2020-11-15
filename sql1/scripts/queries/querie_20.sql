SELECT DISTINCT personal_number
FROM teacher_student_group AS tsg
         LEFT JOIN student_group AS sg ON tsg.student_group_code = sg.student_group_code
         left join subject AS s ON tsg.subject_code_number = s.subject_code_number
WHERE sg.specialty = s.specialty;