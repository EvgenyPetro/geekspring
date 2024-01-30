create table if not exists usr(
    ID INTEGER PRIMARY KEY,
    USERNAME VARCHAR(255),
    PASSWORD VARCHAR(255),
    EMAIL VARCHAR(255),
    ROLE VARCHAR(255)
);

create table IF NOT EXISTS project(
    id INTEGER PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    createdDate DATE
);

create table IF NOT EXISTS user_project
(
    id INTEGER PRIMARY KEY,
    userId INTEGER,
    projectId INTEGER
)