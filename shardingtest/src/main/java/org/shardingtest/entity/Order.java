package org.shardingtest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_order")//表名
public class Order {
	
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "product_name")
	private String productName;
}
