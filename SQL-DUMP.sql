--
-- File generated with SQLiteStudio v3.2.1 on fre sep 25 22:42:38 2020
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: accommodation
DROP TABLE IF EXISTS accommodation;

CREATE TABLE accommodation (
    accommodation_id     BIGINT   NOT NULL,
    child_events         INTEGER,
    description          VARCHAR,
    distance_to_beach    SMALLINT,
    distance_to_center   SMALLINT,
    imageurl             VARCHAR,
    name                 VARCHAR,
    night_entertainment  INTEGER,
    pool                 INTEGER,
    rating               FLOAT    CHECK (rating >= 0 AND 
                                         rating <= 5),
    restaurant           INTEGER,
    customer_customer_id BIGINT,
    location_id          BIGINT,
    PRIMARY KEY (
        accommodation_id
    )
);

INSERT INTO accommodation (
                              accommodation_id,
                              child_events,
                              description,
                              distance_to_beach,
                              distance_to_center,
                              imageurl,
                              name,
                              night_entertainment,
                              pool,
                              rating,
                              restaurant,
                              customer_customer_id,
                              location_id
                          )
                          VALUES (
                              14,
                              1,
                              'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas efficitur urna vitae aliquet rhoncus. Nunc aliquam turpis sed porta pharetra. Nam scelerisque rhoncus urna. Phasellus et augue sem. Morbi consequat nec dolor ut scelerisque. Sed aliquet, est a auctor blandit, sapien lorem cursus est, a feugiat urna nisi ut neque. In sit amet elementum tellus. Pellentesque congue bibendum sem a accumsan. Suspendisse eu lectus placerat, dictum elit at, volutpat sapien. Donec sollicitudin in erat sed efficitur. Integer vel blandit urna.',
                              256,
                              483,
                              'http://www.newdesignfile.com/postpic/2009/07/american-modern-home_385211.jpg',
                              'Caren',
                              0,
                              1,
                              4.69028759002686,
                              1,
                              7,
                              2
                          );

INSERT INTO accommodation (
                              accommodation_id,
                              child_events,
                              description,
                              distance_to_beach,
                              distance_to_center,
                              imageurl,
                              name,
                              night_entertainment,
                              pool,
                              rating,
                              restaurant,
                              customer_customer_id,
                              location_id
                          )
                          VALUES (
                              15,
                              1,
                              'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas efficitur urna vitae aliquet rhoncus. Nunc aliquam turpis sed porta pharetra. Nam scelerisque rhoncus urna. Phasellus et augue sem. Morbi consequat nec dolor ut scelerisque. Sed aliquet, est a auctor blandit, sapien lorem cursus est, a feugiat urna nisi ut neque. In sit amet elementum tellus. Pellentesque congue bibendum sem a accumsan. Suspendisse eu lectus placerat, dictum elit at, volutpat sapien. Donec sollicitudin in erat sed efficitur. Integer vel blandit urna.',
                              900,
                              29,
                              'http://www.newdesignfile.com/postpic/2009/07/american-modern-home_385211.jpg',
                              'Carmella',
                              0,
                              0,
                              2.78314352035522,
                              1,
                              7,
                              2
                          );

INSERT INTO accommodation (
                              accommodation_id,
                              child_events,
                              description,
                              distance_to_beach,
                              distance_to_center,
                              imageurl,
                              name,
                              night_entertainment,
                              pool,
                              rating,
                              restaurant,
                              customer_customer_id,
                              location_id
                          )
                          VALUES (
                              16,
                              1,
                              'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas efficitur urna vitae aliquet rhoncus. Nunc aliquam turpis sed porta pharetra. Nam scelerisque rhoncus urna. Phasellus et augue sem. Morbi consequat nec dolor ut scelerisque. Sed aliquet, est a auctor blandit, sapien lorem cursus est, a feugiat urna nisi ut neque. In sit amet elementum tellus. Pellentesque congue bibendum sem a accumsan. Suspendisse eu lectus placerat, dictum elit at, volutpat sapien. Donec sollicitudin in erat sed efficitur. Integer vel blandit urna.',
                              803,
                              124,
                              'http://www.newdesignfile.com/postpic/2009/07/high-water-lake-house-dock_385213.jpg',
                              'Emma',
                              0,
                              0,
                              3.73208785057068,
                              0,
                              8,
                              3
                          );

