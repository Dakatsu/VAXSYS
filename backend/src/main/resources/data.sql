INSERT INTO role VALUES(1, 'ADMIN');
INSERT INTO role VALUES(2, 'PATIENT');
INSERT INTO role VALUES(3, 'NURSE');
INSERT INTO role VALUES(4, 'VENDOR');

--admin password: Soen6471$
INSERT INTO account (id, username, first_name, last_name, password, email, role_id)
VALUES (1, 'VAXSYS Admin', 'System', 'Admin', '$2a$10$oe.quRiUdDksJXqfNdZ2BO0g0EsPaRSkNDaghoa8AxIar3PEruTNq', 'vaxsysadmin@gmail.com', 1);

INSERT INTO "public"."slot" VALUES (3, 'time3', 1, 't');
INSERT INTO "public"."slot" VALUES (4, 'time1', 2, 't');
INSERT INTO "public"."slot" VALUES (5, 'time2', 2, 't');
INSERT INTO "public"."slot" VALUES (6, 'time3 ', 2, 't');
INSERT INTO "public"."slot" VALUES (2, 'time2', 1, 't');
INSERT INTO "public"."slot" VALUES (1, 'time1', 1, 't');