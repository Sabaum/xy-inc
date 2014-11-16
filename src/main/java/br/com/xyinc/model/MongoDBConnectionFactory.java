package br.com.xyinc.model;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.xyinc.domain.POI;
import br.com.xyinc.exceptions.InternalServerException;

import com.mongodb.MongoClient;

public class MongoDBConnectionFactory {

	private Datastore datastore;
	private String host;
	private String dbName;
	
	@Autowired
	public MongoDBConnectionFactory(String host, String dbName) throws UnknownHostException {
		this.host = host;
		this.dbName = dbName;
	}
	
	public void buildDatastore() {
		try {
			datastore = new Morphia()
				.map(POI.class)
				.createDatastore(new MongoClient(host), dbName);
			datastore.ensureIndexes();
			datastore.ensureCaps();
		} catch (UnknownHostException e) {
			throw new InternalServerException(String.format("host '%s' ou dbName '%s' incorreto.", host, dbName));
		}
	}
	
	public Datastore getDatastore() {
		if (datastore == null) {
			buildDatastore();
		}
		return datastore;
	}
}
