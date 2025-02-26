# SELECT 
#     i.item_id AS ITEM_ID,
#     i.item_name AS ITEM_NAME
# FROM ITEM_INFO AS i
# INNER JOIN ITEM_TREE AS t
#     ON i.item_id = t.item_id
# WHERE t.PARENT_ITEM_ID IS NULL
# ORDER BY ITEM_ID;

SELECT
    t.item_id AS ITEM_ID,
    i.item_name AS ITEM_NAME
FROM ITEM_TREE AS t
LEFT JOIN ITEM_INFO AS i
    ON t.item_id = i.item_id
WHERE t.parent_item_id IS NULL
ORDER BY ITEM_ID ASC;