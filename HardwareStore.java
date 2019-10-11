// Singleton pattern used here 
class HardwareStore{
	private static HardwareStore ins = new HardwareStore();
	private HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	
	private HardwareStore(){
		System.out.println("Our hardware rental store is now open!");
	}
	public static HardwareStore getInstance(){
		return ins; 
	}


}