import java.io.*;

public class Main {
    public static void main(String[] args) {
        HardwareStore store = HardwareStore.getInstance();
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
        Customer Carl = new CasualCustomer();
        Customer Conner = new CasualCustomer();
        Customer Carrie = new CasualCustomer();
        Customer Charlie = new CasualCustomer();
        Customer Bill = new BusinessCustomer();
        Customer Bob = new BusinessCustomer();
        Customer Beatrice = new BusinessCustomer();
        Customer Betty = new BusinessCustomer();
        Customer Ron = new RegularCustomer();
        Customer Ralph = new RegularCustomer();
        Customer Rachel = new RegularCustomer();
        Customer Rebecca = new RegularCustomer();

    }
}