CREATE TABLE price_history (
   id SERIAL PRIMARY KEY,
   before BIGINT NOT NULL,
   after BIGINT NULL,
   auto_post_id INT NOT NULL REFERENCES auto_post(id),
   created TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);