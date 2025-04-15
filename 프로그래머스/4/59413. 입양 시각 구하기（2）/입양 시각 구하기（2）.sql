WITH RECURSIVE hours AS (
  SELECT 0 AS HOUR
  UNION ALL
  SELECT HOUR + 1 FROM hours WHERE HOUR < 23
)
SELECT h.HOUR, COUNT(a.ANIMAL_ID) AS COUNT
FROM hours h
LEFT JOIN ANIMAL_OUTS a ON HOUR(a.DATETIME) = h.HOUR
GROUP BY h.HOUR
ORDER BY h.HOUR;