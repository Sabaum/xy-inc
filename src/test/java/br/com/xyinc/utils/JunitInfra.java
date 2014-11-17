package br.com.xyinc.utils;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class JunitInfra {

	public static final String ANY_STRING = "anyString";
	public static final int ANY_INT = 1;
	
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
}
