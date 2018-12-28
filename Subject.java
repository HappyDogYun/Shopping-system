package question;

public interface Subject {
    public void removeObserver(Observer o);
    public void registerObserver(Observer o);
    public void notifyObservers();
}
