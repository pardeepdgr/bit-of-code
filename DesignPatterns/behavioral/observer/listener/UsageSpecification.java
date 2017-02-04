package observer.listener;

import java.util.ArrayList;
import java.util.List;

public class UsageSpecification implements Observer{

	private List<String> columns = new ArrayList<String>();
	
	@Override
	public void update(String column) {
		if (!columns.contains(column))
			columns.add(column);
		System.out.println(column+" has been added in usage-spec.");
	}

}
