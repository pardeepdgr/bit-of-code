package design_pattern.behavioral.chainofresponsibility.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import design_pattern.behavioral.chainofresponsibility.Chained;
import design_pattern.behavioral.chainofresponsibility.bo.Dim;
import design_pattern.behavioral.chainofresponsibility.bo.DimGroup;
import design_pattern.behavioral.chainofresponsibility.bo.Parent;

public class DimGroupHandler implements Chained {

	private Chained chain;

	@Override
	public Map<String, List<String>> load(Parent parent) {
		Map<String, List<String>> output = chain.load(parent);

		if (parent.getDimGroups() != null) {
			for (DimGroup dimGroup : parent.getDimGroups()) {
				String name = dimGroup.getName();
				List<String> values = new ArrayList<String>();
				List<Dim> dims = dimGroup.getDims();
				for (Dim dim : dims) {
					values.add(dim.getName().replace("\"",""));
					values.add(dim.getDataType().replace("\"",""));
				}
				output.put(name, values);
			}
		}
		return output;
	}

	@Override
	public void setNextHandler(Chained chain) {
		this.chain = chain;
	}

}
