SELECT *
FROM teacher
WHERE position = 'Доцент' AND personal_number IN (
    SELECT personal_number
    FROM teacher_student_group
    WHERE student_group_code = '3Г'
)
AND personal_number IN (
    SELECT personal_number
    FROM teacher_student_group
    WHERE student_group_code = '8Г'
);