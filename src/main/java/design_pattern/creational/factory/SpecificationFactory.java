package design_pattern.creational.factory;

import design_pattern.creational.factory.type.EntitySpecification;
import design_pattern.creational.factory.type.PerformanceSpecification;
import design_pattern.creational.factory.type.Specification;
import design_pattern.creational.factory.type.UsageSpecification;

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
