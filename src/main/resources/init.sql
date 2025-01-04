-- CREATE TABLE point (
--                        id SERIAL PRIMARY KEY,
--                        x DOUBLE PRECISION NOT NULL,
--                        y DOUBLE PRECISION NOT NULL,
--                        r DOUBLE PRECISION NOT NULL,
--                        got_it boolean not null
-- );
CREATE TABLE "users" (
                       id SERIAL PRIMARY KEY,
                       login varchar(255) UNIQUE,
                        password varchar(255)
);