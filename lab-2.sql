use labor_sql;

select * from printer 
where color = 'y'
order by price desc;

select * from ships
where length(name) - 2 = length(replace(name, 'e', ''));

select printer.model, product.maker, printer.price from printer
join product 
on printer.model = product.model
where printer.price > 300;

select c.country, s.class from ships as s
right join classes as c
on s.class = c.class
where c.country = 'USA';

select prod.maker from product as prod
join pc
on prod.model = pc.model
where pc.speed > 750;

select ship, battle,
case 
	when result = 'OK'
		then 'в порядку'
	when result = 'sunk'
		then 'затонувший'
	when result = 'damaged'
		then 'пошкоджений'
	else 'n/a'
end as result
from outcomes;

select prod.maker, min(p.price) from product as prod
join printer as p
on prod.model = p.model;

select prod.maker, max(pc.price)
from product as prod
join pc
on prod.model = pc.model
group by prod.maker;

select income.point, income.date, max(income.inc), max(outcome.out)
from income
join outcome on income.point = outcome.point
group by point, date;

select prod.type, prod.model, max(x.price)
from product as prod
join( 
select model, price from printer
union
select model, price from pc
union
select model, price from laptop) as x
on prod.model = x.model
group by prod.type;