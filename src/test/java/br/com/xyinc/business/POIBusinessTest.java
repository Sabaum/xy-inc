package br.com.xyinc.business;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.xyinc.domain.POI;
import br.com.xyinc.model.POIDao;
import br.com.xyinc.utils.JunitInfra;

public class POIBusinessTest extends JunitInfra {

	@Mock
	private POIDao poiDao;
	@InjectMocks
	private POIBusiness business;
	
	@Test
	public void add() {
		int x = ANY_INT;
		int y = ANY_INT;
		business.add(ANY_STRING, x, y);
		int[] pos = {x, y};
		Mockito.verify(poiDao).save(Mockito.eq(new POI(ANY_STRING, pos)));
	}

	@Test
	public void deleteAll() {
		business.deleteAll();
		Mockito.verify(poiDao).deleteAll();
	}
	
	@Test
	public void list() {
		business.list();
		Mockito.verify(poiDao).list();
	}
	
	@Test
	public void nearest() {
		int x = ANY_INT;
		int y = ANY_INT;
		int dMax = ANY_INT;
		business.nearest(x, y, dMax);
		
		Mockito.verify(poiDao).findNearest(x, y, dMax);
	}
	
	@Test
	public void populate() {
		business.populate();
		
		Mockito.verify(poiDao).deleteAll();
		Mockito.verify(poiDao, Mockito.times(7)).save(Mockito.any(POI.class));
	}
	
	
}
