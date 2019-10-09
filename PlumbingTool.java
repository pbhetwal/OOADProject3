class Pubmbing extends Tools {
    public PaintingTool(){
        setPrice(7);
        setCategory("Plumbing");
        setRented(false);
    }
    public PaintingTool(String name){
        setPrice(7);
        setCategory("Plumbing");
        setRented(false);
        setName(name);
    }
}