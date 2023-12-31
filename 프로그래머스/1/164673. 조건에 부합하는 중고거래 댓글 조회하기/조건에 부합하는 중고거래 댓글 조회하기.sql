-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD `b` JOIN USED_GOODS_REPLY `r` ON b.BOARD_ID = r.BOARD_ID
WHERE b.CREATED_DATE BETWEEN '2022-10-01' AND '2022-10-31'
ORDER BY r.CREATED_DATE ASC, b.TITLE ASC;