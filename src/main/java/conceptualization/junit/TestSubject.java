package conceptualization.junit;

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
public class TestSubject {

	@Mock
	private Subject subject;

	@Test
	public void mockingConstrucotr_UsingPowerMock() throws Exception {
		/*Default Constructor*/
		PowerMockito.whenNew(Subject.class).withNoArguments().thenReturn(subject);
		/*Parameterized Constructor*/
		PowerMockito.whenNew(Subject.class).withArguments(Mockito.anyString()).thenReturn(subject);
	}

	@Test
	public void mockingSimpleInstanceMethod_UsingMockito() {
		Mockito.when(subject.instanceMethod()).thenReturn("mockito-instance");
		Assert.assertEquals("mockito-instance", subject.instanceMethod());
	}

	@Test
	public void mockingFinalMethod_UsingMockito() {
		Mockito.when(subject.finalMethod()).thenReturn("mockito-final");
		Assert.assertEquals("mockito-final", subject.finalMethod());
	}

	@Test
	public void mockingStaticMethod_UsingPowerMock() {
		PowerMockito.mockStatic(Subject.class);
		/*void Static Method*/
		PowerMockito.doNothing().when(Subject.class, "voidStaticMethod", Mockito.anyString());
		/*Static Method with return type*/
		PowerMockito.when(Subject.staticMethod()).thenReturn("powermock-static");
		Assert.assertEquals("powermock-static", Subject.staticMethod());
	}

	@Test
	public void mockingPrivateMethod_UsingPowerMock() throws Exception {
		/*WhiteBoxImpl actually uses Java Reflection API in the background to make a call*/
		String actual = WhiteboxImpl.invokeMethod(new Subject(), "privateMethod");
		Assert.assertEquals("private", actual);
	}
}
