package Test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import Model.Train;
/**
 * JUnit test of train's function.
 * @author Raoqi
 * */
public class TrainTest {
	private Train train;
	@Before
	public void setUp() throws Exception {
		train = Train.register("my train", 300);
	}

	@Test
	public void testCreate() {
		assertEquals("my train", train.getName());
		assertEquals(300, train.getSpeed());
	}
	
	@Test
	public void testNextStation() {
		char next = train.getNextStation(30, "ABCDE");
		assertEquals('C', next);
		
		next = train.getNextStation(50, "ABCDE");
		assertEquals('D', next);
		
		next = train.getNextStation(0, "ABCDE");
		assertEquals('B', next);
		
	}
}
