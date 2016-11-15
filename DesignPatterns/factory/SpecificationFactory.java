package factory;

import factory.type.EntitySpecification;
import factory.type.PerformanceSpecification;
import factory.type.Specification;
import factory.type.UsageSpecification;

public class SpecificationFactory {

	public static Specification getInstance(String type) {
		if ("usage".equals(type)) {
			return new UsageSpecification();
		} else if ("performance".equals(type)) {
			return new PerformanceSpecification();
		} else if ("entity".equals(type)) {
			return new EntitySpecification();
		}
		return null;
	}

}
