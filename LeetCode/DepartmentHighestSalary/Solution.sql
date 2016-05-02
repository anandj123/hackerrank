# Write your MySQL query statement below

select 
   c.Name DepartmentName,
   a.Name,
   a.Salary
from Employee a
inner join (
    select
       a.DepartmentId,
       max(a.Salary) Salary
    from Employee a
    group by a.DepartmentId
) b
on a.DepartmentId = b.DepartmentId
and a.Salary = b.Salary
inner join Department c
on a.DepartmentId = c.Id