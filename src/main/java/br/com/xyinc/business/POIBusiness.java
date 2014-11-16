package br.com.xyinc.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.xyinc.domain.POI;
import br.com.xyinc.model.POIDao;

@Component
public class POIBusiness {

	@Autowired
	private POIDao poiDao;
	
	public List<POI> list() {
		return poiDao.list();
	}
	
	public void populate() {
		deleteAll();
		addDefaultPOIs();
	}
	
	private void addDefaultPOIs() {
		add("Lanchonete", 27, 12);
		add("Posto", 31, 18);
		add("Joalheria", 15, 12);
		add("Floricultura", 19, 21);
		add("Pub", 12, 8);
		add("Supermercado", 23, 6);
		add("Churrascaria", 28, 2);
	}

	public void add(String name, int xPos, int yPos) {
		int[] pos = {xPos, yPos};
		poiDao.save(new POI(name, pos));
	}
	
	public void deleteAll() {
		poiDao.deleteAll();
	}
	
	public List<POI> nearest(int x, int y, int dMax) {
		return poiDao.findNearest(x, y, dMax);
	}
}
