package com.Mongo;

import com.helper.Service;
import com.helper.service.BasicServices;
import com.mongodb.MongoClient;

public class App {
	public static void main(String[] args) {
		try {
			MongoClient clientConnection = new MongoClient("localhost", 27017);
			BasicServices service = new Service();
			service.database(clientConnection);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}
}
