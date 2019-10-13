// Java imports 
import java.io.*;

// Junit imports
import static org.junit.Assert.*;
import org.junit.Test;

// Program imports 
import java.util.HashMap;

// All our tests
public class AllTests{

	// Test 1: Test to ensure singleton is behaving properly 
	@Test
	public void testSingleton(){
		assertEquals(true, HardwareStore.getInstance() == HardwareStore.getInstance());
	}
	// Test 2: Test to ensure hash map has value null for tool without customer 
	@Test
	public void testHashMapNull(){
		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");

		store.addToolToHashMap(Brush);
		HashMap<Tools, Customer> map = store.getMap();

		assertNull(map.get(Brush));
		map.clear();

	}
	// Test 3: Test to ensure hash map has value customer for tool with customer 
	@Test
	public void testHashMapCustomer(){
		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");

		store.addToolToHashMap(Brush);
		Customer Carl = new CasualCustomer("Carl", store);
		store.setHashMap(Brush, Carl);
		HashMap<Tools, Customer> map = store.getMap();

		assertSame(Carl, map.get(Brush));
		map.clear();
	} 

	// Test 4: Test to ensure allActiveRentals() is behaving correctly 
	@Test 
	public void testActiveRentals(){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out)); 

		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");

		store.addToolToHashMap(Brush);
		Customer Carl = new CasualCustomer("Carl", store);
		store.setHashMap(Brush, Carl);
		HashMap<Tools, Customer> map = store.getMap();
		store.allActiveRentals(); 
	
		assertEquals("Active Rentals are as follows: \nCarl is currently renting Brush\n", out.toString());

		map.clear();
	}


}

