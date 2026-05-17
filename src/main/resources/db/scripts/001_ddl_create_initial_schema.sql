CREATE TABLE ads (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT NOT NULL,
    car_brand VARCHAR(100) NOT NULL,
    body_type VARCHAR(50) NOT NULL,
    photo_url VARCHAR(500),
    is_sold BOOLEAN DEFAULT FALSE,
);