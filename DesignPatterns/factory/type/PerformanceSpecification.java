package factory.type;

import java.util.List;

public class PerformanceSpecification implements Specification {

	private String id;
	private String name;
	private String version;
	private String description;
	private String type;
	private List<String> performanceIntervals;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getPerformanceIntervals() {
		return performanceIntervals;
	}

	public void setPerformanceIntervals(List<String> performanceIntervals) {
		this.performanceIntervals = performanceIntervals;
	}

}
