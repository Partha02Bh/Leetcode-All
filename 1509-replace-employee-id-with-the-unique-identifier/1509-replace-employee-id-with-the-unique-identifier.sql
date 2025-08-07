# Write your MySQL query statement below
select EmployeeUNI.unique_id, Employees.name 
from Employees
Left JOIN EmployeeUNI
on Employees.id = EmployeeUNI.id





-- SELECT
-- EmployeeUNI.unique_id, Employees.name
-- FROM Employees
-- LEFT JOIN EmployeeUNI on Employees.id = EmployeeUNI.id