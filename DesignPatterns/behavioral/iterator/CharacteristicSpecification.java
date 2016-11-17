package iterator;

public class CharacteristicSpecification {

	private String id;
	private String name;
	private String description;
	private String valueType;
	private String transientOrDerived;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getTransientOrDerived() {
		return transientOrDerived;
	}

	public void setTransientOrDerived(String transientOrDerived) {
		this.transientOrDerived = transientOrDerived;
	}

}
