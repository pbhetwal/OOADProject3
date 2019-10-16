class YardworkTool extends Tools {
    public YardworkTool(){
        setPrice(17);
        setCategory("Yardwork");
        setRented(false);
    }
    public YardworkTool(String name){
        setPrice(17);
        setCategory("Yardwork");
        setRented(false);
        setName(name);
    }
}