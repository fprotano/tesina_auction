ALTER TABLE `auction_order`
	CHANGE COLUMN `order_no` `order_no` VARCHAR(50) NOT NULL DEFAULT '0' AFTER `updated_at`;