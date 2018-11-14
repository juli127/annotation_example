package com.gmail.kramarenko104.annotation_example;

@CPUSocket(name = "Socket 1150")  
public class AMD {
	
	private String chipset;
	
	public AMD(String chipset) {
		this.chipset = chipset;
	}
	
	@Override
	public String toString() {
		return "AMD [CPUSocket = 'Socket 1150', chipset: '" + chipset + "']";
	}
}
