package org.kapil.product.sampling;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.omg.CosNaming._NamingContextExtStub;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	static final List<ProductSample> existing = new ArrayList<ProductSample>();
	static final List<ProductSample> _new = new ArrayList<ProductSample>();
	static Date existingDate = null;
	static Date newDate = null;
	static {
		//test data
		Calendar cal = Calendar.getInstance();
		existingDate = cal.getTime();
		//Existing products
		ProductSample p11 = new ProductSample(existingDate, 1100l, false);
		ProductSample p8 = new ProductSample(existingDate, 800l, false);
		ProductSample p10 = new ProductSample(existingDate, 1000l, false);
		ProductSample p9 = new ProductSample(existingDate, 900l, false);
		ProductSample p12 = new ProductSample(existingDate, 1200l, false);
		ProductSample p1 = new ProductSample(existingDate, 1000l, false);
		ProductSample p3 = new ProductSample(existingDate, 300l, false);
		ProductSample p5 = new ProductSample(existingDate, 500l, false);
		ProductSample p7 = new ProductSample(existingDate, 700l, false);
		
		existing.add(p11);
		existing.add(p8);
		existing.add(p9);
		existing.add(p12);
		existing.add(p1);
		existing.add(p3);
		existing.add(p5);
		existing.add(p7);
		existing.add(p10);
		
		
		//new Products
		cal.add(Calendar.DAY_OF_YEAR, 1);
		newDate = cal.getTime();
		ProductSample p6 = new ProductSample(newDate, 600l, false);
		ProductSample p4 = new ProductSample(newDate, 400l, false);
		ProductSample p2 = new ProductSample(newDate, 200l, false);
		
		_new.add(p6);
		_new.add(p4);
		_new.add(p2);
	}
	
	App myApp = new App();
	
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testSampleProducts() {
		Map<Long, List<ProductSample>> groups  = myApp.sampleProducts(_new, existing);
		
		assertTrue(groups.size()==3);
		for(Map.Entry<Long, List<ProductSample>> _entry : groups.entrySet()){
			if(_entry.getKey()==1){
				assertTrue(_entry.getValue().get(0).getSampleDate().equals(newDate));
			}else{
				assertTrue(_entry.getValue().get(0).getSampleDate().equals(existingDate));
			}
		}
		
	}
}
