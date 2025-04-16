SELECT 
    H.HISTORY_ID,
    FLOOR(
        C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE) + 1) * 
        (1 - IFNULL(DP.DISCOUNT_RATE / 100, 0))
    ) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H 
  ON C.CAR_ID = H.CAR_ID
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP
  ON C.CAR_TYPE = DP.CAR_TYPE
 AND (
    (DATEDIFF(H.END_DATE, H.START_DATE) >= 90 AND DP.DURATION_TYPE = '90일 이상') OR
    (DATEDIFF(H.END_DATE, H.START_DATE) >= 30 AND DATEDIFF(H.END_DATE, H.START_DATE) < 90 AND DP.DURATION_TYPE = '30일 이상') OR
    (DATEDIFF(H.END_DATE, H.START_DATE) >= 7 AND DATEDIFF(H.END_DATE, H.START_DATE) < 30 AND DP.DURATION_TYPE = '7일 이상')
 )
WHERE C.CAR_TYPE = '트럭'
ORDER BY FEE DESC, H.HISTORY_ID DESC;