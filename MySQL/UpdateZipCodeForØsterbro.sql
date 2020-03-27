-- ------------------------------------------------------- --
-- Updates cities' zipcode to 2100 if the name is Østerbro --
-- ------------------------------------------------------- --
UPDATE mydb.city
SET city_zipcode = 2100
WHERE city_name = Østerbro;