class WoodworkTool extends Tools {
    public WoodworkTool(){
        setPrice(7);
        setCategory("Woodwork");
        setRented(false);
    }
    public WoodworkTool(String name){
        setPrice(7);
        setCategory("Woodwork");
        setRented(false);
        setName(name);
    }
}