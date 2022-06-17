package com.mypack.service;

public class DatabaseTypeMysql implements DatabaseType {

	public DatabaseTypeMysql() {
		System.out.println("Object of DatabaseTypeMysql created.");
	}
	@Override
	public String getDatabaseType() {
		return "MySql";
	}
}
