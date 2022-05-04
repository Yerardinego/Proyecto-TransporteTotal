insert into vehicles(id, model, plate, type) values (HIBERNATE_SEQUENCE.nextval, 2006, 'DAE888', 'TURBO');
insert into vehicles(id, model, plate, type) values (HIBERNATE_SEQUENCE.nextval, 2010, 'ABC123', 'DOBLE TROQUE');
insert into vehicles(id, model, plate, type) values (HIBERNATE_SEQUENCE.nextval, 2012, 'FFF555', 'VOLQUETA');

insert into trips(id, trip_code, source, destination, price) values (hibernate_sequence.nextval, 'VB', 'Villavicencio', 'Bogota', 2500000);
insert into trips(id, trip_code, source, destination, price) values (hibernate_sequence.nextval, 'VC', 'Villavicencio', 'Cali', 3500000);
insert into trips(id, trip_code, source, destination, price) values (hibernate_sequence.nextval, 'VM', 'Villavicencio', 'Medellin', 4000000);

insert into expenses (id, expense_code, name, description) values (hibernate_sequence.nextval, 'C', 'Combustible', 'Gastos relacionados al consumo de combustible');
insert into expenses (id, expense_code, name, description) values (hibernate_sequence.nextval, 'M', 'Mantenimiento', 'Gastos relacionados al mantenimiento del vehiculo');
insert into expenses (id, expense_code, name, description) values (hibernate_sequence.nextval, 'P', 'Peaje', 'Gastos relacionados al costo promedio del peaje segun el vehiculo');

insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (120000, select id from vehicles where plate = 'DAE888', select id from expenses where expense_code = 'C');
insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (500000, select id from vehicles where plate = 'ABC123', select id from expenses where expense_code = 'C');
insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (350000, select id from vehicles where plate = 'FFF555', select id from expenses where expense_code = 'C');

insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (250000, select id from vehicles where plate = 'DAE888', select id from expenses where expense_code = 'M');
insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (800000, select id from vehicles where plate = 'ABC123', select id from expenses where expense_code = 'M');
insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (600000, select id from vehicles where plate = 'FFF555', select id from expenses where expense_code = 'M');

insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (60000, select id from vehicles where plate = 'DAE888', select id from expenses where expense_code = 'P');
insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (120000, select id from vehicles where plate = 'ABC123', select id from expenses where expense_code = 'P');
insert into expenses_by_vehicle (cost, vehicle_id, expense_id) values (80000, select id from vehicles where plate = 'FFF555', select id from expenses where expense_code = 'P');

insert into trips_by_vehicle (vehicle_id, trip_id, start_date, end_date) values (select id from vehicles where plate = 'DAE888', select id from trips where trip_code = 'VB', '2020-10-10', '2020-10-15');
insert into trips_by_vehicle (vehicle_id, trip_id, start_date, end_date) values (select id from vehicles where plate = 'ABC123', select id from trips where trip_code = 'VB', '2020-10-10', '2020-10-15');
insert into trips_by_vehicle (vehicle_id, trip_id, start_date, end_date) values (select id from vehicles where plate = 'FFF555', select id from trips where trip_code = 'VB', '2020-10-10', '2020-10-15');
