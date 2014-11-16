package br.com.xyinc.model;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.xyinc.domain.POI;

@Repository
public class POIDao implements IPOIDao {

	@Autowired
	private MongoDBConnectionFactory connectionFactory;

	public void save(POI poi) {
		getDs().save(poi);
	}

	public List<POI> findNearest(int x, int y, int dMax) {
		return getDs()
				.createQuery(POI.class)
				.field("pos")
				.near(x, y, dMax, false)
				.asList();
	}

	private Datastore getDs() {
		return connectionFactory.getDatastore();
	}

	public List<POI> list() {
		return getDs()
				.createQuery(POI.class).asList();
	}

	public void deleteAll() {
		Query<POI> queryAll = getDs().createQuery(POI.class);
		getDs().delete(queryAll);
	}

}
