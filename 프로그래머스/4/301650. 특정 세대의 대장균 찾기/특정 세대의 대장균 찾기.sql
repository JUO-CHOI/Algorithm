WITH RECURSIVE GENERATION AS (
    # 재귀 초기 설정 -> 1세대 대장균
    SELECT 
        ID,
        PARENT_ID,
        1 AS GEN
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT
        d.ID,
        d.PARENT_ID,
        g.GEN + 1
        FROM ECOLI_DATA AS d
        JOIN GENERATION AS g
            ON d.PARENT_ID = g.ID
)

SELECT ID
FROM GENERATION
WHERE GEN = 3
ORDER BY ID;