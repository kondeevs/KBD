SELECT DISTINCT student_group_code
FROM teacher_student_group
WHERE subject_code_number IN (
    SELECT DISTINCT tsg.subject_code_number
    FROM teacher_student_group AS tsg
             left join student_group AS sg ON tsg.student_group_code = sg.student_group_code
    WHERE sg.student_group_name = 'АС-8'
);