SELECT t.name,
       t.box_office,
       t.budget,
       t.premiere_date,
       t.runtime,
       t.title_id,
       d.director_id,
       CONCAT(d.name, ' ', d.surname) as director_full_name
FROM title t
         LEFT JOIN director d on d.director_id = t.director_id
GROUP BY t.title_id, t.name
ORDER BY t.name
