package design_pattern.behavioral.chainofresponsibility.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design_pattern.behavioral.chainofresponsibility.Chained;
import design_pattern.behavioral.chainofresponsibility.bo.Parent;

public class FiltersHandler implements Chained {

	private Chained chain;

	@Override
	public Map<String, List<String>> load(Parent parent) {
		Map<String, List<String>> output = new HashMap<String, List<String>>();
		if (parent.getFilters() != null)
			output.put("filters", parent.getFilters().getFilter());
		return output;
	}

	@Override
	public void setNextHandler(Chained chain) {
		this.chain = null;
	}

}
