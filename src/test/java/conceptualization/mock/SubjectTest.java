package conceptualization.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Subject.class)
public class SubjectTest {

	@Mock
	private Subject subject;

	@Test
	public void should_mock_simple_instance_method() {
		Mockito.when(subject.instanceMethod()).thenReturn("mockito-instance");
		Assert.assertEquals("mockito-instance", subject.instanceMethod());
	}

	@Test
	public void should_mock_default_constructor() throws Exception {
		PowerMockito.whenNew(Subject.class).withNoArguments().thenReturn(subject);
	}

	@Test
	public void should_mock_parameterized_constructor() throws Exception {
		PowerMockito.whenNew(Subject.class).withArguments(Mockito.anyString()).thenReturn(subject);
	}

	@Test
	public void should_mock_static_method() {
		PowerMockito.mockStatic(Subject.class);
		PowerMockito.when(Subject.staticMethod()).thenReturn("powermock-static");
		Assert.assertEquals("powermock-static", Subject.staticMethod());
	}

	@Test
	public void should_mock_static_method_which_returns_nothing() {
		PowerMockito.mockStatic(Subject.class);
		try {
			PowerMockito.doNothing().when(Subject.class, "voidStaticMethod", Mockito.anyString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void should_mock_final_method() {
		Mockito.when(subject.finalMethod()).thenReturn("mockito-final");
		Assert.assertEquals("mockito-final", subject.finalMethod());
	}

	@Test
	public void should_mock_private_method() throws Exception {
		/* WhiteBoxImpl actually uses Java Reflection API in the background to make a call */
		String actual = WhiteboxImpl.invokeMethod(new Subject(), "privateMethod");
		Assert.assertEquals("private", actual);
	}
}
