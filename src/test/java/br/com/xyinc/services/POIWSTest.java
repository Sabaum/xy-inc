package br.com.xyinc.services;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.xyinc.business.POIBusiness;
import br.com.xyinc.exceptions.InternalServerException;
import br.com.xyinc.utils.JunitInfra;

public class POIWSTest extends JunitInfra {

	@Mock
	private POIBusiness business;
	@InjectMocks
	private POIWS poiWS;
	
	@Test
	public void add() {
		int x = ANY_INT;
		int y = ANY_INT;
		
		poiWS.add(x, y, ANY_STRING);
		Mockito.verify(business).add(ANY_STRING, x, y);
	}
	
	@Test(expected=InternalServerException.class)
	public void addFail1() {
		int y = ANY_INT;
		
		poiWS.add(null, y, ANY_STRING);
	}
	
	@Test(expected=InternalServerException.class)
	public void addFail2() {
		int x = ANY_INT;
		
		poiWS.add(x, null, ANY_STRING);
	}
	
	@Test(expected=InternalServerException.class)
	public void addFail3() {
		int x = ANY_INT;
		int y = ANY_INT;
		
		poiWS.add(x, y, null);
	}
	
	@Test
	public void findNearest() {
		int x = ANY_INT;
		int y = ANY_INT;
		int dMax = ANY_INT;
		
		poiWS.findNearest(x, y, dMax);
		Mockito.verify(business).nearest( x, y, dMax);
	}
	
	@Test(expected=InternalServerException.class)
	public void findNearestFail1() {
		int y = ANY_INT;
		int dMax = ANY_INT;
		
		poiWS.findNearest(null, y, dMax);
	}
	
	@Test(expected=InternalServerException.class)
	public void findNearestFail2() {
		int x = ANY_INT;
		int dMax = ANY_INT;
		
		poiWS.findNearest(x, null, dMax);
	}
	
	@Test(expected=InternalServerException.class)
	public void findNearestFail3() {
		int x = ANY_INT;
		int y = ANY_INT;
		
		poiWS.findNearest(x, y, null);
	}
	
	@Test
	public void list() {
		poiWS.list();
		Mockito.verify(business).list();
	}

	@Test
	public void populate() {
		poiWS.populate();
		Mockito.verify(business).populate();
	}
	
	@Test
	public void deleteAll() {
		poiWS.deleteAll();
		Mockito.verify(business).deleteAll();
	}
	
}