INSERT INTO accommodation (
                              accommodation_id,
                              child_events,
                              description,
                              distance_to_beach,
                              distance_to_center,
                              imageurl,
                              name,
                              night_entertainment,
                              pool,
                              rating,
                              restaurant,
                              customer_customer_id,
                              location_id
                          )
                          VALUES (
                              17,
                              0,
                              'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas efficitur urna vitae aliquet rhoncus. Nunc aliquam turpis sed porta pharetra. Nam scelerisque rhoncus urna. Phasellus et augue sem. Morbi consequat nec dolor ut scelerisque. Sed aliquet, est a auctor blandit, sapien lorem cursus est, a feugiat urna nisi ut neque. In sit amet elementum tellus. Pellentesque congue bibendum sem a accumsan. Suspendisse eu lectus placerat, dictum elit at, volutpat sapien. Donec sollicitudin in erat sed efficitur. Integer vel blandit urna.',
                              882,
                              838,
                              'http://www.newdesignfile.com/postpic/2009/07/high-water-lake-house-dock_385213.jpg',
                              'Mella',
                              0,
                              0,
                              4.01253414154053,
                              0,
                              8,
                              3
                          );

INSERT INTO accommodation (
                              accommodation_id,
                              child_events,
                              description,
                              distance_to_beach,
                              distance_to_center,
                              imageurl,
                              name,
                              night_entertainment,
                              pool,
                              rating,
                              restaurant,
                              customer_customer_id,
                              location_id
                          )
                          VALUES (
                              18,
                              1,
                              'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas efficitur urna vitae aliquet rhoncus. Nunc aliquam turpis sed porta pharetra. Nam scelerisque rhoncus urna. Phasellus et augue sem. Morbi consequat nec dolor ut scelerisque. Sed aliquet, est a auctor blandit, sapien lorem cursus est, a feugiat urna nisi ut neque. In sit amet elementum tellus. Pellentesque congue bibendum sem a accumsan. Suspendisse eu lectus placerat, dictum elit at, volutpat sapien. Donec sollicitudin in erat sed efficitur. Integer vel blandit urna.',
                              472,
                              780,
                              'http://www.newdesignfile.com/postpic/2009/07/adobe-abandoned-house_385217.jpg',
                              'Calypso',
                              1,
                              0,
                              3.694016456604,
                              1,
                              9,
                              4
                          );

INSERT INTO accommodation (
                              accommodation_id,
                              child_events,
                              description,
                              distance_to_beach,
                              distance_to_center,
                              imageurl,
                              name,
                              night_entertainment,
                              pool,
                              rating,
                              restaurant,
                              customer_customer_id,
                              location_id
                          )
                          VALUES (
                              19,
                              0,
                              'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas efficitur urna vitae aliquet rhoncus. Nunc aliquam turpis sed porta pharetra. Nam scelerisque rhoncus urna. Phasellus et augue sem. Morbi consequat nec dolor ut scelerisque. Sed aliquet, est a auctor blandit, sapien lorem cursus est, a feugiat urna nisi ut neque. In sit amet elementum tellus. Pellentesque congue bibendum sem a accumsan. Suspendisse eu lectus placerat, dictum elit at, volutpat sapien. Donec sollicitudin in erat sed efficitur. Integer vel blandit urna.',
                              768,
                              920,
                              'http://www.newdesignfile.com/postpic/2009/07/adobe-abandoned-house_385217.jpg',
                              'Ula',
                              1,
                              1,
                              4.59099769592285,
                              0,
                              9,
                              4
                          );

INSERT INTO accommodation (
                              accommodation_id,
                              child_events,
                              description,
                              distance_to_beach,
                              distance_to_center,
                              imageurl,
                              name,
                              night_entertainment,
                              pool,
                              rating,
                              restaurant,
                              customer_customer_id,
                              location_id
                          )
                          VALUES (
                              20,
                              0,
                              'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas efficitur urna vitae aliquet rhoncus. Nunc aliquam turpis sed porta pharetra. Nam scelerisque rhoncus urna. Phasellus et augue sem. Morbi consequat nec dolor ut scelerisque. Sed aliquet, est a auctor blandit, sapien lorem cursus est, a feugiat urna nisi ut neque. In sit amet elementum tellus. Pellentesque congue bibendum sem a accumsan. Suspendisse eu lectus placerat, dictum elit at, volutpat sapien. Donec sollicitudin in erat sed efficitur. Integer vel blandit urna.',
                              12,
                              414,
                              'https://images.freeimages.com/images/large-previews/dae/houses-1527478.jpg',
                              'Josselyn',
                              1,
                              0,
                              0.19595897197723,
                              1,
                              10,
                              5
                          );

