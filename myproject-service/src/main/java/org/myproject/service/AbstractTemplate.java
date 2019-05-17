package org.myproject.service;

/**
 * 模板模式
 * @author ken.chen
 *
 */
public abstract class AbstractTemplate<T> {

	public abstract T handle();
	
	public final void execute() {
		try {
			T t = handle();
			System.out.println("it is success,result="+t);
		}catch(Exception e) {
			System.out.println("it is error");
		}
	}
}
