import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int numDays = 35;
        HardwareStore store = HardwareStore.getInstance();
        List<Customer> customers = new LinkedList<Customer>();
        Tools Brush = new PaintingTool("Brush");
        Tools Canvas = new PaintingTool("Canvas");
        Tools PaintPan = new PaintingTool("PaintPan");
        Tools Tape = new PaintingTool("Tape");
        Tools Tarp = new PaintingTool("Tarp");
        Tools Pipe = new PlumbingTool("Pipe");
        Tools Hose = new PlumbingTool("Hose");
        Tools Faucet = new PlumbingTool("Faucet");
        Tools Joint = new PlumbingTool("Joint");
        Tools Sealant = new PlumbingTool("Sealant");
        Tools Pitchfork = new YardworkTool("Pitchfork");
        Tools Gloves = new YardworkTool("Gloves");
        Tools Wheelbarrow = new YardworkTool("Wheelbarrow");
        Tools Pruners = new YardworkTool("Pruners");
        Tools Mowers = new YardworkTool("Mowers");
        Tools Weedeater = new YardworkTool("Weedeater");
        Tools Shovel = new ConcreteTool("Shovel");
        Tools Mixer = new ConcreteTool("Mixer");
        Tools BagOfMix = new ConcreteTool("BagOfMix");
        Tools Axe = new WoodworkTool("Axe");
        Tools Saw = new WoodworkTool("Saw");
        Tools Woodfile = new WoodworkTool("Woodfile");
        Tools Sawhorse = new WoodworkTool("Sawhorse");
        store.addToolToHashMap(Brush);
        store.addToolToHashMap(Canvas);
        store.addToolToHashMap(PaintPan);
        store.addToolToHashMap(Tape);
        store.addToolToHashMap(Tarp);
        store.addToolToHashMap(Pipe);
        store.addToolToHashMap(Hose);
        store.addToolToHashMap(Faucet);
        store.addToolToHashMap(Joint);
        store.addToolToHashMap(Sealant);
        store.addToolToHashMap(Pitchfork);
        store.addToolToHashMap(Gloves);
        store.addToolToHashMap(Wheelbarrow);
        store.addToolToHashMap(Pruners);
        store.addToolToHashMap(Mowers);
        store.addToolToHashMap(Weedeater);
        store.addToolToHashMap(Shovel);
        store.addToolToHashMap(Mixer);
        store.addToolToHashMap(BagOfMix);
        store.addToolToHashMap(Axe);
        store.addToolToHashMap(Woodfile);
        store.addToolToHashMap(Sawhorse);
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
        store.newCust(Carl);
        store.newCust(Conner);
        store.newCust(Carrie);
        store.newCust(Charlie);
        store.newCust(Bill);
        store.newCust(Bob);
        store.newCust(Beatrice);
        store.newCust(Betty);
        store.newCust(Ron);
        store.newCust(Ralph);
        store.newCust(Rachel);
        store.newCust(Rebecca);
        cal.registerObserver(store);
        for(Customer c: customers){
            cal.registerObserver(c);
        }
        Random r = new Random();
        for(int i = 0; i < numDays; i++){
            int numCust = r.nextInt(customers.size() + 1);
            cal.startDay();
            for(int j = 0; j < numCust; j++){
                Customer temp = (Customer)customers.get(r.nextInt(customers.size()));
                temp.rent();
            }
            //store.allActiveRentals();
            //store.allToolsLeft();
            cal.endDay();
        }
    }
}