package design_pattern.behavioral.observer.subject;

import design_pattern.behavioral.observer.listener.Observer;

public interface Subject {

	public boolean addObserver(Observer observer);

	public boolean removeObserver(Observer observer);

	public void notifyObserver(String column);
}
