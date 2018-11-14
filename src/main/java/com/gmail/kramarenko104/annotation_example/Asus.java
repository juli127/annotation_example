package com.gmail.kramarenko104.annotation_example;

@Socket(name = "Socket 1151")
public class Asus {
	
	@Chipset(type = "Intel B250")
	private String mark;
	private String model;
	
	public Asus(String mark, String model) {
		this.mark = mark;
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Asus [mark=" + mark + ", model=" + model + "]";
	}
}
