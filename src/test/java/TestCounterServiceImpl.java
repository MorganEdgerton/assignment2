import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestCounterServiceImpl {

	CounterServiceImpl counterService = null;
	
	@Before
	public void setUp() {
		counterService = new CounterServiceImpl();
	}
	
	@Test
	public void testCountAccount() {
		
		try {
		
		AccountOutput testOutput = new AccountOutput("AE", 6);
		
		AustinEntity newEntity = mock(AustinEntity.class); // Create mock dependency: mock()	
		
		when(newEntity.getAccount()).thenReturn("AE"); // Setting up the expectations
		
		AccountOutput result = counterService.countAccount("AE");
					
		assertEquals(testOutput, result);
					
		verify(result).getAccount();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
