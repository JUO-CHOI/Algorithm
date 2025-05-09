SELECT
    i.ANIMAL_ID,
    i.NAME
FROM ANIMAL_INS AS i
JOIN ANIMAL_OUTS AS o
    ON i.ANIMAL_ID = o.ANIMAL_ID
ORDER BY TIMESTAMPDIFF(SECOND, i.DATETIME, o.DATETIME) DESC # o.DATETIME - i.DATETIME + 0
LIMIT 2;