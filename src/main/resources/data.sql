-- Insert Riders
INSERT INTO rider (name) VALUES ('Tayo Ola');
INSERT INTO rider (name) VALUES ('Bayo Cane');
INSERT INTO rider (name) VALUES ('Mark Johnson');
INSERT INTO rider (name) VALUES ('Emily Davis');
INSERT INTO rider (name) VALUES ('Luke Wilson');
INSERT INTO rider (name) VALUES ('Sarah Connor');

-- Insert Races
INSERT INTO race (name, location, date) VALUES ('Mountain Bike Challenge', 'Highland Park', '2024-10-10');
INSERT INTO race (name, location, date) VALUES ('Cross-Country Adventure', 'Cedar Woods', '2024-11-15');
INSERT INTO race (name, location, date) VALUES ('Forest Trail Race', 'Evergreen Forest', '2024-12-05');

-- Insert Race Results for Race 1 (Mountain Bike Challenge)
-- All riders participated in this race
INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Tayo Ola'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        120.5, 2, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Bayo Cane'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        115.7, 1, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Mark Johnson'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        130.2, 3, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Emily Davis'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        NULL, NULL, false); -- Did not finish

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Luke Wilson'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        125.9, 4, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Sarah Connor'),
        (SELECT id FROM race WHERE name = 'Mountain Bike Challenge'),
        128.5, 5, true);

-- Insert Race Results for Race 2 (Cross-Country Adventure)
-- Rider Luke Wilson did not participate, Rider Emily Davis did not finish
INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Tayo Ola'),
        (SELECT id FROM race WHERE name = 'Cross-Country Adventure'),
        200.5, 1, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Bayo Cane'),
        (SELECT id FROM race WHERE name = 'Cross-Country Adventure'),
        210.2, 2, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Mark Johnson'),
        (SELECT id FROM race WHERE name = 'Cross-Country Adventure'),
        220.7, 3, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Emily Davis'),
        (SELECT id FROM race WHERE name = 'Cross-Country Adventure'),
        NULL, NULL, false); -- Did not finish

-- Sarah Connor finished, Luke Wilson did not participate
INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Sarah Connor'),
        (SELECT id FROM race WHERE name = 'Cross-Country Adventure'),
        230.1, 4, true);

-- Insert Race Results for Race 3 (Forest Trail Race)
-- Riders Bayo Cane and Sarah Connor did not participate
INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Tayo Ola'),
        (SELECT id FROM race WHERE name = 'Forest Trail Race'),
        300.5, 3, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Mark Johnson'),
        (SELECT id FROM race WHERE name = 'Forest Trail Race'),
        280.3, 1, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Emily Davis'),
        (SELECT id FROM race WHERE name = 'Forest Trail Race'),
        290.1, 2, true);

INSERT INTO race_result (rider_id, race_id, race_time, position, did_finish)
VALUES ((SELECT id FROM rider WHERE name = 'Luke Wilson'),
        (SELECT id FROM race WHERE name = 'Forest Trail Race'),
        310.6, 4, true);
