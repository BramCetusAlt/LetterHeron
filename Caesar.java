import java.util.Scanner;

public class Caesar
{
	
	public static String encrypt(String txt, int keyLength)
	{
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
	public static String decrypt(String txt, int keyLength)
	{
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
		