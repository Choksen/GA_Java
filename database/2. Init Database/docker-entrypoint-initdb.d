CREATE TABLE IF NOT EXISTS people (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
                                       birthday DATE NOT NULL);

CREATE TABLE IF NOT EXISTS letters (
                                       id SERIAL PRIMARY KEY,
                                       topic VARCHAR(20) NOT NULL,
                                       text TEXT NOT NULL,
                                       date DATE NOT NULL,
                                       sender INTEGER NOT NULL,
                                       recipient INTEGER NOT NULL,
                                       FOREIGN KEY (sender) REFERENCES people(id),
                                       FOREIGN KEY (recipient) REFERENCES people(id)
);

CREATE TABLE IF NOT EXISTS subject (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(20) UNIQUE NOT NULL,
                                       count_students INTEGER NOT NULL,
                                       auditorium INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS teacher (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
                                       subject INTEGER NOT NULL,
                                       count_subject INTEGER NOT NULL,
                                       FOREIGN KEY (subject) REFERENCES subject(id)
);

CREATE TABLE IF NOT EXISTS schedule(
                                       id SERIAL PRIMARY KEY,
                                       teacher_subject INTEGER NOT NULL,
                                       day VARCHAR(30) NOT NULL,
                                       time INTEGER NOT NULL
                                           CHECK (time >= 8 and time <= 23),
                                       FOREIGN KEY (teacher_subject) REFERENCES teacher(id)
);