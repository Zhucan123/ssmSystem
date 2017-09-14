package com.game.util;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author zhuCan
 *
 * @DATE  2017��8��13��
 *
 * @TIME  ����8:50:25
 */
public class C3P0util {

	private static QueryRunner runner;
	
	public static QueryRunner getQueryRunner() {
		DataSource data=new ComboPooledDataSource();
		
		runner=new QueryRunner(data);
		
		return runner;
	}
}
