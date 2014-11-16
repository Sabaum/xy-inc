package br.com.xyinc.business.utils;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class TestInfra {

	public static final String ANY_STRING = "anyString";
	public static final int ANY_INT = 1;
	
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
}
