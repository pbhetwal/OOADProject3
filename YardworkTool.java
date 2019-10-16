class YardworkTool extends Tools {
	/*
	:Description:	Concrete class - tool for yard work. 
					Costs $17. 
	*/
    public YardworkTool(){
        setPrice(17);
        setCategory("Yardwork");
    }
    public YardworkTool(String name){
        setPrice(17);
        setCategory("Yardwork");
        setName(name);
    }
}