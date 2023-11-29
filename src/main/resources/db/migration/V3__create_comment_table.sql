CREATE TABLE comment
(
    id SERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    topicId INT,
    CONSTRAINT fk_topic FOREIGN KEY(topicId) REFERENCES topic(id) ON DELETE CASCADE,
    postId INT,
    CONSTRAINT fk_post FOREIGN KEY(postId) REFERENCES post(id) ON DELETE CASCADE
)