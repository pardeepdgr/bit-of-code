package chainofresponsibility.bo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("parent")
public class Parent {

	@XStreamAlias("Name")
	@XStreamAsAttribute
	private String name;

	@XStreamImplicit(itemFieldName = "dimGroup")
	private List<DimGroup> dimGroups;

	@XStreamAlias("filters")
	private Filters filters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DimGroup> getDimGroups() {
		return dimGroups;
	}

	public void setDimGroups(List<DimGroup> dimGroups) {
		this.dimGroups = dimGroups;
	}

	public Filters getFilters() {
		return filters;
	}

	public void setFilters(Filters filters) {
		this.filters = filters;
	}

}
