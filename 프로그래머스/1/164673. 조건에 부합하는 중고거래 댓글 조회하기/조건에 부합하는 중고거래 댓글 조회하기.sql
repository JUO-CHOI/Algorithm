SELECT ugb.TITLE, ugb.BOARD_ID, ugr.REPLY_ID, ugr.WRITER_ID, ugr.CONTENTS, DATE_FORMAT(ugr.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE FROM USED_GOODS_BOARD as ugb
INNER JOIN USED_GOODS_REPLY AS ugr ON ugb.BOARD_ID = ugr.BOARD_ID
WHERE ugb.CREATED_DATE >= '2022-10-01 00:00:00' AND ugb.CREATED_DATE < '2022-11-01 00:00:00'
ORDER BY ugr.CREATED_DATE ASC, ugb.TITLE ASC;