# Write your MySQL query statement below
select id , visit_date , people from Stadium 
WHERE id IN (
    SELECT s1.id 
    FROM stadium s1
    JOIN stadium s2 ON s1.id=s2.id-1
    JOIN stadium s3 ON s2.id=s3.id-1
    WHERE s1.people>=100 AND s2.people>=100 AND s3.people>=100

    UNION
    SELECT s2.id
    FROM stadium s1
    JOIN stadium s2 ON s1.id=s2.id-1
    JOIN stadium s3 ON s2.id=s3.id-1
    WHERE s1.people>=100 AND s2.people>=100 AND s3.people>=100

    union 
    select s3.id
    FROM stadium s1
    JOIN stadium s2 ON s1.id=s2.id-1
    JOIN stadium s3 ON s2.id=s3.id-1
    WHERE s1.people>=100 AND s2.people>=100 AND s3.people>=100
)
group by visit_date;
