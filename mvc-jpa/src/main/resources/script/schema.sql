create table if not exists `Users`
(
    `user_id`   bigint      not null,
    `user_name` varchar(50) not null,

    PRIMARY KEY Users (user_id)
)
