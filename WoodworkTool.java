class WoodworkTool extends Tools {
    public WoodworkTool(){
        setPrice(13);
        setCategory("Woodwork");
        setRented(false);
    }
    public WoodworkTool(String name){
        setPrice(13);
        setCategory("Woodwork");
        setRented(false);
        setName(name);
    }
}