package initialize_package;

public class NerdTest {
	
	public static String text="THis is the whole world";

	public static void main(String[] args) {
		char[] charArray= text.toCharArray();
		for(int i =0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
		}
	}
}
