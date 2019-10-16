public class ToolFactory{
    private HardwareStore store = HardwareStore.getInstance();
    public void createTool(String type, String name){
        Tools tool;
        if(type == "Painting"){
            tool = new PaintingTool(name);
        }
        else if(type == "Concrete"){
            tool = new ConcreteTool(name);
        }
        else if(type == "Woodwork"){
            tool = new WoodworkTool(name);
        }
        else if(type == "Plumbing"){
            tool = new PlumbingTool(name);
        }
        else if(type == "Yardwork"){
            tool = new YardworkTool(name);
        }
        else{
            tool = null;
        }
        store.addToolToHashMap(tool);
    }
}