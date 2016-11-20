package chainofresponsibility.bo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("dimGroup")
public class DimGroup {

	@XStreamAlias("Name")
	@XStreamAsAttribute
	private String name;

	@XStreamImplicit(itemFieldName = "dim")
	private List<Dim> dims;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dim> getDims() {
		return dims;
	}

	public void setDims(List<Dim> dims) {
		this.dims = dims;
	}

}
