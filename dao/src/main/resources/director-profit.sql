SELECT director.*,
       AVG(box_office / budget) as profit_multiplier,
       AVG(box_office - budget) as profit_average
FROM director
         LEFT JOIN title t on director.director_id = t.director_id
GROUP BY director.director_id