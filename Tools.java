public abstract class Tools {
    public boolean isAvailable(){
        if(rented_ == true){
            return false;
        }
        return true;
    }
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
    public boolean getRented(){
        return rented_;
    }
    public void setRented(boolean rented){
        rented_ = rented;
    }
    private int price_;
    private String name_;
    private String category_;
    private boolean rented_;
}