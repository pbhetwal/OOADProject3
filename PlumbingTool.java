class PlumbingTool extends Tools {
    public PlumbingTool(){
        setPrice(7);
        setCategory("Plumbing");
        setRented(false);
    }
    public PlumbingTool(String name){
        setPrice(7);
        setCategory("Plumbing");
        setRented(false);
        setName(name);
    }
}