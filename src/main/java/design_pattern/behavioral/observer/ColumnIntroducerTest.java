package design_pattern.behavioral.observer;

import design_pattern.behavioral.observer.listener.UsageSpecification;
import design_pattern.behavioral.observer.subject.CharactersticSpecification;
import design_pattern.behavioral.observer.subject.EntitySpecification;

import org.junit.Test;

public class ColumnIntroducerTest {

	@Test
	public void testNewColumnIntroductionByCharSpec() {
		CharactersticSpecification charSpec = new CharactersticSpecification();
		UsageSpecification usageSpec = new UsageSpecification();

		ColumnIntroducer.addColumnForCharSpec("REPORT_TIME", charSpec,
				usageSpec);
	}

	@Test
	public void testNewColumnIntroductionByEntitySpec() {
		EntitySpecification entitySpec = new EntitySpecification();
		UsageSpecification usageSpec = new UsageSpecification();

		ColumnIntroducer.addColumnForEntitySpec("CELL_SAC", entitySpec,
				usageSpec);
	}

}
