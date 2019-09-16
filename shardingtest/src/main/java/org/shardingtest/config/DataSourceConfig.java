package org.shardingtest.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import io.shardingsphere.core.keygen.KeyGenerator;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
@Configuration
public class DataSourceConfig {
	
	@Bean
	public DataSource dataSource() {
		// 配置真实数据源

		Map<String, DataSource> dataSourceMap = new HashMap<>(2);

		// 配置第一个数据源

		DruidDataSource dataSource1 = new DruidDataSource();

		dataSource1.setDriverClassName("com.mysql.jdbc.Driver");

		dataSource1.setUrl("");

		dataSource1.setUsername("");

		dataSource1.setPassword("");

		dataSourceMap.put("ds0", dataSource1);

		// 配置第二个数据源

		DruidDataSource dataSource2 = new DruidDataSource();

		dataSource2.setDriverClassName("com.mysql.jdbc.Driver");

		dataSource2.setUrl("");

		dataSource2.setUsername("");

		dataSource2.setPassword("");

		dataSourceMap.put("ds1", dataSource2);

		// 配置Order表规则

		TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();

		orderTableRuleConfig.setLogicTable("t_order");

		orderTableRuleConfig.setActualDataNodes("ds${0..1}.t_order${0..1}");

		// 配置分库 + 分表策略

		orderTableRuleConfig.setTableShardingStrategyConfig(
				new InlineShardingStrategyConfiguration("order_id", "t_order${order_id % 2}"));

		// 配置分片规则

		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();

		shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
		// 获取数据源对象
		try {
			return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap<String, Object>(),new Properties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Bean
    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }
}
