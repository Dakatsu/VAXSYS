-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS "public"."account";
CREATE TABLE "public"."account" (
                                    "id" int4 NOT NULL DEFAULT nextval('account_id_seq'::regclass),
                                    "username" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
                                    "first_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
                                    "last_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
                                    "password" varchar(500) COLLATE "pg_catalog"."default" NOT NULL,
                                    "email" varchar(150) COLLATE "pg_catalog"."default",
                                    "role_id" int4,
                                    "enabled" bool
)
;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS "public"."appointment";
CREATE TABLE "public"."appointment" (
                                        "id" int4 NOT NULL,
                                        "vaccine_center_id" int4,
                                        "patient_id" int4,
                                        "vaccine_id" int4,
                                        "time" date
)
;

-- ----------------------------
-- Table structure for disease
-- ----------------------------
DROP TABLE IF EXISTS "public"."disease";
CREATE TABLE "public"."disease" (
                                    "id" int4 NOT NULL,
                                    "name" varchar(255) COLLATE "pg_catalog"."default",
                                    "description" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for patient_disease
-- ----------------------------
DROP TABLE IF EXISTS "public"."patient_disease";
CREATE TABLE "public"."patient_disease" (
                                            "id" int4 NOT NULL,
                                            "patient_id" int4 NOT NULL,
                                            "disease_id" int4 NOT NULL
)
;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS "public"."role";
CREATE TABLE "public"."role" (
                                 "id" int4 NOT NULL DEFAULT nextval('role_id_seq'::regclass),
                                 "name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for vaccine
-- ----------------------------
DROP TABLE IF EXISTS "public"."vaccine";
CREATE TABLE "public"."vaccine" (
                                    "id" int4 NOT NULL DEFAULT nextval('vaccine_id_seq'::regclass),
                                    "name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
                                    "description" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for vaccine_center
-- ----------------------------
DROP TABLE IF EXISTS "public"."vaccine_center";
CREATE TABLE "public"."vaccine_center" (
                                           "id" int4 NOT NULL,
                                           "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
                                           "address" varchar(255) COLLATE "pg_catalog"."default",
                                           "contact" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Primary Key structure for table account
-- ----------------------------
ALTER TABLE "public"."account" ADD CONSTRAINT "account_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table appointment
-- ----------------------------
ALTER TABLE "public"."appointment" ADD CONSTRAINT "appointment_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table disease
-- ----------------------------
ALTER TABLE "public"."disease" ADD CONSTRAINT "disease_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table patient_disease
-- ----------------------------
ALTER TABLE "public"."patient_disease" ADD CONSTRAINT "patient_disease_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table role
-- ----------------------------
ALTER TABLE "public"."role" ADD CONSTRAINT "role_name_key" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table role
-- ----------------------------
ALTER TABLE "public"."role" ADD CONSTRAINT "role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vaccine
-- ----------------------------
ALTER TABLE "public"."vaccine" ADD CONSTRAINT "vaccine_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vaccine_center
-- ----------------------------
ALTER TABLE "public"."vaccine_center" ADD CONSTRAINT "vaccine_center_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table account
-- ----------------------------
ALTER TABLE "public"."account" ADD CONSTRAINT "account_role_id_fkey" FOREIGN KEY ("role_id") REFERENCES "public"."role" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;