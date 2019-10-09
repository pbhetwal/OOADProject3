class YardworkTool extends Tools {
    public PaintingTool(){
        setPrice(7);
        setCategory("Yardwork");
        setRented(false);
    }
    public PaintingTool(String name){
        setPrice(7);
        setCategory("Yardwork");
        setRented(false);
        setName(name);
    }
}