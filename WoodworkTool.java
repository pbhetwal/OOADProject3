class WoodworkTool extends Tools {
    public PaintingTool(){
        setPrice(7);
        setCategory("Woodwork");
        setRented(false);
    }
    public PaintingTool(String name){
        setPrice(7);
        setCategory("Woodwork");
        setRented(false);
        setName(name);
    }
}