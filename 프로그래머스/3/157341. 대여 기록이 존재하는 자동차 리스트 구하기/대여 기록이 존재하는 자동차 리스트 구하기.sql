SELECT
    DISTINCT r.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS r
JOIN CAR_RENTAL_COMPANY_CAR AS c
    ON r.CAR_ID = c.CAR_ID
WHERE
    MONTH(r.START_DATE) = 10 
    AND c.CAR_TYPE = '세단'
ORDER BY r.CAR_ID DESC;