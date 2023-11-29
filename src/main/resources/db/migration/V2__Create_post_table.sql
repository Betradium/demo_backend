CREATE TABLE post
(
    id SERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    topicId INT,
    CONSTRAINT fk_topic FOREIGN KEY(topicId) REFERENCES topic(id) ON DELETE CASCADE
)