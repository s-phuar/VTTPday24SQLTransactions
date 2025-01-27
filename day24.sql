use vttp_2025;

show index from car;

#create index on single column param, speeds up queries with b-tree structure
create index make_idx on car(make);

#create a multicolumn index when you query multi-columns often
#in a composite index, always put the higher uniqueness column on the left when query(WHERE column1 = 'value1' AND column2 = 'value2')
CREATE INDEX make_model_cartype ON car(make, model, cartype);

#order is important so that we can actually use the index we created
select * from car where make ='Toyota' and model ='Altis' and cartype = 'Sedan';

#covering index
# the index must contain all the columns needed to satisfy the query, this usually exclues the idx column


#optimistic lock: assumes low conflict (shopping cart)
#pessimistic lock: assume high conflict (banking transaction)

#transaction optimistic locks, last_update timestamp is automatically updated everytime a row is modified
#balance value of 10 digits, up to 2 d.p
CREATE TABLE lock_test (
    acct_id VARCHAR(8) NOT NULL,
    balance DECIMAL(10, 2),
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT pk_acct_id PRIMARY KEY(acct_id)
);

select * from lock_test;
INSERT INTO lock_test (acct_id, balance) VALUES ('A1234567', 1000.50); #lock_test only has 1 row of values
UPDATE lock_test SET balance = 1100.75 WHERE acct_id = 'A1234567'; #timestamp for this A1234567 row is updated
SELECT * FROM lock_test WHERE acct_id = 'A1234567';

#ensuring optimistic locking, store the timestamp in spring boot once we select
select * from lock_test where acct_id = 'A1234567';
SET SQL_SAFE_UPDATES = 0; #temporarily disable and enable safe update
update lock_test set balance = 420.69 where last_update = '2025-01-21 16:48:36';
SET SQL_SAFE_UPDATES = 1;

#see day 24 slides 16-17 for optimistic locking in http layer
#see day 24 slides 29-31 for pessimistic locking in http layer

#ACID, a transaction is a single piece of work(all or nothing)
#uses SQL transaction when we have to modify related data from different tables in a database, allows us to revert if conditions fail(faulty fund transfer)

SET SQL_SAFE_UPDATES = 0; #temporarily disable and enable safe update

set @from_acct = 'A1234566';
set @to_acct = 'A1234567';
set @amount = 100;
SELECT @amount, @from_acct, @to_acct;

start transaction;
	update lock_test set balance = balance - @amount where acct_id = @from_acct;
	update lock_test set balance = balance + @amount where acct_id = @to_acct;
commit;
SET SQL_SAFE_UPDATES = 1;

select * from lock_test;

#row locking exmaple

#transaction 1, should be prevent transaction 2 from accessing A1234567 until transaction 1 commits or rolls back
START TRANSACTION;
SELECT balance FROM lock_test WHERE acct_id = 'A1234567' FOR UPDATE;
UPDATE lock_test SET balance = balance - 100 WHERE acct_id = 'A1234567';

#transaction 2, blocked until transaction 1 commits or rolls back
START TRANSACTION;
SELECT balance FROM lock_test WHERE acct_id = 'A1234567' FOR UPDATE;
UPDATE lock_test SET balance = balance + 100 WHERE acct_id = 'A1234567';




