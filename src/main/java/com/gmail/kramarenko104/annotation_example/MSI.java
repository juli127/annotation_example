package com.gmail.kramarenko104.annotation_example;

@Socket(name = "Socket 1150")
public class MSI {

	@Chipset(type = "AMD B350")
	private String mark;
	private String model;
	
	public MSI(String mark, String model) {
		this.mark = mark;
		this.model = model;
	}

	@Override
	public String toString() {
		return "MSI [mark=" + mark + ", model=" + model + "]";
	}
	
}
