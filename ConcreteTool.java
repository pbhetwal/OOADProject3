class ConcreteTool extends Tools {
    public ConcreteTool(){
        setPrice(7);
        setCategory("Concrete");
        setRented(false);
    }
    public ConcreteTool(String name){
        setPrice(7);
        setCategory("Concrete");
        setRented(false);
        setName(name);
    }
}