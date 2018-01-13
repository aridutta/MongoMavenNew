package com.helper;

import java.util.ArrayList;
import java.util.List;

import com.helper.service.BasicServices;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Service implements BasicServices {
	MongoDatabase database;

	public void database(MongoClient client) {
		MongoCursor<String> dbsCursor = client.listDatabaseNames().iterator();
		while (dbsCursor.hasNext()) {
			List<String> dbs = new ArrayList<String>();
			dbs.add(dbsCursor.next());
			for (int i = 0; i < dbs.size(); i++) {
				database = client.getDatabase(dbs.get(i));
				System.out.println();
				System.out.println("Successfully Connected to mongo Db : "
						+ database.getName());
				MongoIterable<String> collections = database
						.listCollectionNames();
				MongoCursor<String> list = collections.iterator();
				while (list.hasNext()) {
					System.out.println("Collections : " + list.next());
				}
			}
		}

	}
}
