INSERT INTO branches (branch_name,address,phone)
VALUES (N'Hà Nội Motorbike Rental',N'123 Cầu Giấy, Hà Nội','0901234567');

INSERT INTO motorbike_models (model_name, description, brand, image_path) VALUES
('Vision','Xe ga','Honda','static/img/vision.jpg'),
('AirBlade','Xe ga','Honda','static/img/airblade.jpg'),
('Lead','Xe ga','Honda','static/img/lead.jpg'),
('SH Mode','Xe ga','Honda','static/img/sh-mode.jpg'),
('Wave Alpha','Xe số','Honda','static/img/wave-alpha.jpg'),
('Future','Xe số','Honda','static/img/future.jpg'),
('Grande','Xe ga','Yamaha','static/img/yamaha-grande.jpg');

INSERT INTO motorbikes (model_id,branch_id,daily_price,deposit_price,license_plate,status) VALUES

-- Vision (8 xe)
(1,1,120000,500000,'29A-10001','Available'),
(1,1,120000,500000,'29A-10002','Available'),
(1,1,120000,500000,'29A-10003','Rented'),
(1,1,120000,500000,'29A-10004','Available'),
(1,1,120000,500000,'29A-10005','Maintenance'),
(1,1,120000,500000,'29A-10006','Available'),
(1,1,120000,500000,'29A-10007','Available'),
(1,1,120000,500000,'29A-10008','Reserved'),

-- AirBlade (7 xe)
(2,1,150000,600000,'29A-11001','Available'),
(2,1,150000,600000,'29A-11002','Available'),
(2,1,150000,600000,'29A-11003','Rented'),
(2,1,150000,600000,'29A-11004','Available'),
(2,1,150000,600000,'29A-11005','Available'),
(2,1,150000,600000,'29A-11006','Maintenance'),
(2,1,150000,600000,'29A-11007','Available'),

-- Lead (6 xe)
(3,1,140000,600000,'29A-12001','Available'),
(3,1,140000,600000,'29A-12002','Available'),
(3,1,140000,600000,'29A-12003','Rented'),
(3,1,140000,600000,'29A-12004','Available'),
(3,1,140000,600000,'29A-12005','Available'),
(3,1,140000,600000,'29A-12006','Maintenance'),

-- SH Mode (5 xe)
(4,1,200000,1000000,'29A-13001','Available'),
(4,1,200000,1000000,'29A-13002','Rented'),
(4,1,200000,1000000,'29A-13003','Available'),
(4,1,200000,1000000,'29A-13004','Available'),
(4,1,200000,1000000,'29A-13005','Maintenance'),

-- Wave Alpha (8 xe)
(5,1,100000,400000,'29A-14001','Available'),
(5,1,100000,400000,'29A-14002','Available'),
(5,1,100000,400000,'29A-14003','Available'),
(5,1,100000,400000,'29A-14004','Rented'),
(5,1,100000,400000,'29A-14005','Available'),
(5,1,100000,400000,'29A-14006','Available'),
(5,1,100000,400000,'29A-14007','Maintenance'),
(5,1,100000,400000,'29A-14008','Available'),

-- Future (6 xe)
(6,1,120000,500000,'29A-15001','Available'),
(6,1,120000,500000,'29A-15002','Available'),
(6,1,120000,500000,'29A-15003','Available'),
(6,1,120000,500000,'29A-15004','Rented'),
(6,1,120000,500000,'29A-15005','Available'),
(6,1,120000,500000,'29A-15006','Maintenance'),

-- Grande (7 xe)
(7,1,160000,600000,'29A-16001','Available'),
(7,1,160000,600000,'29A-16002','Available'),
(7,1,160000,600000,'29A-16003','Rented'),
(7,1,160000,600000,'29A-16004','Available'),
(7,1,160000,600000,'29A-16005','Available'),
(7,1,160000,600000,'29A-16006','Maintenance'),
(7,1,160000,600000,'29A-16007','Available');

INSERT INTO account_profiles (full_name,phone,gender,dob,address,id_card_no) VALUES
(N'System Super Admin','0901999991','Male','1995-01-01',N'Hà Nội','999999991'),
(N'Nguyễn Văn Quản Trị','0901999992','Male','1996-01-01',N'Hà Nội','999999992'),

