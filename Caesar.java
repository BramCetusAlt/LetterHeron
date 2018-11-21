import java.util.Scanner;

public class Caesar
{
	public void getInput(String text)
	/* Gets the data required to process the text. That includes the key and wether the user
	wants to encrypt or decrypt the text */	
	{
		Scanner scan = new Scanner(System.in);
		int choice;
		String finalText;
		System.out.println("Enter the key \n");
		int key = scan.nextInt();
		System.out.println("[+] 1. Encrypt the text \n");
		System.out.println("[+] 2. Decrypt the text \n");
		choice = scan.nextInt();
		
		switch(choice)
		{
			case 1:
			if(key <= 25 && key >=0)
			{
				finalText = encrypt(text, key);
				System.out.println(finalText);
			}
            else
			{
				System.out.println("The key has to be a number from 0 to 25 \n");
			}
			break;

			case 2:
			if(key <= 25 && key >=0)
			{
				finalText = decrypt(text, key);
				System.out.println(finalText);
			}
            else
			{
				System.out.println("The key has to be a number from 0 to 25 \n");
			}
			break;
		}
		
	}
	public String encrypt(String txt, int keyLength) 
	{
		//Encrypt the text and return the result.
		String encrypted = "";
		for(int i = 0; i < txt.length(); i++)
		{
			
			int c = txt.charAt(i);
			
			if(Character.isUpperCase(c))
			{
				c = c + (keyLength % 26);
				if(c > 'Z')
				{
					c = c - 26;
				}
			}
			else if(Character.isLowerCase(c))
			{
				c = c + (keyLength % 26);
				if(c > 'z')
				{
					c = c - 26;
				}
			}
			encrypted = encrypted + (char) c;
		}
		return encrypted;
	}
	public String decrypt(String txt, int keyLength)
	{
		//Decrypt the text and return the result.
		String decrypted = "";
		for(int i = 0; i < txt.length(); i++)
		{
			
			int c = txt.charAt(i);
			
			if(Character.isUpperCase(c))
			{
				c = c - (keyLength % 26);
				
				if(c < 'A')
				{
					c = c + 26;
				}
			}
			else if(Character.isLowerCase(c))
			{
				c = c - (keyLength % 26);
				if(c < 'a')
				{
					c = c + 26;
				}
			}
			decrypted = decrypted + (char) c;
		}
		return decrypted;
	}
}
