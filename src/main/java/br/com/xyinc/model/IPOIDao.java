package br.com.xyinc.model;

import java.util.List;

import br.com.xyinc.domain.POI;

public interface IPOIDao {

	void save(POI poi);

	List<POI> findNearest(int x, int y, int dMax);

	List<POI> list();

	void deleteAll();

}