CREATE SCHEMA kameleoon;


CREATE TABLE kameleoon.users
(
    id UUID DEFAULT random_uuid(),
    login VARCHAR(256),
    password VARCHAR(256),
    CONSTRAINT pk_users_id PRIMARY KEY(id)
);

CREATE TABLE kameleoon.quotes
(
    id UUID DEFAULT random_uuid(),
    user_id UUID,
    content VARCHAR(1024),
    creation_date TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT pk_quotes_id PRIMARY KEY(id),
    CONSTRAINT fk_quotes_user_id FOREIGN KEY(user_id) REFERENCES kameleoon.users(id)
);

CREATE TABLE kameleoon.votes
(
    user_id UUID,
    quote_id UUID,
    vote TINYINT,
    date DATE,
    CONSTRAINT pk_votes_votes PRIMARY KEY(user_id, quote_id),
    CONSTRAINT fk_votes_user_id FOREIGN KEY(user_id) REFERENCES kameleoon.users(id),
    CONSTRAINT fk_votes_quote_id FOREIGN KEY(quote_id) REFERENCES kameleoon.quotes(id)
)