--Добавить таблицу пользователей
CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
    );

--Добавить таблицу цен
CREATE TABLE IF NOT EXISTS price (
                                     id SERIAL PRIMARY KEY,
                                     category VARCHAR(45) NOT NULL,
    time_from TIMESTAMP NOT NULL,
    time_to TIMESTAMP NOT NULL,
    price FLOAT NOT NULL
    );

--Добавить таблицу залов
CREATE TABLE IF NOT EXISTS halls (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL
    );

--Добавить таблицу мест
create table if not exists places (
                                      id SERIAL PRIMARY KEY,
                                      row INTEGER NOT NULL,
                                      place INTEGER NOT NULL,
                                      category INTEGER NOT NULL REFERENCES price(id) ON DELETE cascade,
    id_hall INTEGER NOT NULL REFERENCES halls(id) ON DELETE CASCADE
    );

--Добавить таблицу фильмов
CREATE TABLE IF NOT EXISTS films (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL,
    country VARCHAR(45) NOT NULL,
    date_from TIMESTAMP NOT NULL,
    date_to TIMESTAMP NOT NULL,
    genre VARCHAR(45) NOT NULL,
    duration TIME(4) NOT NULL,
    name_file VARCHAR(45) NOT NULL
    );

--Добавить таблицу сеансов
CREATE TABLE IF NOT EXISTS sessions (
                                        id SERIAL PRIMARY KEY,
                                        date TIMESTAMP NOT NULL,
                                        hall INTEGER NOT NULL REFERENCES halls(id) ON DELETE SET NULL,
    film INTEGER NOT NULL REFERENCES films(id) ON DELETE CASCADE
    );

--Добавить таблицу билетов
CREATE TABLE IF NOT EXISTS tickets (
                                       id SERIAL PRIMARY KEY,
                                       id_sessions INTEGER NOT null REFERENCES sessions(id) ON DELETE CASCADE,
    hall INTEGER NOT NULL REFERENCES halls(id) ON DELETE CASCADE,
    place INTEGER NOT NULL REFERENCES places(id) ON DELETE CASCADE,
    cost FLOAT,
    sold BOOLEAN NOT NULL DEFAULT false,
    id_users INTEGER REFERENCES users(id) ON DELETE SET NULL
    );
