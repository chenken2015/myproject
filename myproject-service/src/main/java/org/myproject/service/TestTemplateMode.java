package org.myproject.service;

public class TestTemplateMode{

	public static void main(String[] args) {
		new AbstractTemplate<Integer>() {
			@Override
			public Integer handle() {
				int i = 10/0;
				return i;
			}
		}.execute();
		
		new AbstractTemplate<TestTemplateMode>() {
			@Override
			public TestTemplateMode handle() {
				return new TestTemplateMode();
			}
		}.execute();
	}

}
