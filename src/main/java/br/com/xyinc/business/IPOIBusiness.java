package br.com.xyinc.business;

import java.util.List;

import br.com.xyinc.domain.POI;

public interface IPOIBusiness {

	List<POI> list();

	void populate();

	void add(String name, int xPos, int yPos);

	void deleteAll();

	List<POI> nearest(int x, int y, int dMax);

}