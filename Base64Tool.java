import java.util.Scanner;
import java.util.Base64;

public class Base64Tool
{
	public void getInput(String text)
	{
		// Gets the data required to process the text. That includes the choice to either encrypt or decrypt the text.
	
		Scanner scan = new Scanner(System.in);
		int choice;
		String finalText;
		System.out.println("[+] 1. Encode the text \n");
		System.out.println("[+] 2. Decode the text \n");
		choice = scan.nextInt();
		
		switch(choice)
		{
			case 1:
			finalText = encrypt(text);
			System.out.println(finalText);
			break;
			
			case 2:
			finalText = decrypt(text);
			System.out.println(finalText);
			break;
		}
	}
	
	public String encrypt(String txt)
	{
		//Encrypt the text and return the result.
		byte[] encoded = Base64.getEncoder().encode(txt.getBytes());
		return new String(encoded);
	}
	
	public String decrypt(String txt)
	{
		//Decrypt the text and return the result.
		byte[] text = txt.getBytes();
		byte[] decode = Base64.getDecoder().decode(text);
		return new String(decode);
	}
}
