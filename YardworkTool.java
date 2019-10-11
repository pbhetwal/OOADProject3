class YardworkTool extends Tools {
    public YardworkTool(){
        setPrice(7);
        setCategory("Yardwork");
        setRented(false);
    }
    public YardworkTool(String name){
        setPrice(7);
        setCategory("Yardwork");
        setRented(false);
        setName(name);
    }
}