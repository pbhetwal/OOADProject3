class ConcreteTool extends Tools {
	/*
	:Description:	Concrete class - tool for wood work. 
					Costs $15. 
	*/
    public ConcreteTool(){
        setPrice(15);
        setCategory("Concrete");
    }
    public ConcreteTool(String name){
        setPrice(15);
        setCategory("Concrete");
        setName(name);
    }
}