INSERT INTO accommodation (
                              accommodation_id,
                              child_events,
                              description,
                              distance_to_beach,
                              distance_to_center,
                              imageurl,
                              name,
                              night_entertainment,
                              pool,
                              rating,
                              restaurant,
                              customer_customer_id,
                              location_id
                          )
                          VALUES (
                              21,
                              0,
                              'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas efficitur urna vitae aliquet rhoncus. Nunc aliquam turpis sed porta pharetra. Nam scelerisque rhoncus urna. Phasellus et augue sem. Morbi consequat nec dolor ut scelerisque. Sed aliquet, est a auctor blandit, sapien lorem cursus est, a feugiat urna nisi ut neque. In sit amet elementum tellus. Pellentesque congue bibendum sem a accumsan. Suspendisse eu lectus placerat, dictum elit at, volutpat sapien. Donec sollicitudin in erat sed efficitur. Integer vel blandit urna.',
                              490,
                              836,
                              'https://images.freeimages.com/images/large-previews/dae/houses-1527478.jpg',
                              'Julianne',
                              0,
                              0,
                              1.8920886516571,
                              1,
                              10,
                              5
                          );


-- Table: booking
DROP TABLE IF EXISTS booking;

CREATE TABLE booking (
    booking_id           BIGINT   NOT NULL,
    all_inclusive        INTEGER,
    cost                 FLOAT    DEFAULT 1,
    date_from            VARCHAR,
    date_to              VARCHAR,
    extra_bed            INTEGER,
    full_board           INTEGER,
    half_board           INTEGER,
    number_of_adults     SMALLINT,
    number_of_kids       SMALLINT,
    customer_customer_id BIGINT,
    PRIMARY KEY (
        booking_id
    )
);

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        55,
                        1,
                        9402.208984375,
                        '16/02/2021',
                        '26/02/2021',
                        0,
                        0,
                        0,
                        2,
                        0,
                        9
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        56,
                        0,
                        14064.7841796875,
                        '02/03/2021',
                        '10/03/2021',
                        0,
                        0,
                        1,
                        2,
                        0,
                        10
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        58,
                        1,
                        6943.8212890625,
                        '25/03/2021',
                        '04/04/2021',
                        0,
                        0,
                        0,
                        2,
                        0,
                        7
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        59,
                        0,
                        4773.921875,
                        '25/03/2021',
                        '04/04/2021',
                        0,
                        1,
                        0,
                        2,
                        0,
                        8
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        60,
                        1,
                        8556.3564453125,
                        '12/03/2021',
                        '21/03/2021',
                        0,
                        0,
                        0,
                        2,
                        0,
                        9
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        61,
                        1,
                        5543.650390625,
                        '15/04/2021',
                        '26/04/2021',
                        0,
                        0,
                        0,
                        2,
                        0,
                        10
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        63,
                        0,
                        12236.4921875,
                        '12/02/2021',
                        '22/02/2021',
                        0,
                        0,
                        1,
                        2,
                        0,
                        7
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        64,
                        1,
                        7315.4150390625,
                        '02/04/2021',
                        '20/04/2021',
                        0,
                        0,
                        0,
                        2,
                        0,
                        8
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        65,
                        1,
                        4502.24951171875,
                        '20/04/2021',
                        '28/04/2021',
                        0,
                        0,
                        0,
                        2,
                        0,
                        9
                    );

INSERT INTO booking (
                        booking_id,
                        all_inclusive,
                        cost,
                        date_from,
                        date_to,
                        extra_bed,
                        full_board,
                        half_board,
                        number_of_adults,
                        number_of_kids,
                        customer_customer_id
                    )
                    VALUES (
                        66,
                        1,
                        10245.8642578125,
                        '08/03/2021',
                        '16/03/2021',
                        0,
                        0,
                        0,
                        2,
                        0,
                        10
                    );


-- Table: booking_rooms
DROP TABLE IF EXISTS booking_rooms;

CREATE TABLE booking_rooms (
    bookings_booking_id BIGINT NOT NULL,
    rooms_id            BIGINT NOT NULL
);

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              55,
                              32
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              56,
                              33
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              58,
                              35
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              59,
                              36
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              60,
                              37
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              61,
                              38
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              63,
                              40
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              64,
                              41
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              65,
                              43
                          );

