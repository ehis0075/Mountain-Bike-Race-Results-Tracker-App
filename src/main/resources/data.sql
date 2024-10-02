-- Insert Riders
INSERT INTO rider (name) VALUES ('John Doe');
INSERT INTO rider (name) VALUES ('Jane Smith');
INSERT INTO rider (name) VALUES ('Mark Johnson');
INSERT INTO rider (name) VALUES ('Emily Davis');
INSERT INTO rider (name) VALUES ('Luke Wilson');

-- Insert Race
INSERT INTO race (name, location, date) VALUES ('Mountain Bike Challenge', 'Highland Park', '2024-10-10');

-- Insert Race Results
-- Rider 1 finished in 120.5 seconds, position 2
INSERT INTO race_result (rider_id, race_id, race_time, did_finish, position)
VALUES ((SELECT id FROM rider WHERE name = 'John Doe'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        120.5, true, 2);

-- Rider 2 finished in 115.7 seconds, position 1
INSERT INTO race_result (rider_id, race_id, race_time, did_finish, position)
VALUES ((SELECT id FROM rider WHERE name = 'Jane Smith'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        115.7, true, 1);

-- Rider 3 finished in 130.2 seconds, position 4
INSERT INTO race_result (rider_id, race_id, race_time, did_finish, position)
VALUES ((SELECT id FROM rider WHERE name = 'Mark Johnson'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        130.2, true, 4);

-- Rider 4 did not finish, position NULL
INSERT INTO race_result (rider_id, race_id, race_time, did_finish, position)
VALUES ((SELECT id FROM rider WHERE name = 'Emily Davis'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        NULL, false, NULL);

-- Rider 5 finished in 125.9 seconds, position 3
INSERT INTO race_result (rider_id, race_id, race_time, did_finish, position)
VALUES ((SELECT id FROM rider WHERE name = 'Luke Wilson'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        125.9, true, 3);
