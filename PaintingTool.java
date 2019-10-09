class PaintingTool extends Tools {
    public PaintingTool(){
        setPrice(7);
        setCategory("Painting");
        setRented(false);
    }
    public PaintingTool(String name){
        setPrice(7);
        setCategory("Painting");
        setRented(false);
        setName(name);
    }
}