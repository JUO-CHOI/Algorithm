SELECT
    b.CATEGORY AS CATEGORY,
    SUM(s.SALES) AS TOTAL_SALES
FROM BOOK AS b
JOIN BOOK_SALES AS s
    ON b.BOOK_ID = s.BOOK_ID
WHERE s.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY CATEGORY
ORDER BY CATEGORY ASC;