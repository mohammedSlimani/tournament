-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-01-11 00:37:56.037

-- tables
-- Table: auth
CREATE TABLE auth (
    username varchar(50) NOT NULL COMMENT 'used for logging in',
    password varchar(50) NOT NULL COMMENT 'used for logging in. Should be encrypted. Another field of salt should be added for more security but ... It is not needed. ',
    user_id int NOT NULL COMMENT 'to whom these informations belongs. ',
    CONSTRAINT auth_pk PRIMARY KEY (username)
) COMMENT 'One of the best practices is to separate the personal information from the authentication one for better scalability and easier maintainability ';

-- Table: match
CREATE TABLE `match` (
    id int NOT NULL AUTO_INCREMENT COMMENT 'id of the match',
    tournament_id int NOT NULL COMMENT 'to which tournament this match belongs ',
    team_a varchar(50) NOT NULL COMMENT 'name of one of the teams in this match',
    team_b varchar(50) NOT NULL COMMENT 'name of the other team ',
    score_a int NOT NULL COMMENT 'the score of the first team. The responsible is the only one who can enter it.',
    score_b int NOT NULL COMMENT 'the score of the second team. The responsible is the only one who can enter it.',
    date date NOT NULL COMMENT 'the date where this match has/will start',
    CONSTRAINT match_pk PRIMARY KEY (id)
) COMMENT 'Any match will be here, There are 3 cases:
1: a match with a date in the future, it is a planned match,
2 : a match with a date in the past and with null score: it is in the waiting list of the responsible so he can fill the results. 
3: a match with a date in the past and with not null values of the score: It is a match from history, gets saved for any viewer who wants to see how tournaments in the past went. ';

-- Table: teammates
CREATE TABLE teammates (
    id int NOT NULL AUTO_INCREMENT COMMENT 'id of the teammate',
    user_id int NOT NULL COMMENT 'foreign key from the user table. To separate teams from each other. ',
    name varchar(50) NOT NULL COMMENT 'Full name of the teammate',
    CONSTRAINT teammates_pk PRIMARY KEY (id)
) COMMENT 'This is where the Captain registers his teammates';

-- Table: tournament
CREATE TABLE tournament (
    id int NOT NULL AUTO_INCREMENT COMMENT 'The Version of the current tournament',
    date_start date NOT NULL COMMENT 'The date where this tournament first started',
    date_end date NULL COMMENT 'The time where the last match is played and the tournament is finished',
    registration_end date NOT NULL COMMENT 'the last date where users can register their teams. Teams after the date wont be accepted',
    CONSTRAINT tournament_pk PRIMARY KEY (id)
) COMMENT 'We have chosen to separate these two tables (tournament and match) from the others to save as less as possible informations about the previous tournaments.  ';

-- Table: user
CREATE TABLE user_acc (
    id int NOT NULL AUTO_INCREMENT COMMENT 'id of the user',
    team varchar(50) NULL COMMENT 'The name of the team of the captain. This field is null for admin and responsibles.  ',
    name varchar(50) NOT NULL COMMENT 'full name of the user',
    phone varchar(10) NOT NULL COMMENT 'Phone number 0612345678',
    type int NOT NULL DEFAULT 3 COMMENT '1: admin
2: responsible
3: captain ',
    CONSTRAINT user_pk PRIMARY KEY (id)
) COMMENT 'All the users are here, The type column is the one that is going to decide the role of the user. Normal users (captains) are going to be deleted after the end of every tournament. ';

-- foreign keys
-- Reference: Auth_user (table: auth)
ALTER TABLE auth ADD CONSTRAINT Auth_user FOREIGN KEY Auth_user (user_id)
    REFERENCES user_acc (id);

-- Reference: match_Tournament (table: match)
ALTER TABLE `match` ADD CONSTRAINT match_Tournament FOREIGN KEY match_Tournament (tournament_id)
    REFERENCES tournament (id);

-- Reference: teammates_user (table: teammates)
ALTER TABLE teammates ADD CONSTRAINT teammates_user FOREIGN KEY teammates_user (user_id)
    REFERENCES user_acc (id);

-- End of file.

