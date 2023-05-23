package com.jbk.ServiceIMPL;

import java.util.Iterator;

public class testClass {

	
	 int count =0;
	
	public void cou() {
		for(int i=0; i<=5;i++) {
			count++;
			
		}
	}
	
	public void ooo() {
		cou();
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		
		testClass tt= new testClass();
		tt.ooo();

	}

}
