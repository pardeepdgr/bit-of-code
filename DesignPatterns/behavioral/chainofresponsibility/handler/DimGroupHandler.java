package chainofresponsibility.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import chainofresponsibility.Chained;
import chainofresponsibility.bo.Dim;
import chainofresponsibility.bo.DimGroup;
import chainofresponsibility.bo.Parent;

public class DimGroupHandler implements Chained {

	private Chained chain;

	@Override
	public Map<String, List<String>> load(Parent parent) {
		Map<String, List<String>> output = chain.load(parent);
		if (parent.getDimGroups() != null) {
			for (DimGroup dimGroup : parent.getDimGroups()) {
				String dname = dimGroup.getName();
				List<String> value = new ArrayList<String>();
				List<Dim> dims = dimGroup.getDims();
				for (Dim dim : dims) {
					value.add(dim.getName().replace("\"",""));
					value.add(dim.getDataType().replace("\"",""));
				}
				output.put(dname, value);
			}
		}
		return output;
	}

	@Override
	public void setNextHandler(Chained chain) {
		this.chain = chain;
	}

}
