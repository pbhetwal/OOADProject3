import java.util.List;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class StoreRecord {
    private List<StringBuilder> storeRecord;
    public StoreRecord(){
        storeRecord = new LinkedList<StringBuilder>();
    }

    public void addRecord(StringBuilder dayRecord){
        storeRecord.add(dayRecord);
    }

    public void printRecord(){
        int orderCount = storeRecord.size();
        System.out.println("The total number of completed orders is " + orderCount);
        System.out.println("The list of completed orders is:");
        for(StringBuilder r: storeRecord){
            System.out.println(r);
        }
    }
}