SELECT
    a.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY,
    SUM(b.PRICE * s.SALES) AS SALES
FROM BOOK b
JOIN AUTHOR a
    ON b.AUTHOR_ID = a.AUTHOR_ID
JOIN BOOK_SALES s
    ON b.BOOK_ID = s.BOOK_ID
WHERE DATE_FORMAT(s.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY b.CATEGORY, a.AUTHOR_ID, a.AUTHOR_NAME
ORDER BY a.AUTHOR_ID ASC, b.CATEGORY DESC;