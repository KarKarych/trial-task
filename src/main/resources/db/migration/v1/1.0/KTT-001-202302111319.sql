ALTER TABLE kameleoon.users ALTER COLUMN login VARCHAR(32);
ALTER TABLE kameleoon.users ALTER COLUMN password VARCHAR(60);

ALTER TABLE kameleoon.votes ADD COLUMN voteEnum VARCHAR(8);

UPDATE kameleoon.votes v1
 SET v1.voteEnum = (SELECT  CASE WHEN v2.vote = 1 THEN 'UP' ELSE 'DOWN' END
                     FROM kameleoon.votes v2
                     WHERE v2.user_id = v1.user_id AND v2.quote_id = v1.quote_id);

ALTER TABLE kameleoon.votes DROP COLUMN vote;

ALTER TABLE kameleoon.votes ALTER COLUMN voteEnum RENAME TO vote;

CREATE VIEW kameleoon.quotes_with_votes AS
SELECT  q.id AS id,
        q.user_id AS user_id,
        q.content AS content,
        q.creation_date AS creation_date,
        q.modified_date AS modified_date,
        SUM(CASE WHEN v.vote = 'UP'   THEN  1 ELSE 0 END) AS upvote_count,
        sum(CASE WHEN v.vote = 'DOWN' THEN  1 ELSE 0 END) AS downvote_count
 FROM   kameleoon.quotes q
   LEFT JOIN kameleoon.votes v
     ON q.id = v.quote_id
 GROUP BY q.id


