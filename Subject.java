public interface Subject<T> {
    public void registerObserver(T observer);
    public void removeObserver();
    public void notifyObserver();
}