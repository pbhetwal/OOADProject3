import java.io.*;
import java.util.List;
import java.util.LinkedList;

public class Main {
	/*
	:Description:	Runner class that simulates 35 days of our program. 
	*/
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Get singleton instance of HardwareStore
        HardwareStore store = HardwareStore.getInstance();

        List<Customer> customers = new LinkedList<Customer>();
        // Factory pattern used here
        ToolFactory toolCreator = new ToolFactory();
        toolCreator.createTool("Painting", "Brush");
        toolCreator.createTool("Painting", "Canvas");
        toolCreator.createTool("Painting", "PaintPan");
        toolCreator.createTool("Painting", "Tape");
        toolCreator.createTool("Painting", "Tarp");
        toolCreator.createTool("Painting", "Roller");
        toolCreator.createTool("Plumbing", "Pipe");
        toolCreator.createTool("Plumbing", "Hose");
        toolCreator.createTool("Plumbing", "Faucet");
        toolCreator.createTool("Plumbing", "Joint");
        toolCreator.createTool("Plumbing", "Sealant");
        toolCreator.createTool("Yardwork", "Pitchfork");
        toolCreator.createTool("Yardwork", "Gloves");
        toolCreator.createTool("Yardwork", "Wheelbarrow");
        toolCreator.createTool("Yardwork", "Pruners");
        toolCreator.createTool("Yardwork", "Mowers");
        toolCreator.createTool("Yardwork", "Weedeater");
        toolCreator.createTool("Concrete", "Shovel");
        toolCreator.createTool("Concrete", "Mixer");
        toolCreator.createTool("Concrete", "BagOfMix");
        toolCreator.createTool("Woodwork", "Axe");
        toolCreator.createTool("Woodwork", "Saw");
        toolCreator.createTool("Woodwork", "Woodfile");
        toolCreator.createTool("Woodwork", "Sawhorse");

        // Polymorphism used here 
        Customer Carl = new CasualCustomer("Carl", store);
        Customer Conner = new CasualCustomer("Conner", store);
        Customer Carrie = new CasualCustomer("Carrie", store);
        Customer Charlie = new CasualCustomer("Charlie", store);
        Customer Bill = new BusinessCustomer("Bill", store);
        Customer Bob = new BusinessCustomer("Bob", store);
        Customer Beatrice = new BusinessCustomer("Beatrice", store);
        Customer Betty = new BusinessCustomer("Betty", store);
        Customer Ron = new RegularCustomer("Ron", store);
        Customer Ralph = new RegularCustomer("Ralph", store);
        Customer Rachel = new RegularCustomer("Rachel", store);
        Customer Rebecca = new RegularCustomer("Rebecca", store);

        customers.add(Carl);
        customers.add(Conner);
        customers.add(Carrie);
        customers.add(Charlie);
        customers.add(Bill);
        customers.add(Bob);
        customers.add(Beatrice);
        customers.add(Betty);
        customers.add(Ron);
        customers.add(Ralph);
        customers.add(Rachel);
        customers.add(Rebecca);

        Calendar cal = Calendar.getInstance();
        // Observer pattern used here
        cal.registerObserver(store);
        for(Customer c: customers){
            store.newCust(c);
            cal.registerObserver(c);
        }
        cal.simulateDays();
    }
}