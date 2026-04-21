# Write your MySQL query statement below
select m.name from Employee e 
join Employee m on m.id = e.managerId
group by (e.managerId)
having count(e.Id)>=5;