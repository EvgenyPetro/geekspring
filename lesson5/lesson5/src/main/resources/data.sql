INSERT INTO USR (ID, USERNAME, PASSWORD, EMAIL, ROLE)
VALUES (1, 'Evgen1', 'qwertt1', 'mail1@mail.ru', 'admin'),
       (2, 'Evgen2', 'qwertt2', 'mail2@mail.ru', 'user'),
       (3, 'Evgen3', 'qwertt3', 'mail3@mail.ru', 'user');


INSERT INTO PROJECT (ID, NAME, DESCRIPTION, CREATED_DATE)
VALUES (1, 'Application1', 'new Project1', CURRENT_DATE),
       (2, 'Application2', 'new Project2', CURRENT_DATE),
       (3, 'Application3', 'new Project3', CURRENT_DATE);


INSERT INTO USER_PROJECT (ID, USER_ID, PROJECT_ID, DTYPE)
VALUES (1, 1, 1, 'UsersProject'),
       (2, 1, 2, 'UsersProject'),
       (3, 2, 1, 'UsersProject'),
       (4, 3, 2, 'UsersProject'),
       (5, 3, 3, 'UsersProject');
