SELECT DISTINCT sg.specialty
FROM student_group AS sg
         left join teacher_student_group AS tsg ON sg.student_group_code = tsg.student_group_code
         left join teacher AS t ON tsg.personal_number = t.personal_number
WHERE t.chair = 'АСУ';