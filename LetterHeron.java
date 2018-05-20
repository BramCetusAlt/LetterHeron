import java.util.Scanner;

public class LetterHeron
{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) //Takes input for the tools that will be used and the text. Also checks for invalid input.
	{
		try{
			int tool;
	     
			String text = "";
			String encryptedText;
			System.out.println("Choose a tool. \n");
			System.out.println("[+] 1. Caesar Cipher tool \n");
			System.out.println("[+] 2. Base 64 tool \n");
			System.out.println("[+] 3. Character count tool \n");
			System.out.println("[+] 4. Help \n");
			tool = scan.nextInt();
			if(tool < 5 && tool > 0)
			{
				if(tool != 4)
				{
					System.out.println("Enter a text \n");
					text = scan.next();
				}
			} else {
				System.out.println("Invalid choice");
				System.exit(0);
			}
	
			switch(tool)
			{
				case 1:
				LetterHeron.askCaesar(text);
				break;
			
				case 2:
				LetterHeron.askBase64(text);
				break;
			
				case 3:
				LetterHeron.askCharTool(text);
				break;
			
				case 4:
				Help.helpUser();
				break;
				
				
			}
		}catch(Exception e)
		{
		  System.out.println("An error occurred: \n");
		  e.printStackTrace();
		}
		
	}
	public static void askCaesar(String text) //Takes input for the Caesar's Cipher tool. Also prints output.
	{
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
				finalText = Caesar.encrypt(text, key);
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
				finalText = Caesar.decrypt(text, key);
				System.out.println(finalText);
			}
            else
			{
				System.out.println("The key has to be a number from 0 to 25 \n");
			}
			break;
		}
	}
	public static void askBase64(String text) //Takes input for the Base64 tool. Also prints the output.
	{
		int choice;
		String finalText;
		System.out.println("[+] 1. Encode the text \n");
		System.out.println("[+] 2. Decode the text \n");
		choice = scan.nextInt();
		
		switch(choice)
		{
			case 1:
			finalText = Base64Tool.encrypt(text);
			System.out.println(finalText);
			break;
			
			case 2:
			finalText = Base64Tool.decrypt(text);
			System.out.println(finalText);
			break;
		}
	}
	public static void askCharTool(String text) //Takes input for the Character count tool. Also prints the output.
	{
		int numberCharAppears;
	    char charCount;
		System.out.println("Enter the character you wish to count \n");
		charCount = scan.next().charAt(0);
		numberCharAppears = CharacterTool.count(text, charCount);
		System.out.println(charCount + " appears " + numberCharAppears + " times.");
	}
}
			
		
		
