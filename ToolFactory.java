public class ToolFactory{
    /*
	:Description:	Factory pattern used here - this is the class that will instantiate
	                tools.
	*/
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
        //add tool to store's hash map
        store.addToolToHashMap(tool);
    }
}