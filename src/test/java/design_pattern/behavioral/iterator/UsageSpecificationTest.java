package design_pattern.behavioral.iterator;

import org.junit.Test;

public class UsageSpecificationTest {

	private UsageSpecification spec = new UsageSpecification();;

	@Test
	public void should_iterate_over_transient_char_specs() {
		CharacteristicSpecificationIterator derivedIterator = spec
				.iterator("derived");
		while (derivedIterator.hasNext())
			print(derivedIterator.next());
	}

	@Test
	public void should_iterate_over_derived_char_specs() {
		CharacteristicSpecificationIterator transientIterator = spec
				.iterator("transient");
		while (transientIterator.hasNext())
			print(transientIterator.next());
	}

	private void print(CharacteristicSpecification charSpec) {
		System.out.println(charSpec.getTransientOrDerived() + " ::: "
				+ charSpec.getId());
	}
}
