// Junit imports
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

// Program imports 
import java.util.HashMap;
public class AllTests{
	// Test 1: Test to ensure singleton is behaving properly 
	@Test
	public void testSingleton(){
		assertEquals(true, HardwareStore.getInstance() == HardwareStore.getInstance());
	}
	// Test 2: Test to ensure hash map has value null for tool without customer 
	@Test
	public void testHashMap(){
		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");
		store.addToolToHashMap(Brush);
		HashMap<Tools, Customer> map = store.getMap();
		assertNull(map.get("Brush"));

	}
}

