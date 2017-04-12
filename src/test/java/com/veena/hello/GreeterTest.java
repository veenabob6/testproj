package com.veena.hello;



import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

import com.veena.hello.Greeter;

public class GreeterTest {

	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
		System.out.println(greeter.sayHello());
	}

}