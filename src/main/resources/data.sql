insert into institution(id, name, description) values (1, 'Fundacja "Dbam o Zdrowie"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin'), (2, 'Fundacja "A kogo"', 'Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki.'), (3, 'Fundacja “Dla dzieci"', 'Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.'), (4, 'Fundacja "Bez domu"', 'Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania.'), (5, 'Fundacja "Bez domu"', 'Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania.');
insert into donation(id, city, pickup_comment, pickup_date, pickup_time, quantity, street, zip_code, institution_id) values (1, 'Pzn', 'd', current_date, current_time, 10, 'str', '432-2', 1), (2, 'Pzn', 'd', current_date, current_time, 10, 'str', '432-2', 1);
INSERT INTO category(id, name) VALUES (1, 'ubrania, które nadają się do ponownego użycia'), (2, 'ubrania do wyrzucenia'), (3, 'zabawki'), (4, 'książki'), (5, 'inne');