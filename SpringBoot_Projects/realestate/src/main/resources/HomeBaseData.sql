-- Roles
INSERT INTO role (rolename) VALUES
('admin'),
('user');

-- Houses
INSERT INTO house_info (name, location, description) VALUES
('Palm Villa', 'Lagos Mainland', 'Spacious villa with modern amenities'),
('Ocean View', 'Victoria Island', 'Sea-facing luxury apartment'),
('Sunset Apartments', 'Lekki Phase 1', 'Cozy apartment near the beach');

-- Rooms (linked to houses)
INSERT INTO room (room_no, bath, number_of_room, floor_no, rent, house_id) VALUES
('A1', 1, 1, 1, 50000, 1),
('A2', 2, 2, 1, 75000, 1),
('B1', 1, 1, 2, 60000, 2),
('B2', 2, 2, 2, 90000, 2),
('C1', 1, 1, 1, 55000, 3);

-- Persons
INSERT INTO person (role_id, name, phone_no, email, entry_date, gender, accommodation_status) VALUES
(1, 'John Doe', 8012345678, 'john.doe@example.com', '2025-01-10', 'Male', 'None'),
(1, 'Jane Smith', 8023456789, 'jane.smith@example.com', '2025-02-15', 'Female', 'Allocated'),
(1, 'Michael Johnson', 8034567890, 'michael.johnson@example.com', '2025-03-01', 'Male', 'None');

-- Allocations (linking person to a room)
INSERT INTO allocation (person_id, room_id, start_date, end_date, status) VALUES
(2, 1, '2025-02-20', '2026-02-20', 'Open');

-- Payments
INSERT INTO payment (person_id, amount, payment_date, payment_method, status) VALUES
(2, 75000.00, '2025-02-21', 'Bank Transfer', 'Paid');

-- Maintenance Requests
INSERT INTO maintenance_request (room_id, person_id, request_date, description, status) VALUES
(1, 2, '2025-03-01', 'Leaky faucet in bathroom', 'Pending');
