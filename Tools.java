public abstract class Tools {
    /*
    :Description:   Abstract class - concrete tools inherit from here. 
    */
    public String getName() {
        return name_;
    }
    public void setName(String name){
        name_ = name;
    }
    public int getPrice(){
        return price_;
    }
    public void setPrice(int price){
        price_ = price;
    }

    public String getCategory() {
        return category_;
    }

    public void setCategory(String category){
        category_ = category;
    }

    private int price_;
    private String name_;
    private String category_;

}