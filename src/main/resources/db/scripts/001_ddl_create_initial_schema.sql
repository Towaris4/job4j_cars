CREATE TABLE ads (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    car_brand VARCHAR(100) NOT NULL,
    body_type VARCHAR(50) NOT NULL,
    photo_url VARCHAR(500),
    is_sold BOOLEAN DEFAULT FALSE
);

CREATE TABLE auto_user (
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE auto_post (
    id SERIAL PRIMARY KEY,
    description TEXT,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    auto_user_id INT NOT NULL REFERENCES auto_user(id)
);