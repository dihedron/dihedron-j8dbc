/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */
package org.dihedron.j8dbc;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.dihedron.core.License;
import org.dihedron.core.jdbc.DataSource;
import org.dihedron.core.jdbc.DataSourceFactory;
import org.dihedron.j8dbc.Select;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@License
public class MainTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MainTest.class);
	
	private static class Rule {
		public int id;
		public int profileId;
		public int ruleId;
		public int failureLevel;
		
		public Rule(int id, int profileId, int ruleId, int failureLevel) {
			this.id = id;
			this.profileId = profileId;
			this.ruleId = ruleId;
			this.failureLevel = failureLevel;
		}
		
		public String toString() {
			return "" + id + "::" + profileId + "::" + ruleId + "::" + failureLevel;
		}
	}
	
	@Test
	public void testSequentialIterationOnRecordFields() {
		try(DataSource datasource = DataSourceFactory.makeDataSource("local"); 
			Connection connection = datasource.getConnection("root", "root")) {

			Select
				.using(connection)
				.compile("select * from active_rules where id = ? or id = ?")
				.with( statement -> statement.setInt(1, 533))
				.with( statement -> statement.setInt(2, 532))
	//			.with( statement -> { statement.setInt(2, 532); throw new SQLException(); }) // uncomment to test exception handling
				.stream()
				.forEach(
						record -> record
								.stream()
								.forEach(
										field -> System.out.println(field.name() + " => " + field.value() + " (" + field.sqlDataTypeName() + ", writable: " + field.writable() + ", nullable: " + field.nullable() + ")")
								)
				);
		} catch (SQLException e) {
			logger.error("error running tests", e);
			fail("error running test");
		}
	}
	
	@Test
	public void testSequentialRecordToEntityMapping() {
		try(DataSource datasource = DataSourceFactory.makeDataSource("local"); 
			Connection connection = datasource.getConnection("root", "root")) {
			Select
				.using(connection)
				.compile("select * from active_rules where id = ? or id = ?")
				.with( statement -> statement.setInt(1, 533))
				.with( statement -> statement.setString(2, "abcs"))
				.stream()
				.map(
						record -> 
							new Rule(
									record.get("id").as(Integer.class), 
									record.get("profile_id").as(Integer.class), 
									record.get("rule_id").as(Integer.class), 
									record.get("failure_level").as(Integer.class)
							)
				).forEach(rule -> System.out.println(rule));
		} catch (SQLException e) {
			logger.error("error running tests", e);
			fail("error running test");
		}
	}
	
	@Test
	public void testParallelIterationOnRecordFields() {
		try(DataSource datasource = DataSourceFactory.makeDataSource("local"); 
			Connection connection = datasource.getConnection("root", "root")) {

			Select
				.using(connection)
				.compile("select * from active_rules")
				.parallelStream()
				.forEach(
						record -> record
								.stream()
								.forEach(
										field -> System.out.println(field.name() + " => " + field.value() + " (" + field.sqlDataTypeName() + ", writable: " + field.writable() + ", nullable: " + field.nullable() + ")")
								)
				);
		} catch (SQLException e) {
			logger.error("error running tests", e);
			fail("error running test");
		}
	}
	
	@Test
	public void testParallelRecordToEntityMapping() {
		try(DataSource datasource = DataSourceFactory.makeDataSource("local"); 
			Connection connection = datasource.getConnection("root", "root")) {
			Select
				.using(connection)
				.compile("select * from active_rules")
				.parallelStream()
				.map(
						record -> 
							new Rule(
									record.get("id").as(Integer.class), 
									record.get("profile_id").as(Integer.class), 
									record.get("rule_id").as(Integer.class), 
									record.get("failure_level").as(Integer.class)
							)
				).forEach(rule -> System.out.println(rule));
		} catch (SQLException e) {
			logger.error("error running tests", e);
			fail("error running test");
		}
	}	
	
}
