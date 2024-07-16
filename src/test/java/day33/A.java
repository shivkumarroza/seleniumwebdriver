package day33;

public class A {

	public static void main(String[] args) {
		String str ="Showing 1 to 10 of 2758 (27 Pages)";
		System.out.println(str.indexOf("Page"));
		String subString = str.substring(str.indexOf("(")+1, str.indexOf("Page")-1);
		System.out.println(subString);

	}

}
