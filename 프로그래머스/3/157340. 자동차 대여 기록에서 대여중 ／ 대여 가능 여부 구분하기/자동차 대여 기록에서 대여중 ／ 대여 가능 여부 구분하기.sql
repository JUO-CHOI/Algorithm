SELECT DISTINCT
    a.CAR_ID,
    CASE
        WHEN b.CAR_ID IS NULL THEN '대여 가능'
        ELSE '대여중'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS a
LEFT JOIN (
    SELECT * 
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
) AS b
    ON a.CAR_ID = b.CAR_ID
ORDER BY CAR_ID DESC;