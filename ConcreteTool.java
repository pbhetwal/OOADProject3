class ConcreteTool extends Tools {
    public ConcreteTool(){
        setPrice(15);
        setCategory("Concrete");
        setRented(false);
    }
    public ConcreteTool(String name){
        setPrice(15);
        setCategory("Concrete");
        setRented(false);
        setName(name);
    }
}