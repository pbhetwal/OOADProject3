public interface Subject<T> {
	/*
	:Description:	Observer pattern used here - this is the interface 
					for the observable. 
	*/
    public void registerObserver(T observer);
    public void removeObserver();
    public void notifyObserver();
}