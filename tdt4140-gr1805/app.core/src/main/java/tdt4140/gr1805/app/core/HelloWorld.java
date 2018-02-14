package tdt4140.gr1805.app.core;

public class HelloWorld {

	
	String helloworld;
	
	public HelloWorld(String helloworld) {
		
		this.helloworld = helloworld;
	}
	
	public String getName() {
		return this.helloworld;
	}
	
	
	public String toString() {
		return "Navnet på dette objektet er: " + this.getName();
	}
	
	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld("Hei verden, smudesmyd");
		System.out.println(hello.toString());
	}
}
