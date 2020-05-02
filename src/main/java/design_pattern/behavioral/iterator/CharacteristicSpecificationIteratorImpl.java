package design_pattern.behavioral.iterator;

import java.util.List;

public class CharacteristicSpecificationIteratorImpl implements
		CharacteristicSpecificationIterator {

	private int index;
	private String type;
	private List<CharacteristicSpecification> charSpecs;

	public CharacteristicSpecificationIteratorImpl(String type,
			List<CharacteristicSpecification> charSpecs) {
		this.type = type;
		this.charSpecs = charSpecs;
	}

	@Override
	public boolean hasNext() {
		while (index < charSpecs.size()) {
			CharacteristicSpecification charSpec = charSpecs.get(index);
			if (charSpec.getTransientOrDerived().equals(type))
				return true;
			else
				index++;
		}
		return false;
	}

	@Override
	public CharacteristicSpecification next() {
		CharacteristicSpecification charSpec = charSpecs.get(index);
		index++;
		return charSpec;
	}

}