package com.gmail.kramarenko104.annotation_example;

@CPUSocket(name = "Socket 1150")
public class Intel {

	private String chipset;
	
	public Intel(String chipset) {
		this.chipset = chipset;
	}
	
	@Override
	public String toString() {
		return "Intel [CPUSocket = 'Socket 1150', chipset: '" + chipset + "']";
	}
}
