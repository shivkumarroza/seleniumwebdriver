package day41;

public class write {
	public static void main(String[] args) {
		
		String XL_Path="/Users/shiv/eclipse-workspace/seleniumwebdriver/data/output.xlsx";
		String sheeName="Sheet1";
		String value="shiv";
		Excel.setData(XL_Path, sheeName, 0, 1, value);
	}

}
