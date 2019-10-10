import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class SingletonTest{
	@Test
	public void testEqual(){
		assertEquals(true, HardwareStore.getInstance() == HardwareStore.getInstance());
	}
}

