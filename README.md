## Database schema

| Name                       | Type     | Schema                                                                                                                                                                                                                                                                                                                                                      |
|----------------------------|----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **cook**                   |          | CREATE TABLE cook (cid INTEGER PRIMARY KEY, first_name VARCHAR                                                                                                                                                                                                                                                                                              |
| cid                        | INTEGER  | NOT NULL, last_name VARCHAR NOT NULL, is_active BOOLEAN)                                                                                                                                                                                                                                                                                                    |
| first_name                 | VARCHAR  | "first_name"                                                                                                                                                                                                                                                                                                                                                |
| last_name                  | VARCHAR  | "last_name"                                                                                                                                                                                                                                                                                                                                                 |
| is_active                  | BOOLEAN  | "is_active"                                                                                                                                                                                                                                                                                                                                                 |
| **dish**                   |          | CREATE TABLE dish (did INTEGER PRIMARY KEY, name VARCHAR NOT NULL, discription VARCHAR, price DOUBLE, rate INTEGER, rate_count INTEGER, time_to_prepare_in_minutes integer, is_available BOOLEAN, image BLOB)                                                                                                                                               |
| did                        | INTEGER  | "did"                                                                                                                                                                                                                                                                                                                                                       |
| name                       | VARCHAR  | "name"                                                                                                                                                                                                                                                                                                                                                      |
| discription                | VARCHAR  | "discription"                                                                                                                                                                                                                                                                                                                                               |
| price                      | DOUBLE   | "price"                                                                                                                                                                                                                                                                                                                                                     |
| rate                       | INTEGER  | "rate"                                                                                                                                                                                                                                                                                                                                                      |
| rate_count                 | INTEGER  | "rate_count"                                                                                                                                                                                                                                                                                                                                                |
| time_to_prepare_in_minutes | integer  | "time_to_prepare_in_minutes"                                                                                                                                                                                                                                                                                                                                |
| is_available               | BOOLEAN  | "is_available"                                                                                                                                                                                                                                                                                                                                              |
| image                      | BLOB     | "image"                                                                                                                                                                                                                                                                                                                                                     |
| **order_dishes**           |          | CREATE TABLE order_dishes (oid INTEGER, did INTEGER,CONSTRAINT fk_order FOREIGN KEY (oid) REFERENCES orders(oid),CONSTRAINT fk_dish FOREIGN KEY (did) REFERENCES dish(did),PRIMARY KEY (oid, did))                                                                                                                                                          |
| oid                        | INTEGER  | "oid"                                                                                                                                                                                                                                                                                                                                                       |
| did                        | INTEGER  | "did"                                                                                                                                                                                                                                                                                                                                                       |
| **orders**                 |          | CREATE TABLE orders (oid INTEGER PRIMARY KEY,did INTEGER, cid INTEGER, tid INTEGER, total_price DOUBLE, state VARCHAR, order_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP, CONSTRAINT fk_dish FOREIGN KEY (did) REFERENCES dish(did),CONSTRAINT fk_cook FOREIGN KEY (cid) REFERENCES cook(cid),CONSTRAINT fk_dish FOREIGN KEY (tid) REFERENCES tables(tid)) |
| oid                        | INTEGER  | "oid"                                                                                                                                                                                                                                                                                                                                                       |
| did                        | INTEGER  | "did"                                                                                                                                                                                                                                                                                                                                                       |
| cid                        | INTEGER  | "cid"                                                                                                                                                                                                                                                                                                                                                       |
| tid                        | INTEGER  | "tid"                                                                                                                                                                                                                                                                                                                                                       |
| total_price                | DOUBLE   | "total_price"                                                                                                                                                                                                                                                                                                                                               |
| state                      | VARCHAR  | "state"                                                                                                                                                                                                                                                                                                                                                     |
| order_timestamp            | DATETIME | "order_timestamp"                                                                                                                                                                                                                                                                                                                                           |
| **tables**                 |          | CREATE TABLE tables (tid INTEGER PRIMARY KEY)                                                                                                                                                                                                                                                                                                               |
| tid                        | INTEGER  | "tid"                                                                                                                                                                                                                                                                                                                                                       |