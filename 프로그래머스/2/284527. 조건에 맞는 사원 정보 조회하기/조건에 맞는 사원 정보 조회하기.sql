SELECT
    SUM(g.score) AS SCORE,
    e.emp_no AS EMP_NO,
    e.emp_name AS EMP_NAME,
    e.position AS POSITION,
    e.email AS EMAIL
FROM HR_EMPLOYEES AS e
LEFT JOIN HR_GRADE AS g
    ON e.emp_no = g.emp_no
GROUP BY EMP_NO
ORDER BY SCORE DESC
LIMIT 1;