(N'Nguyễn Minh Anh','0901000001','Male','2000-01-02',N'Hà Nội','123456001'),
(N'Trần Thu Trang','0901000002','Female','1999-03-12',N'Hà Nội','123456002'),
(N'Lê Hoàng Nam','0901000003','Male','2001-05-21',N'Hà Nội','123456003'),
(N'Phạm Quỳnh Anh','0901000004','Female','2000-08-11',N'Hà Nội','123456004'),
(N'Đỗ Thanh Tùng','0901000005','Male','1998-02-17',N'Hà Nội','123456005'),

(N'Nguyễn Thu Hà','0901000006','Female','2000-11-09',N'Hà Nội','123456006'),
(N'Bùi Anh Tuấn','0901000007','Male','1999-04-01',N'Hà Nội','123456007'),
(N'Hoàng Minh Đức','0901000008','Male','2001-07-23',N'Hà Nội','123456008'),
(N'Vũ Thị Mai','0901000009','Female','1999-12-10',N'Hà Nội','123456009'),
(N'Phan Quốc Huy','0901000010','Male','1998-09-18',N'Hà Nội','123456010'),

(N'Nguyễn Khánh Linh','0901000011','Female','2000-04-14',N'Hà Nội','123456011'),
(N'Lê Đức Anh','0901000012','Male','1997-06-05',N'Hà Nội','123456012'),
(N'Trần Minh Quân','0901000013','Male','1999-10-22',N'Hà Nội','123456013'),
(N'Phạm Ngọc Ánh','0901000014','Female','2001-02-13',N'Hà Nội','123456014'),
(N'Đặng Hoàng Long','0901000015','Male','1998-07-30',N'Hà Nội','123456015'),

(N'Ngô Thu Phương','0901000016','Female','2000-03-17',N'Hà Nội','123456016'),
(N'Vũ Quang Huy','0901000017','Male','1999-05-26',N'Hà Nội','123456017'),
(N'Phan Thu Hương','0901000018','Female','2001-08-07',N'Hà Nội','123456018'),
(N'Lý Tuấn Kiệt','0901000019','Male','1998-11-11',N'Hà Nội','123456019'),
(N'Nguyễn Anh Dũng','0901000020','Male','1997-01-28',N'Hà Nội','123456020');
INSERT INTO accounts (username,password,role,user_id,branch_id) VALUES
('superadmin','superadminadmin@1','SuperAdmin',1,NULL),
('admin','admin@1','Admin',2,1),

('staff1','123','Staff',3,1),
('staff2','123','Staff',4,1),
('staff3','123','Staff',5,1),

('customer1','123','Customer',6,NULL),
('customer2','123','Customer',7,NULL),
('customer3','123','Customer',8,NULL),
('customer4','123','Customer',9,NULL),
('customer5','123','Customer',10,NULL),
('customer6','123','Customer',11,NULL),
('customer7','123','Customer',12,NULL),
('customer8','123','Customer',13,NULL),
('customer9','123','Customer',14,NULL),
('customer10','123','Customer',15,NULL);

INSERT INTO shifts (shift_name,start_time,end_time) VALUES
(N'Ca sáng','08:00','12:00'),
(N'Ca chiều','13:00','17:00'),
(N'Ca tối','18:00','22:00');
INSERT INTO staff_shifts (staff_id,shift_id,working_date) VALUES
(3,1,'2026-03-01'),
(4,1,'2026-03-01'),
(5,2,'2026-03-01'),

(3,2,'2026-03-02'),
(4,3,'2026-03-02'),
(5,1,'2026-03-02'),

(3,2,'2026-03-03'),
(4,3,'2026-03-03'),
(5,1,'2026-03-03');
INSERT INTO bookings 
(branch_id,user_id,booking_type,total_deposit_price,total_price,status,created_at,updated_at)
VALUES
(1,6,'Walk-in',500000,600000,'Confirmed',GETDATE(),GETDATE()),
(1,7,'Pre-book',600000,700000,'Confirmed',GETDATE(),GETDATE()),
(1,8,'Walk-in',400000,500000,'Completed',GETDATE(),GETDATE()),
(1,9,'Pre-book',500000,600000,'Pending',GETDATE(),GETDATE()),
(1,10,'Walk-in',400000,500000,'Completed',GETDATE(),GETDATE()),
(1,6,'Pre-book',600000,700000,'Confirmed',GETDATE(),GETDATE()),
(1,7,'Walk-in',500000,600000,'Completed',GETDATE(),GETDATE()),
(1,8,'Pre-book',600000,700000,'Confirmed',GETDATE(),GETDATE()),
(1,9,'Walk-in',400000,500000,'Confirmed',GETDATE(),GETDATE()),
(1,10,'Pre-book',500000,600000,'Completed',GETDATE(),GETDATE());

