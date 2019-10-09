class HardwareStore{
	private static HardwareStore ins = new HardwareStore();
	private HardwareStore(){}
	public static HardwareStore getInstance(){
		return ins; 
	}
}