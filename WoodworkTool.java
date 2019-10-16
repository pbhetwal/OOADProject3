class WoodworkTool extends Tools {
	/*
	:Description:	Concrete class - tool for wood work. 
					Costs $13. 
	*/
    public WoodworkTool(){
        setPrice(13);
        setCategory("Woodwork");
    }
    public WoodworkTool(String name){
        setPrice(13);
        setCategory("Woodwork");
        setName(name);
    }
}