package chainofresponsibility;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import chainofresponsibility.bo.Parent;
import chainofresponsibility.handler.DimGroupHandler;
import chainofresponsibility.handler.FiltersHandler;

public class UnmarshallerTest {

	private Parent parent;
	private Chained chain1;
	private Chained chain2;

	@Before
	public void setUp() {
		parent = new Unmarshaller().unmarshall("file.xml");
		chain1 = new DimGroupHandler();
		chain2 = new FiltersHandler();

		chain1.setNextHandler(chain2);
	}

	@Test
	public void testParsingOfXML() {
		print(chain1.load(parent));
	}

	private void print(Map<String, List<String>> map) {
		for (Entry<String, List<String>> e : map.entrySet())
			System.out.println(e.getKey() + " ---->  " + e.getValue());
	}

}
