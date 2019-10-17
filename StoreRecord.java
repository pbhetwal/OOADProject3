import java.util.List;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class StoreRecord {
    /*
	:Description:	Class to store record of rentals as they are completed
	*/
    private List<StringBuilder> storeRecord;
    public StoreRecord(){
        storeRecord = new LinkedList<StringBuilder>();
    }

    public void addRecord(StringBuilder dayRecord){
        storeRecord.add(dayRecord);
    }

    //print the completed orders from the store
    public void printRecord(int orderCount){
        if(storeRecord.size() == 0){
            System.out.println("The total number of completed rentals is 0");
            System.out.println("The list of completed rentals is:");
            System.out.println("None");
            return;
        }
        System.out.println("The total number of completed rentals is " + orderCount);
        System.out.println("The list of completed rentals is:");
        for(StringBuilder r: storeRecord){
            System.out.println(r);
        }
    }
}