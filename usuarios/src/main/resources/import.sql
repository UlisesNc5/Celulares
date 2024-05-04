
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('test1', '1234', 1,  'Test1', 'Test1', 'test.1@email.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('test2', '1234', 1,  'Test2', 'Test2', 'test.2@email.com');

INSERT INTO roles (name)  VALUES ('ROLE_USER');
INSERT INTO roles (name)  VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO usuarios_to_roles (user_id, roles_id) VALUES (2, 2);
INSERT INTO usuarios_to_roles (user_id, roles_id) VALUES (2, 1);