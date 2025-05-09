# 시간대 만들기
WITH RECURSIVE HOURS AS (
    SELECT 0 AS HOUR
    
    UNION ALL
    
    SELECT HOUR + 1
    FROM HOURS
    WHERE HOUR < 23
)

SELECT
    h.HOUR,
    COUNT(o.ANIMAL_ID) AS COUNT
FROM HOURS h
LEFT JOIN ANIMAL_OUTS AS o
    ON h.HOUR = HOUR(o.DATETIME)
GROUP BY HOUR
ORDER BY HOUR;