INSERT INTO booking_rooms (
                              bookings_booking_id,
                              rooms_id
                          )
                          VALUES (
                              66,
                              44
                          );


-- Table: customer
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    customer_id BIGINT  NOT NULL,
    email       VARCHAR,
    password    VARCHAR,
    PRIMARY KEY (
        customer_id
    )
);

INSERT INTO customer (
                         customer_id,
                         email,
                         password
                     )
                     VALUES (
                         6,
                         'Juditha186@holidaymaker.io',
                         'password'
                     );

INSERT INTO customer (
                         customer_id,
                         email,
                         password
                     )
                     VALUES (
                         7,
                         'Florie189@holidaymaker.io',
                         'password'
                     );

INSERT INTO customer (
                         customer_id,
                         email,
                         password
                     )
                     VALUES (
                         8,
                         'Harri176@holidaymaker.io',
                         'password'
                     );

INSERT INTO customer (
                         customer_id,
                         email,
                         password
                     )
                     VALUES (
                         9,
                         'Junette26@holidaymaker.io',
                         'password'
                     );

INSERT INTO customer (
                         customer_id,
                         email,
                         password
                     )
                     VALUES (
                         10,
                         'Josi71@holidaymaker.io',
                         'password'
                     );

INSERT INTO customer (
                         customer_id,
                         email,
                         password
                     )
                     VALUES (
                         11,
                         'test@test.io',
                         'password'
                     );


-- Table: hibernate_sequence
DROP TABLE IF EXISTS hibernate_sequence;

CREATE TABLE hibernate_sequence (
    next_val BIGINT
);

INSERT INTO hibernate_sequence (
                                   next_val
                               )
                               VALUES (
                                   73
                               );

INSERT INTO hibernate_sequence (
                                   next_val
                               )
                               VALUES (
                                   73
                               );

INSERT INTO hibernate_sequence (
                                   next_val
                               )
                               VALUES (
                                   73
                               );

INSERT INTO hibernate_sequence (
                                   next_val
                               )
                               VALUES (
                                   73
                               );

INSERT INTO hibernate_sequence (
                                   next_val
                               )
                               VALUES (
                                   73
                               );


-- Table: location
DROP TABLE IF EXISTS location;

CREATE TABLE location (
    id   BIGINT  NOT NULL,
    name VARCHAR,
    PRIMARY KEY (
        id
    )
);

INSERT INTO location (
                         id,
                         name
                     )
                     VALUES (
                         1,
                         'Rarden'
                     );

INSERT INTO location (
                         id,
                         name
                     )
                     VALUES (
                         2,
                         'Steffenville'
                     );

INSERT INTO location (
                         id,
                         name
                     )
                     VALUES (
                         3,
                         'Stephan'
                     );

INSERT INTO location (
                         id,
                         name
                     )
                     VALUES (
                         4,
                         'Thompsonville'
                     );

INSERT INTO location (
                         id,
                         name
                     )
                     VALUES (
                         5,
                         'Coffeen'
                     );


-- Table: room
DROP TABLE IF EXISTS room;

CREATE TABLE room (
    id                             BIGINT   NOT NULL,
    number_of_beds                 SMALLINT NOT NULL,
    price                          FLOAT    NOT NULL,
    accommodation_accommodation_id BIGINT   NOT NULL,
    PRIMARY KEY (
        id
    )
);

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     32,
                     4,
                     6402.208984375,
                     14
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     33,
                     5,
                     13564.7841796875,
                     14
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     34,
                     6,
                     7348.806640625,
                     14
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     35,
                     6,
                     3943.821044921875,
                     14
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     36,
                     4,
                     3273.921875,
                     14
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     37,
                     6,
                     5556.3564453125,
                     15
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     38,
                     7,
                     2543.650146484375,
                     15
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     39,
                     2,
                     9512.5361328125,
                     15
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     40,
                     2,
                     11736.4921875,
                     15
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     41,
                     5,
                     4315.4150390625,
                     15
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     42,
                     3,
                     16569.13671875,
                     16
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     43,
                     4,
                     1502.2493896484375,
                     16
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     44,
                     5,
                     7245.8642578125,
                     16
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     45,
                     3,
                     7501.98974609375,
                     16
                 );

INSERT INTO room (
                     id,
                     number_of_beds,
                     price,
                     accommodation_accommodation_id
                 )
                 VALUES (
                     46,
                     4,
                     17949.37109375,
                     16
                 );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
