SELECT *
FROM subject
WHERE subject_code_number NOT IN (
    SELECT tsg.subject_code_number
    FROM teacher_student_group AS tsg
             LEFT JOIN student_group AS sg ON sg.student_group_code = tsg.student_group_code
    WHERE sg.student_group_name = 'М-6'
);