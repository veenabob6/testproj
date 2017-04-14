package test.java.com.veena.hello;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.java.com.veena.hello.utilities.Greeter;



public class GreeterTest {

	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
		System.out.println(greeter.sayHello());
	}

}