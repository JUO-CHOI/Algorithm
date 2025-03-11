SELECT
    p.ID,
    COUNT(c.PARENT_ID) AS CHILD_COUNT
FROM ECOLI_DATA AS p
LEFT JOIN ECOLI_DATA AS c
    ON p.ID = c.PARENT_ID
GROUP BY p.ID
ORDER BY p.ID