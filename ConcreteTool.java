class ConcreteTool extends Tools {
    public PaintingTool(){
        setPrice(7);
        setCategory("Concrete");
        setRented(false);
    }
    public PaintingTool(String name){
        setPrice(7);
        setCategory("Concrete");
        setRented(false);
        setName(name);
    }
}