SELECT d.director_id,
       d.name,
       d.surname,
       d.birth_date,
       AVG(box_office / budget) as profit_multiplier,
       AVG(box_office - budget) as profit_average
FROM director d
         LEFT JOIN title t on d.director_id = t.director_id
GROUP BY d.director_id, d.name, d.surname, d.birth_date
ORDER BY d.surname
