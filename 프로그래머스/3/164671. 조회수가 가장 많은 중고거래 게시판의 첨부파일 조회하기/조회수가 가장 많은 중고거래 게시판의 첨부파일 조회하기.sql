SELECT
    CONCAT('/home/grep/src/', f.BOARD_ID, '/', f.FILE_ID, f.FILE_NAME, f.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE AS f
JOIN (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    ORDER BY `VIEWS` DESC
    LIMIT 1
) AS b
    ON f.BOARD_ID = b.BOARD_ID
ORDER BY f.FILE_ID DESC;