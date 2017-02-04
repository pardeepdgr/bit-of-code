package observer;

import observer.listener.UsageSpecification;
import observer.subject.CharactersticSpecification;
import observer.subject.EntitySpecification;

public class ColumnIntroducer {

	public static void addColumnForCharSpec(String column,
			CharactersticSpecification charSpec, UsageSpecification usageSpec) {
		charSpec.addObserver(usageSpec);
		charSpec.addColumn(column);
	}

	public static void addColumnForEntitySpec(String column,
			EntitySpecification entitySpec, UsageSpecification usageSpec) {
		entitySpec.addObserver(usageSpec);
		entitySpec.addColumn(column);
	}
}
