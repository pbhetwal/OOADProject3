// Java imports 
import java.io.*;
import java.util.*;

// Junit imports
import static org.junit.Assert.*;
import org.junit.Test;

// All our tests
public class AllTests{

	// Test 1: Test to ensure singleton is behaving properly 
	@Test
	public void testSingleton(){
		assertEquals(true, HardwareStore.getInstance() == HardwareStore.getInstance());
	}

	// Test 2: Test to ensure newCust(Customer) is behaving correctly 
	@Test
	public void testNewCust(){
		HardwareStore store = HardwareStore.getInstance();
		Customer Carl = new CasualCustomer("Carl", store);

		store.newCust(Carl);
		HashMap<String, Integer> map = store.getPriceMap();

		assertEquals(false, map.isEmpty()); 

		map.clear();
	}

	// Test 3: Test to ensure addToolToHashMap(Tool) is behaving correctly 
	@Test
	public void testAddToolToHashMap(){
		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");

		store.addToolToHashMap(Brush);
		HashMap<Tools, Customer> map = store.getMap();

		assertEquals(false, map.isEmpty()); 

		map.clear();
	}
	// Test 4: Test to ensure hash map has value null for tool without customer 
	@Test
	public void testHashMapNull(){
		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");

		store.addToolToHashMap(Brush);
		HashMap<Tools, Customer> map = store.getMap();

		assertNull(map.get(Brush));
		map.clear();

	}
	// Test 5: Test to ensure hash map has value customer for tool with customer 
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

	// Test 6: Test to ensure setToolsRented(int)/getToolsRented() is behaving correctly 
	@Test
	public void testGetToolsRented(){
		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");

		store.addToolToHashMap(Brush);
		Customer Carl = new CasualCustomer("Carl", store);
		store.setHashMap(Brush, Carl);
		HashMap<Tools, Customer> map = store.getMap();

		store.setToolsRented(1);
		int ret = store.getToolsRented();

		assertEquals(1, ret);

		map.clear();
	}

	// Test 7: Test to ensure allActiveRentals() is behaving correctly 
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

		String expected = "\nNumber of Active Rentals: " + 1 
						+ "\nActive Rentals are as follows: " 
						+ "\nCarl is currently renting Brush\n"; 

		assertEquals(expected, out.toString());

		map.clear();
	}

	// Test 8: Test to ensure allToolsLeft() is behaving correctly 
	@Test
	public void testToolsLeft(){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out)); 

		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");

		store.addToolToHashMap(Brush);
		Customer Carl = new CasualCustomer("Carl", store);
		store.setHashMap(Brush, Carl);
		HashMap<Tools, Customer> map = store.getMap();

		store.setToolsRented(1);
		store.allToolsLeft();

		String expected = "\nNumber of Tools left in the store: " + 23 
			            + "\nTools left in the store are as follows: \n";
		assertEquals(expected, out.toString());

		map.clear();	
	}

	// Test 9: Test to ensure chooseOption() is behaving correctly 
	@Test
	public void testChooseOption(){
		HardwareStore store = HardwareStore.getInstance();
		String ret = store.chooseOption(); 

		List<String> options = Arrays.asList("cord", "kit", "gear"); 

		assertEquals(true, options.contains(ret));
	}

	// Test 10: Ensure rent() isn't allowing more than 3 rentals 
	@Test
	public void testRent(){
		HardwareStore store = HardwareStore.getInstance();
		Tools Brush = new PaintingTool("Brush");
        Tools Canvas = new PaintingTool("Canvas");
        Tools PaintPan = new PaintingTool("PaintPan");
        Tools Tape = new PaintingTool("Tape");

        store.addToolToHashMap(Brush);
        store.addToolToHashMap(Canvas);
        store.addToolToHashMap(PaintPan);
        store.addToolToHashMap(Tape);
        HashMap<Tools, Customer> map = store.getMap();

        Customer Bob = new BusinessCustomer("Bob", store);
        store.newCust(Bob);

        /*
        Try to rent 5 times. This should be not allowed since 
        each customer can rent a maximum of 3 times. 
        */
        Bob.rent();
        Bob.rent();
        Bob.rent();
        Bob.rent();
        Bob.rent();

        assertEquals(3, Collections.frequency(map.values(), Bob));

        map.clear();
    }
}

