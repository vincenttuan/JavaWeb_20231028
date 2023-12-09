drop table if exists BookingRoom;
drop table if exists Room;

-- 建立 Room
create table if not exists Room(
	roomId int primary key,
    roomName varchar(50) not null unique
);

-- 建立 BookingRoom
create table if not exists BookingRoom(
	bookingId int auto_increment primary key,
    roomId int not null,
    username varchar(50) not null,
    bookingDate varchar(50) not null,
    createDate timestamp default current_timestamp,
    foreign key (roomId) references Room(roomId),
    constraint unique_roomId_and_bookingDate unique(roomId, bookingDate)
);

-- 建立預設資料
insert into Room(roomId, roomName) values(1, '101小型會議室');
insert into Room(roomId, roomName) values(2, '201小型會議室');
insert into Room(roomId, roomName) values(3, '301中型會議室');
insert into Room(roomId, roomName) values(4, '401中型會議室');
insert into Room(roomId, roomName) values(5, '501大型會議室');

insert BookingRoom(roomId, username, bookingDate) values(3, 'John', '2023-12-10'); 
insert BookingRoom(roomId, username, bookingDate) values(5, 'Mary', '2023-12-11'); 
insert BookingRoom(roomId, username, bookingDate) values(1, 'Jack', '2023-12-10'); 
insert BookingRoom(roomId, username, bookingDate) values(1, 'Rose', '2023-12-12'); 

