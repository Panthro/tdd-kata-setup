-- Create the notes table
CREATE TABLE notes
(
    id       uuid PRIMARY KEY,
    title    VARCHAR(255)          NOT NULL,
    content  TEXT                  NOT NULL,
    archived BOOLEAN DEFAULT FALSE NOT NULL
);
