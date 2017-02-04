package observer.subject;

import observer.listener.Observer;

public interface Subject {

	public boolean addObserver(Observer observer);

	public boolean removeObserver(Observer observer);

	public void notifyObserver(String column);
}
