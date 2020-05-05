package design_pattern.behavioral.chainofresponsibility;

import design_pattern.behavioral.chainofresponsibility.bo.Parent;
import design_pattern.behavioral.chainofresponsibility.handler.DimGroupHandler;
import design_pattern.behavioral.chainofresponsibility.handler.FiltersHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UnmarshallerTest {

	private Parent parent;
	private Chained chain1;
	private Chained chain2;

	@Before
	public void setUp() {
		parent = new Unmarshaller().unmarshal("src/test/resources/design_pattern/behavioral/chainofresponsibility/data.xml");
		chain1 = new DimGroupHandler();
		chain2 = new FiltersHandler();

		chain1.setNextHandler(chain2);
	}

	@Test
	public void should_print_chain_of_responsibilities() {
		print(chain1.load(parent));
	}

	private void print(Map<String, List<String>> map) {
		for (Entry<String, List<String>> e : map.entrySet())
			System.out.println(e.getKey() + " ---->  " + e.getValue());
	}

}
