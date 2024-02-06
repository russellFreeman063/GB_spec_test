# Итоговая контрольная работа

### 1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы, а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).

cat > Домашние_животные
Собаки
Кошки
Хомяки

cat > Вьючные_животные
Лошади
Верблюды
Ослы

cat > Домашние_животные Вьючные_животные > Животные
cat Животные
mv Животные Друзья_человека

### 2. Создать директорию, переместить файл туда.

mkdir task2
mv Друзья_человека task2/

### 3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

wget https://dev.mysql.com/get/mysql-apt-config_0.8.29-1_all.deb
sudo dpkg -i mysql-apt-config_0.8.29-1_all.deb
sudo apt install mysql-server

### 4. Установить и удалить deb-пакет с помощью dpkg.

wget http://ftp.de.debian.org/debian/pool/main/c/chromium/chromium_121.0.6167.85-1_amd64.deb
sudo dpkg -i chromium_121.0.6167.85-1_amd64.deb
sudo dpkg -r chromium

### 5. Выложить историю команд в терминале ubuntu.

448  mkdir spec

449  cd spec

450  cat > Домашние_животные

451  cat > Вьючные_Животные

452  cat Домашние_животные Вьючные_животные > Животные

453  cat Животные

454  mv Животные Друзья_человека

455  mkdir task2

456  mv Друзья_человека task2/

457  wget https://dev.mysql.com/get/mysql-apt-config_0.8.29-1_all.deb

458  sudo dpkg -i mysql-apt-config_0.8.29-1_all.deb

459  sudo apt install mysql-server

460  wget http://ftp.de.debian.org/debian/pool/main/c/chromium/chromium_121.0.6167.85-1_amd64.deb

461  sudo dpkg -i chromium_121.0.6167.85-1_amd64.deb

462  sudo dpkg -r chromium

463  history

### 6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы.

![diagram](images/diagram.png)

### 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

DROP DATABASE IF EXISTS human_friends;

CREATE DATABASE human_friends;

### 8. Создать таблицы с иерархией из диаграммы в БД

USE human_friends;

DROP TABLE IF EXISTS animal;

CREATE TABLE animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(20) 
);

DROP TABLE IF EXISTS pet;

CREATE TABLE pet (
	id INT AUTO_INCREMENT PRIMARY KEY,
	type VARCHAR(20),
	id_pet INT,
	FOREIGN KEY (id_pet) REFERENCES animal(id)
);

DROP TABLE IF EXISTS pack_animal;

CREATE TABLE pack_animal (
	id INT AUTO_INCREMENT PRIMARY KEY,
	type VARCHAR(20),
	id_pack INT,
	FOREIGN KEY (id_pack) REFERENCES animal(id)
);

DROP TABLE IF EXISTS dog;

CREATE TABLE dog (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20),
	command VARCHAR(20),
	birthday DATE,
	id_dog INT,
	FOREIGN KEY (id_dog) REFERENCES pet(id)
);

DROP TABLE IF EXISTS cat;

CREATE TABLE cat (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20),
	command VARCHAR(20),
	birthday DATE,
	id_cat INT,
	FOREIGN KEY (id_cat) REFERENCES pet(id)
);

DROP TABLE IF EXISTS hamster;

CREATE TABLE hamster (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20),
	command VARCHAR(20),
	birthday DATE,
	id_hamster INT,
	FOREIGN KEY (id_hamster) REFERENCES pet(id)
);

DROP TABLE IF EXISTS horse;

CREATE TABLE horse ( 
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(20), 
    command VARCHAR(20), 
    birthday DATE, 
    id_horse INT, 
    FOREIGN KEY (id_horse) REFERENCES pack_animal(id) 
);

DROP TABLE IF EXISTS camel;

CREATE TABLE camel ( 
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(20), 
    command VARCHAR(20), 
    birthday DATE, 
    id_camel INT, 
    FOREIGN KEY (id_camel) REFERENCES pack_animal(id) 
);

DROP TABLE IF EXISTS donkey;

CREATE TABLE donkey ( 
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(20), 
    command VARCHAR(20), 
    birthday DATE, 
    id_donkey INT, 
    FOREIGN KEY (id_donkey) REFERENCES pack_animal(id)
);

### 9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

INSERT INTO animal (type)
VALUES ('pet'), ('pack animal');

INSERT INTO pet (type, id_pet)
VALUES ('dog', 1), ('cat', 1), ('hamster', 1);

INSERT INTO pack_animal (type, id_pack)
VALUES ('horse, 2), ('camel', 2), ('donkey', 2);

INSERT INTO dog (name, command, birthday, id_dog)
VALUES ('Jack', 'Stand', '2020-10-03', 1), ('Max', 'Sit', '2022-01-04', 1);

INSERT INTO cat (name, command, birthday, id_cat)
VALUES ('Ann', 'Jump', '2021-11-08', 2), ('Mary', 'Come', '2022-09-02', 2);

INSERT INTO hamster (name, command, birthday, id_hamster)
VALUES ('Rob', 'Eat', '2021-10-10', 3), ('Chip', 'Hide', '2022-08-03', 3);

INSERT INTO horse (name, command, birthday, id_horse) 
VALUES ('Light', 'Run', '2020-01-05', 1), ('Flash', 'Jump', '2018-11-01', 1);

INSERT INTO camel (name, command, birthday, id_camel) 
VALUES ('Kid', 'Sit', '2018-02-11', 2), ('Steam', 'Go', '2019-03-08', 2);

INSERT INTO donkey (name, command, birtday, id_donkey) 
VALUES ('Gibble', 'Stay', '2017-10-10', 3), ('Bob', 'Come', '2021-08-01', 3);

### 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

SET SQL_SAFE_UPDATES = 0;

DELETE FROM camel;

SELECT * FROM horse

UNION SELECT * FROM donkey;

### 11.Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

DROP TABLE IF EXISTS young_animal;

CREATE TABLE young_animal
SELECT * from dog
WHERE TIMESTAMPDIFF(month, birthday, now()) > 12 and TIMESTAMPDIFF(month, birthday, now()) < 36
UNION SELECT * FROM cat
WHERE TIMESTAMPDIFF(month, birthday, now()) > 12 and TIMESTAMPDIFF(month, birthday, now()) < 36
UNION SELECT * FROM hamster
WHERE TIMESTAMPDIFF(month, birthday, now()) > 12 and TIMESTAMPDIFF(month, birthday, now()) < 36
UNION SELECT * FROM horse
WHERE TIMESTAMPDIFF(month, birthday, now()) > 12 and TIMESTAMPDIFF(month, birthday, now()) < 36
UNION SELECT * FROM camel
WHERE TIMESTAMPDIFF(month, birthday, now()) > 12 and TIMESTAMPDIFF(month, birthday, now()) < 36
UNION SELECT * FROM donkey
WHERE TIMESTAMPDIFF(month, birthday, now()) > 12 and TIMESTAMPDIFF(month, birthday, now()) < 36;

SELECT *, TIMESTAMPDIFF(month, birthday, now()) AS months FROM young_animal;

### 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

SELECT * FROM pet
UNION SELECT * FROM pack_animal
UNION SELECT * FROM dog
UNION SELECT * FROM cat
UNION SELECT * FROM hamster
UNION SELECT * FROM horse
UNION SELECT * FROM camel
UNION SELECT * FROM donkey;



