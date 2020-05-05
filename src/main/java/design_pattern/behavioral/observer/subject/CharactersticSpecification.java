package design_pattern.behavioral.observer.subject;

import java.util.ArrayList;
import java.util.List;

import design_pattern.behavioral.observer.listener.Observer;

public class CharactersticSpecification implements Subject {

	private List<String> columns = new ArrayList<String>();
	private List<Observer> observers = new ArrayList<Observer>();

	@Override
	public boolean addObserver(Observer observer) {
		if (!observers.contains(observer))
			return observers.add(observer);
		return false;
	}

	@Override
	public boolean removeObserver(Observer observer) {
		return observers.remove(observer);
	}

	public void addColumn(String column) {
		if (!columns.contains(column))
			columns.add(column);
		System.out.println(column+" has been added in char-spec.");
		notifyObserver(column);
	}

	@Override
	public void notifyObserver(String column) {
		for (Observer observer : observers) {
			observer.update(column);
		}
	}

}
