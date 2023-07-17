--database name: webjournal
DROP TABLE IF EXISTS post, "user", "role", languages, mail_token, refresh_token;

CREATE TABLE "role"
(
    id SERIAL PRIMARY KEY,
    role VARCHAR(32) NOT NULL UNIQUE
);

CREATE TABLE languages
(
    id SERIAL PRIMARY KEY,
    language regconfig NOT NULL DEFAULT 'english'::regconfig
);

CREATE TABLE "user"
(
    id SERIAL PRIMARY KEY,
    login VARCHAR(64) NOT NULL UNIQUE,
    password VARCHAR(128) NOT NULL,
    email VARCHAR(256) UNIQUE,
    account_verified BOOLEAN NOT NULL,
    role_id INTEGER REFERENCES "role"(id) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);

CREATE TABLE post
(
    id SERIAL PRIMARY KEY,
    author_id INTEGER REFERENCES "user"(id) NOT NULL,
    title VARCHAR(128) NOT NULL,
    foreword VARCHAR(150) NOT NULL,
    content TEXT NOT NULL,
    published_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now(),
    ts_content tsvector GENERATED ALWAYS AS (to_tsvector('english', content)) STORED,
    ts_title tsvector GENERATED ALWAYS AS (to_tsvector('english', title)) STORED
);

CREATE TABLE mail_token
(
    id SERIAL PRIMARY KEY,
    token VARCHAR(128) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    expires_at TIMESTAMP NOT NULL,
    user_id INTEGER REFERENCES "user"(id) NOT NULL
);

CREATE TABLE refresh_token
(
    id SERIAL PRIMARY KEY,
    token VARCHAR(128) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT now(),
    expires_at TIMESTAMP NOT NULL,
    user_id INTEGER REFERENCES "user"(id) NOT NULL
);