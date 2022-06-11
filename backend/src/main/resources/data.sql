INSERT INTO role VALUES(1, 'ADMIN');
INSERT INTO role VALUES(2, 'PATIENT');
INSERT INTO role VALUES(3, 'NURSE');
INSERT INTO role VALUES(4, 'VENDOR');

--admin password: Soen6471$
INSERT INTO account (id, username, first_name, last_name, password, email, role_id)
VALUES (1, 'VAXSYS Admin', 'System', 'Admin', '$2a$10$oe.quRiUdDksJXqfNdZ2BO0g0EsPaRSkNDaghoa8AxIar3PEruTNq', 'vaxsysadmin@gmail.com', 1);