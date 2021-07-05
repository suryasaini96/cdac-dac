create table customer(
	customer_id int primary key auto_increment,
    customer_name varchar(30) not null,
    customer_details varchar(100),
    gender enum('m','f','o'),
    email_address varchar(20) unique not null,
    phone_number varchar(12) unique not null,
    address_line_1 varchar(50),
    address_line_2 varchar(50),
    address_line_3 varchar(50),
    town varchar(20),
    county varchar(20),
    country varchar(20)
);

create table booking(
	booking_id int unique,
    date_from date not null,
    date_to date not null,
    confirmation_letter_sent_yn enum('y','n'),
    payment_received_yn enum('y','n'),
    foreign key(booking_id) references customer(customer_id), 
    foreign key(booking_id) references booking_status(booking_status_code)
);

create table booking_status(
	booking_status_code int primary key,
    booking_status_description varchar(30)
);

create table vehicle(
	reg_number int primary key,
    current_mileage int,
    daily_hire_rate int,
    date_mot_due int,
    engine_size int
);

