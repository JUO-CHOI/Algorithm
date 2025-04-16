SELECT DISTINCT
    d.ID,
    d.EMAIL,
    d.FIRST_NAME,
    d.LAST_NAME
FROM DEVELOPERS AS d
JOIN SKILLCODES AS s
    ON (d.SKILL_CODE & s.CODE) > 0 # 일단 가진 기술 다 매칭 
    AND s.CATEGORY = 'Front End'
ORDER BY d.ID;