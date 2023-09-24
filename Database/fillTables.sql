INSERT INTO languages(id, language) VALUES (1, 'english');

INSERT INTO "role" (id, role)
VALUES (1, 'ADMIN'), (2, 'MODERATOR');

INSERT INTO "user" (login, password, email, account_verified, role_id)
VALUES
    ( 'newuserlogin', '$2a$10$HzGSQ/C.BsbmjQjQIQRX9eU6Vie2C2.9TCvuo7MNPLJNNWJz04wZu', 'user@gmail.com', true, 2),
    ( 'newuserlogi', '$2a$10$HzGSQ/C.BsbmjQjQIQRX9eU6Vie2C2.9TCvuo7MNPLJNNWJz04wZu', 'user@chnu.edu.ua', true, 2),
    ( 'newuserlog', '$2a$10$HzGSQ/C.BsbmjQjQIQRX9eU6Vie2C2.9TCvuo7MNPLJNNWJz04wZu', 'us.yuliana@chnu.edu.ua', true, 2),
    ( 'newuserlo', '$2a$10$HzGSQ/C.BsbmjQjQIQRX9eU6Vie2C2.9TCvuo7MNPLJNNWJz04wZu', 'u.user@chnu.edu.ua', true, 2),
    ( 'newuserl', '$2a$10$HzGSQ/C.BsbmjQjQIQRX9eU6Vie2C2.9TCvuo7MNPLJNNWJz04wZu', 'u.@gmail.com', true, 2),
    ( 'user-admin', '$2a$10$KrX9CF.o2qiBc5aDYJVn4.PHDQm5NQhno0nnEtM0jeHBIsmRqEMPS', 'user6996@gmail.com', true, 1);

INSERT INTO post (id, author_id, title, foreword, content, published_at, created_at, updated_at)
VALUES
    (8, 1, 'A', 'Travel', 'A 1.5 mile wide swath of winds gusting to around 95 mph created **tornado-like** damage along Kentucky Highway 259 in Edmons
on County. The winds, extending 3/4 of a mile north and south of Bee Spring, destroyed or heavily damaged several small outbuildings, tore
part of the roof off of one home, uprooted and snapped the trunks of numerous trees, and snapped around a dozen power poles. Several othe
r homes sustained roof damage, and wind-driven hail shredded vinyl siding on a number of buildings.', '2022-09-01 19:10:25-07', '2022-09-01 19:10:25-07', '2022-09-01 19:10:25-07'),
    (9, 1, 'B', 'Cooking', 'Cooking', '2022-09-02 19:10:25-07', '2022-09-01 19:10:25-07', '2022-09-01 19:10:25-07'),
    (10, 2, 'C', 'Programming', 'Programming', '2022-09-03 19:10:25-07', '2022-09-01 19:10:25-07', '2022-09-01 19:10:25-07'),
    (11, 1, 'D', 'News', 'News', '2022-09-04 19:10:25-07', '2022-09-01 19:10:25-07', '2022-09-01 19:10:25-07'),
    (12, 2, 'E', 'Sport', 'Sport', '2022-09-05 19:10:25-07', '2022-09-01 19:10:25-07', '2022-09-01 19:10:25-07'),
    (13, 1, 'F', 'Music', 'A 1.5 mile wide swath of winds gusting to around 95 mph created **tornado-like** damage along Kentucky Highway 259 in Edmons
on County. The winds, extending 3/4 of a mile north and south of Bee Spring, destroyed or heavily damaged several small outbuildings, tore
part of the roof off of one home, uprooted and snapped the trunks of numerous trees, and snapped around a dozen power poles. Several othe
r homes sustained roof damage, and wind-driven hail shredded vinyl siding on a number of buildings.', '2022-09-06 19:10:25-07', '2022-09-01 19:10:25-07', '2022-09-01 19:10:25-07'),
    (14, 2, 'G', 'Gaming', 'Gaming', '2022-09-07 19:10:25-07', '2022-09-01 19:10:25-07', '2022-09-01 19:10:25-07');
