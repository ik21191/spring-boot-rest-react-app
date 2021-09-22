package com.mypack.service;

public class DatabaseTypeMongo implements DatabaseType {
	
	public DatabaseTypeMongo() {
		System.out.println("Object of DatabaseTypeMongo created");
	}

	@Override
	public String getDatabaseType() {
		return "Mongo";
	}
}
