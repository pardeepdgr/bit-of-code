package design_pattern.behavioral.chainofresponsibility.bo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("filters")
public class Filters {

	@XStreamImplicit(itemFieldName = "filter")
	private List<String> filter;

	public List<String> getFilter() {
		return filter;
	}

	public void setFilter(List<String> filter) {
		this.filter = filter;
	}

}
