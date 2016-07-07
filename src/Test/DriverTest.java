package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Driver_;
import System.InvalidTrainException;
/**
 * JUnit test of driver model.
 * @author Raoqi
 * */
public class DriverTest {
	
	private Driver_ driver;
	@Before
	public void setUp() throws Exception {
		driver = Driver_.register("Raoqi", 1, 21, "rqrqrq", "rqrqrq", "18986561219", "BUPT hongfu campus");
	}

	@Test
	public void testDriver() {
		String name = driver.getName();
		assertEquals("Raoqi", name);
		
		String address = driver.getAddress();
		assertEquals("BUPT hongfu campus", address);
	}
	
	@Test
	public void testRegister() throws InvalidTrainException {
		driver = new Driver_();
		driver = Driver_.register("Raoqi", 1, 21, "1234", "1234", "1888888888", "BUPT");
		//password : 1234  -- Too simple password!
		//password & confirm  -- two input passwords not the same!
	}
	

	
}
