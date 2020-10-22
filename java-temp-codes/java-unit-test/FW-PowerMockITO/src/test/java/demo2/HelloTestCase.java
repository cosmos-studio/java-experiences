package demo2;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Kitty.class, Hello.class})
public class HelloTestCase {

	@Test
	public void testMockNonStaticMethod() {
		Hello hello = new Hello();
		Kitty kittyMock = PowerMockito.mock(Kitty.class);
		hello.setKitty(kittyMock);
		PowerMockito.when(kittyMock.getName()).thenReturn("test");
		hello.mockNonStaticMethod();
	}

	@Test
	public void testMockStaticMethod() {
		Hello hello = new Hello();
		PowerMockito.mockStatic(Kitty.class);
		PowerMockito.when(Kitty.getNameStatic()).thenReturn("test");
		hello.mockStaticMethod();
	}
	
	@Test
	public void testPartialMock() {
		Hello helloMock = PowerMockito.spy(new Hello());
		try {
			PowerMockito.doNothing().when(helloMock, MemberMatcher.method(Hello.class, "_partialMock")).withNoArguments();;
		} catch (Exception e) {
			e.printStackTrace();
		}
		helloMock.partialMock();
	}
	
    @Test
    public void testMockVoidMethod() {
        Hello hello = new Hello();
        Kitty kitty = PowerMockito.mock(Kitty.class);
        hello.setKitty(kitty);
        PowerMockito.doNothing().when(kitty).say3();
        hello.mockVoidMethod();
    }
    
    @Test
    public void testMockParentMethod() {
        Hello hello = new Hello();
        PowerMockito.suppress(MemberMatcher.methodsDeclaredIn(Hi.class));
        hello.mockParentMethod();
    }
    
    @Test
    public void testPrivateMethod1() throws Exception {
    	Hello hello = new  Hello();
    	PowerMockito.verifyPrivate(hello).invoke("_partialMock");
    }

    @Test
    public void testPrivateMethod2() throws Exception {
    	Hello hello = new Hello();
    	Method method = Whitebox.getMethod(Hello.class, "_partialMock");
    	method.invoke(hello);
    }
 
	@Test
	public void testWhenNewOrConstructure() throws Exception {
		Hello hello = new Hello();
		Kitty kittyMock = PowerMockito.mock(Kitty.class);
		PowerMockito.whenNew(Kitty.class).withNoArguments().thenReturn(kittyMock);
		hello.mockWhenNew();
	}
	
}