INSERT INTO booking_details
(booking_id,motorbike_id,daily_price,rental_days,deposit_price,
planning_start_time,planning_end_time,
pickup_address,return_address,note)
VALUES

(1,1,120000,2,500000,'2026-03-05','2026-03-07',N'123 Cầu Giấy',N'123 Cầu Giấy',N'Nhận tại cửa hàng'),

(2,2,150000,2,600000,'2026-03-05','2026-03-07',N'123 Cầu Giấy',N'123 Cầu Giấy',N'Đặt online'),

(3,3,140000,1,600000,'2026-03-05','2026-03-06',N'123 Cầu Giấy',N'123 Cầu Giấy',NULL),

(4,4,200000,2,1000000,'2026-03-05','2026-03-07',N'123 Cầu Giấy',N'123 Cầu Giấy',N'Đi du lịch'),

(5,5,100000,3,400000,'2026-03-05','2026-03-08',N'123 Cầu Giấy',N'123 Cầu Giấy',NULL),

(6,6,120000,2,500000,'2026-03-05','2026-03-07',N'123 Cầu Giấy',N'123 Cầu Giấy',NULL),

(7,7,180000,2,800000,'2026-03-05','2026-03-07',N'123 Cầu Giấy',N'123 Cầu Giấy',NULL),

(8,8,100000,1,400000,'2026-03-05','2026-03-06',N'123 Cầu Giấy',N'123 Cầu Giấy',NULL),

(9,9,180000,2,800000,'2026-03-05','2026-03-07',N'123 Cầu Giấy',N'123 Cầu Giấy',NULL),

(10,10,150000,2,600000,'2026-03-05','2026-03-07',N'123 Cầu Giấy',N'123 Cầu Giấy',NULL);

INSERT INTO payments (booking_id,amount,payment_type,payment_method,payment_status,created_at,updated_at) VALUES
(1,500000,'Deposit','Cash','Paid',GETDATE(),GETDATE()),
(2,600000,'Deposit','Transfer','Paid',GETDATE(),GETDATE()),
(3,400000,'Deposit','Cash','Paid',GETDATE(),GETDATE()),
(4,500000,'Deposit','Cash','Paid',GETDATE(),GETDATE()),
(5,400000,'Deposit','Transfer','Paid',GETDATE(),GETDATE()),
(6,600000,'Deposit','Cash','Paid',GETDATE(),GETDATE()),
(7,500000,'Deposit','Transfer','Paid',GETDATE(),GETDATE()),
(8,600000,'Deposit','Cash','Paid',GETDATE(),GETDATE()),
(9,400000,'Deposit','Cash','Paid',GETDATE(),GETDATE()),
(10,500000,'Deposit','Transfer','Paid',GETDATE(),GETDATE());

INSERT INTO deliveries
(booking_detail_id,staff_id,type,actual_time,actual_location,odometer_reading,fuel_level,vehicle_condition,status,note)
VALUES
(1,3,'Pickup',GETDATE(),N'123 Cầu Giấy',12000,'Full',N'Tốt','Completed',N'Giao xe đúng giờ'),
(1,3,'Return',DATEADD(day,2,GETDATE()),N'123 Cầu Giấy',12200,'Medium',N'Tốt','Completed',N'Trả xe bình thường'),

(2,4,'Pickup',GETDATE(),N'123 Cầu Giấy',9000,'Full',N'Tốt','Completed',NULL),
(2,4,'Return',DATEADD(day,2,GETDATE()),N'123 Cầu Giấy',9300,'Low',N'Trầy nhẹ','Completed',N'Khách đi xa'),

(3,5,'Pickup',GETDATE(),N'123 Cầu Giấy',7000,'Full',N'Tốt','Completed',NULL),

(4,3,'Pickup',GETDATE(),N'123 Cầu Giấy',5000,'Full',N'Mới','Completed',NULL),

(5,4,'Pickup',GETDATE(),N'123 Cầu Giấy',15000,'Full',N'Tốt','Completed',NULL),

(6,5,'Pickup',GETDATE(),N'123 Cầu Giấy',6000,'Full',N'Tốt','Completed',NULL),

(7,3,'Pickup',GETDATE(),N'123 Cầu Giấy',8000,'Full',N'Tốt','Completed',NULL),

(8,4,'Pickup',GETDATE(),N'123 Cầu Giấy',4000,'Full',N'Mới','Completed',NULL);
