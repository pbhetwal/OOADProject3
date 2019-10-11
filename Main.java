import java.io.*;

public class Main {
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
}