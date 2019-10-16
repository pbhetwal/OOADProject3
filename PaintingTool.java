class PaintingTool extends Tools {
	/*
	:Description:	Concrete class - tool for wood work. 
					Costs $7. 
	*/
    public PaintingTool() {
        setPrice(7);
        setCategory("Painting");
    }
    public PaintingTool(String name) {
        setPrice(7);
        setCategory("Painting");
        setName(name);
    }
}