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
('A1', 1, 3, 1, 50000, 1),
('A2', 2, 3, 1, 75000, 1),
('B1', 1, 3, 2, 60000, 2),
('B2', 2, 3, 2, 90000, 2),
('C1', 1, 3, 1, 55000, 3);

-- Persons
INSERT INTO your_table_name 
(id, role_id, name, phone_no, email, entry_date, gender, accommodation_status)
VALUES
(1, 2, 'John Doe', 8012345678, 'john.doe@example.com', '2025-01-10', 'Male', 'Pending'),
(2, 1, 'Jane Smith', 8023456789, 'jane.smith@example.com', '2025-02-15', 'Female', 'Active'),
(3, 2, 'Michael Johnson', 8034567890, 'michael.johnson@example.com', '2025-03-01', 'Male', 'None'),
(4, 2, 'Emily Brown', 8045678901, 'emily.brown@example.com', '2025-03-05', 'Female', 'Active'),
(5, 2, 'David Wilson', 8056789012, 'david.wilson@example.com', '2025-03-07', 'Male', 'Pending'),
(6, 2, 'Sophia Taylor', 8067890123, 'sophia.taylor@example.com', '2025-03-09', 'Female', 'Rejected'),
(7, 2, 'Olivia Martinez', 8078901234, 'olivia.martinez@example.com', '2025-03-12', 'Female', 'Pending'),
(8, 2, 'James Anderson', 8089012345, 'james.anderson@example.com', '2025-03-15', 'Male', 'Active'),
(9, 2, 'Isabella Thomas', 8090123456, 'isabella.thomas@example.com', '2025-03-18', 'Female', 'Rejected');


-- Allocations (linking person to a room)
INSERT INTO allocation (id, person_id, room_id, start_date, end_date, status) VALUES
(1, 2, 1, '2025-02-20', '2026-02-20', 'Active')
(2, 4, 2, '2025-03-06', '2026-03-06', 'Active'),   -- Emily Brown
(3, 5, 3, '2025-03-08', '2026-03-08', 'Pending'),  -- David Wilson
(4, 6, 4, '2025-03-10', '2026-03-10', 'Rejected'), -- Sophia Taylor
(5, 7, 5, '2025-03-13', '2026-03-13', 'Pending'),  -- Olivia Martinez
(6, 8, 6, '2025-03-16', '2026-03-16', 'Active'),   -- James Anderson
(7, 9, 7, '2025-03-19', '2026-03-19', 'Rejected'); -- Isabella Thomas

-- Payments
INSERT INTO payment (person_id, amount, payment_date, payment_method, status) VALUES
(2, 75000.00, '2025-02-21', 'Bank Transfer', 'Paid');

-- Maintenance Requests
INSERT INTO maintenance_request (room_id, person_id, request_date, description, status) VALUES
(1, 2, '2025-03-01', 'Leaky faucet in bathroom', 'Pending');
