SELECT subject_code_number, personal_number, student_group_code
FROM teacher_student_group
WHERE personal_number IN (
    SELECT personal_number
    FROM teacher
    WHERE chair = 'ЭВМ'
      AND specialty LIKE '%АСОИ%'
);