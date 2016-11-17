package iterator;

import org.junit.Test;

public class UsageSpecificationTest {

	private UsageSpecification spec = new UsageSpecification();;

	@Test
	public void iterateOverTransientCharSpecs() {
		CharacteristicSpecificationIterator derivedIterator = spec
				.iterator("derived");
		while (derivedIterator.hasNext())
			printCharSpec(derivedIterator.next());
	}

	@Test
	public void iterateOverDerivedCharSpecs() {
		CharacteristicSpecificationIterator transientIterator = spec
				.iterator("transient");
		while (transientIterator.hasNext())
			printCharSpec(transientIterator.next());
	}

	private void printCharSpec(CharacteristicSpecification charSpec) {
		System.out.println(charSpec.getTransientOrDerived() + " ::: "
				+ charSpec.getId());
	}
}
