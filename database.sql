create database PRJ302_Project_Group3_IS2003
 
 use PRJ302_Project_Group3_IS2003


CREATE TABLE branches (
    id INT IDENTITY(1,1) PRIMARY KEY,
    branch_name NVARCHAR(150) NOT NULL,
    address NVARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    is_deleted BIT NOT NULL DEFAULT 0
);

CREATE TABLE motorbike_models (
    id INT IDENTITY(1,1) PRIMARY KEY,
    model_name NVARCHAR(150) NOT NULL,
    description NVARCHAR(255),
    brand NVARCHAR(100) NOT NULL,
	image_path NVARCHAR(255),
    is_deleted BIT NOT NULL DEFAULT 0
);

CREATE TABLE motorbikes (
    id INT IDENTITY(1,1) PRIMARY KEY,
    model_id INT NOT NULL,
    branch_id INT NOT NULL,
    daily_price DECIMAL(12,2) NOT NULL,
    deposit_price DECIMAL(12,2) NOT NULL,
    license_plate VARCHAR(20) NOT NULL UNIQUE,

    status VARCHAR(20) NOT NULL DEFAULT 'Available'
    CHECK (status IN ('Available','Rented','Maintenance','Reserved')),

    is_deleted BIT NOT NULL DEFAULT 0,

    FOREIGN KEY (model_id) REFERENCES motorbike_models(id),
    FOREIGN KEY (branch_id) REFERENCES branches(id)
);

CREATE TABLE account_profiles (
    id INT IDENTITY(1,1) PRIMARY KEY,
    full_name NVARCHAR(150) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
   gender VARCHAR(10) NOT NULL
CHECK (gender IN ('Male','Female','Other')),
    dob DATE,
    address NVARCHAR(255),
    id_card_no VARCHAR(20) UNIQUE,
    is_deleted BIT NOT NULL DEFAULT 0
);

CREATE TABLE accounts (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,

    role VARCHAR(30) NOT NULL
    CHECK (role IN ('SuperAdmin','Admin','Staff','Customer')),

    user_id INT NOT NULL UNIQUE,
    branch_id INT NULL,
    is_deleted BIT NOT NULL DEFAULT 0,

    FOREIGN KEY (user_id) REFERENCES account_profiles(id),
    FOREIGN KEY (branch_id) REFERENCES branches(id)
);

CREATE TABLE bookings (
    id INT IDENTITY(1,1) PRIMARY KEY,
    branch_id INT NOT NULL,
    user_id INT NOT NULL,
booking_type VARCHAR(20) NOT NULL
CHECK (booking_type IN ('Walk-in','Pre-book')),

    booking_date DATETIME NOT NULL DEFAULT GETDATE(),
    total_deposit_price DECIMAL(12,2) NOT NULL DEFAULT 0,
    total_price DECIMAL(12,2) NOT NULL DEFAULT 0,

    status VARCHAR(20) NOT NULL DEFAULT 'Pending'
    CHECK (status IN ('Pending','Confirmed','Completed','Cancelled')),

    created_at DATETIME NOT NULL DEFAULT GETDATE(),
updated_at DATETIME NOT NULL DEFAULT GETDATE(),

    FOREIGN KEY (user_id) REFERENCES account_profiles(id),
    FOREIGN KEY (branch_id) REFERENCES branches(id)
);

CREATE TABLE booking_details (
    id INT IDENTITY(1,1) PRIMARY KEY,
    booking_id INT NOT NULL,
    motorbike_id INT NOT NULL,
    daily_price DECIMAL(12,2) NOT NULL,
    rental_days INT NOT NULL,
    deposit_price DECIMAL(12,2) NOT NULL DEFAULT 0,
    planning_start_time DATETIME NOT NULL,
    planning_end_time DATETIME NOT NULL,
    pickup_address NVARCHAR(255),
    return_address NVARCHAR(255),
    note NVARCHAR(255),

    FOREIGN KEY (booking_id) REFERENCES bookings(id),
    FOREIGN KEY (motorbike_id) REFERENCES motorbikes(id)
);



CREATE TABLE shifts (
    id INT IDENTITY(1,1) PRIMARY KEY,
    shift_name NVARCHAR(100) NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL
);

CREATE TABLE staff_shifts (
    id INT IDENTITY(1,1) PRIMARY KEY,
    staff_id INT NOT NULL,
    shift_id INT NOT NULL,
    working_date DATE NOT NULL,
    attendance_status VARCHAR(20) DEFAULT 'Pending',
    check_in_at DATETIME,
    check_out_at DATETIME,
    manager_note NVARCHAR(255),

    FOREIGN KEY (staff_id) REFERENCES account_profiles(id),
    FOREIGN KEY (shift_id) REFERENCES shifts(id)
);

CREATE TABLE deliveries (
    id INT IDENTITY(1,1) PRIMARY KEY,
    booking_detail_id INT,
    staff_id INT NOT NULL,
    type VARCHAR(20),
    actual_time DATETIME,
    actual_location NVARCHAR(255),
    odometer_reading INT,
    fuel_level VARCHAR(20),
    vehicle_condition NVARCHAR(MAX),
    status VARCHAR(20)
CHECK (status IN ('Pending','Completed','Cancelled')),
    note NVARCHAR(255),

    FOREIGN KEY (booking_detail_id) REFERENCES booking_details(id),
    FOREIGN KEY (staff_id) REFERENCES account_profiles(id)
);
CREATE TABLE payments (
    id INT IDENTITY(1,1) PRIMARY KEY,
    booking_id INT,
    amount DECIMAL(12,2),
    payment_type VARCHAR(20),
    payment_method VARCHAR(20),

    payment_status VARCHAR(20) NOT NULL
CHECK (payment_status IN ('Pending','Paid','Refunded')),

   created_at DATETIME DEFAULT GETDATE(),
updated_at DATETIME DEFAULT GETDATE(),

    FOREIGN KEY (booking_id) REFERENCES bookings(id)
);

