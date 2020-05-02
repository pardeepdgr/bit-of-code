package design_pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a way to access the elements of an aggregate object 
 * without exposing its underlying representation
 */
public class UsageSpecification {

	public List<CharacteristicSpecification> columns;

	public UsageSpecification() {
		columns = getColumnsDetailFromXML();
	}

	public CharacteristicSpecificationIterator iterator(String type) {
		return new CharacteristicSpecificationIteratorImpl(type, this.columns);
	}

	private List<CharacteristicSpecification> getColumnsDetailFromXML() {
		List<CharacteristicSpecification> columns = new ArrayList<CharacteristicSpecification>();
		
		columns.add(getCharacteristicSpecification("CALLED_NUMBER",
				"CALLED_NUMBER", "CALLED_NUMBER", "String", "transient"));
		columns.add(getCharacteristicSpecification("CALL_CELL", "CELL_ID",
				"CELL_ID", "Number", "derived"));
		columns.add(getCharacteristicSpecification("DATA_ROAMER_FLAG",
				"ROAMER_FLAG", "ROAMER_FLAG", "String", "transient"));
		columns.add(getCharacteristicSpecification("SMS_DELIVERY_TIME",
				"DELIVERY_TIME", "DELIVERY_TIME", "Date", "transient"));
		columns.add(getCharacteristicSpecification("SMS_DELIVERY_TIME_DERIVED",
				"DELIVERY_TIME", "unix_timestamp(DELIVERY_TIME)", "Date",
				"derived"));
		return columns;
	}

	private CharacteristicSpecification getCharacteristicSpecification(
			String id, String name, String description, String valueType,
			String transientOrDerived) {
		CharacteristicSpecification charSpec = new CharacteristicSpecification();
		
		charSpec.setId(id);
		charSpec.setName(name);
		charSpec.setDescription(description);
		charSpec.setValueType(valueType);
		charSpec.setTransientOrDerived(transientOrDerived);
		return charSpec;
	}

}
