select * from myretailstore.products;

CREATE KEYSPACE myretailstore WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;
CREATE TYPE myretailstore.current_price (
    value float,
    currency_code text
);
CREATE TABLE myretailstore.products (
	product_id int,
	name text,
	current_price frozen<current_price>,
	PRIMARY KEY (product_id))
    WITH bloom_filter_fp_chance = 0.01
AND comment = ''
AND crc_check_chance = 1.0
AND dclocal_read_repair_chance = 0.1
AND default_time_to_live = 0
AND gc_grace_seconds = 864000
AND max_index_interval = 2048
AND memtable_flush_period_in_ms = 0
AND min_index_interval = 128
AND read_repair_chance = 0.0
AND speculative_retry = '99.0PERCENTILE';


INSERT INTO products (product_id,current_price,name) VALUES (12954218,{value:13.49,currency_code:'USD'},'The Big Lebowski (Blu-ray) (Widescreen)');
INSERT INTO products (product_id,current_price,name) VALUES (54456119,{value:13.49,currency_code:'USD'},'The Big Lebowski (Blu-ray) (Widescreen)');
INSERT INTO products (product_id,current_price,name) VALUES (13264003,{value:13.49,currency_code:'USD'},'The Big Lebowski (Blu-ray) (Widescreen)');
INSERT INTO products (product_id,current_price,name) VALUES (13860428,{value:13.49,currency_code:'USD'},'The Big Lebowski (Blu-ray) (Widescreen)');
INSERT INTO products (product_id,current_price,name) VALUES (213860428,{value:13.48,currency_code:'USD1'},'1The Big Lebowski (Blu-ray) (Widescreen)');

