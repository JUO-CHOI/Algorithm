SELECT
    p.product_code AS PRODUCT_CODE,
    SUM(p.price * o.sales_amount) AS SALES
FROM PRODUCT AS p
INNER JOIN OFFLINE_SALE AS o ON p.product_id = o.product_id
GROUP BY p.product_code
ORDER BY 
    SALES DESC,
    PRODUCT_CODE ASC;