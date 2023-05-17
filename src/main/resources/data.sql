INSERT INTO client (id, first_name, last_name, date_of_birth, driving_license_number, license_validity, animal)
VALUES ("5", "Bruce", "Lee", "03/12/1948", "55", FALSE, "doggo");
INSERT INTO client (id, first_name, last_name, date_of_birth, driving_license_number, license_validity, animal)
VALUES ("4", "Jacky", "Chan", "04/11/1952", "666", TRUE, "dragon");

-- DELIMITER $$
-- CREATE PROCEDURE `generate_client_data`(IN num_clients INT)
-- BEGIN
--     DECLARE i INT DEFAULT 1;
--     DECLARE first_name VARCHAR(255);
--     DECLARE last_name VARCHAR(255);
--     DECLARE birth_date VARCHAR(255);
--     DECLARE license_num VARCHAR(255);
--     DECLARE license_validity BOOLEAN;
--     DECLARE animal VARCHAR(255);
--
--     WHILE i <= num_clients DO
--         SET first_name = CONCAT('First', FLOOR(RAND() * 1000));
--         SET last_name = CONCAT('Last', FLOOR(RAND() * 1000));
--         SET birth_date = DATE_ADD('1950-01-01', INTERVAL FLOOR(RAND() * 25000) DAY);
--         SET license_num = CONCAT('DLN', FLOOR(RAND() * 100000));
--         SET license_validity = RAND() < 0.5;
--         SET animal = CONCAT('Animal', FLOOR(RAND() * 1000));
--
-- INSERT INTO client (id, firstName, lastName, dateOfBirth, drivingLicenseNumber, licenseValidity, animal)
-- VALUES (UUID(), first_name, last_name, birth_date, license_num, license_validity, animal);
--
-- SET i = i + 1;
-- END WHILE;
-- END$$
-- DELIMITER ;
--
-- CALL generate_client_data(10);