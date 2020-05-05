package design_pattern.creational.factory.type;

import java.util.List;

public class UsageSpecification implements Specification {

	private String specID;
	private String name;
	private String version;
	private String description;
	private List<String> characteristicID;

	public String getSpecID() {
		return specID;
	}

	public void setSpecID(String specID) {
		this.specID = specID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getCharacteristicID() {
		return characteristicID;
	}

	public void setCharacteristicID(List<String> characteristicID) {
		this.characteristicID = characteristicID;
	}

}
