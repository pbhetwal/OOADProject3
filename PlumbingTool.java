class PlumbingTool extends Tools {
	/*
	:Description:	Concrete class - tool for plumbing work. 
					Costs $10. 
	*/
    public PlumbingTool(){
        setPrice(10);
        setCategory("Plumbing");
    }
    public PlumbingTool(String name){
        setPrice(10);
        setCategory("Plumbing");
        setName(name);
    }
}