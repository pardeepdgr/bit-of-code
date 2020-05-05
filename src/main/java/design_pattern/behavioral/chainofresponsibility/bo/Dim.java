package design_pattern.behavioral.chainofresponsibility.bo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("dim")
public class Dim {

	@XStreamAlias("Name")
	private String name;

	@XStreamAlias("dataType")
	private String dataType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}
