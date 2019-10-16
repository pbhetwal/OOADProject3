class PlumbingTool extends Tools {
    public PlumbingTool(){
        setPrice(10);
        setCategory("Plumbing");
        setRented(false);
    }
    public PlumbingTool(String name){
        setPrice(10);
        setCategory("Plumbing");
        setRented(false);
        setName(name);
    }
}