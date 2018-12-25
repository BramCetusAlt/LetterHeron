import java.util.Scanner;

public class LetterHeron
{ 
	public static void main(String[] args) 
	{
		//Calls the showMenu method.
			LetterHeron lh = new LetterHeron();
			lh.showMenu();
	}
	
	public void showMenu()
	{
		/* This method is pretty much the main menu. It asks the user to choose a tool to use and also enter the text he wants
		to process */
		boolean contFlag = true;
		boolean incorrectInput = true;
		boolean incorrectKey = true;
		int tool;
		int choice;
		int key = 0;
		String text;
		String encryptedText = "";
		Scanner scan = new Scanner(System.in);
		
		
	    try
		{
			while(contFlag)
			{
				text = "";
				
				System.out.println("Choose a tool. \n"); //The user chooses which tool to use.
				System.out.println("[+] 1. Caesar Cipher tool \n");
				System.out.println("[+] 2. Base 64 tool \n");
				System.out.println("[+] 3. Show Help \n");
				System.out.println("[+] 4. Exit \n");
				tool = scan.nextInt();
				
				if(tool < 6 && tool > 0)
				{
					if(tool != 4 && tool != 3) /*If the user requested to exit the app or has asked for the help page
												we won't need any more data.*/
					{							 
						System.out.println("Enter a text: \n"); //Enter the text that the tool will process.
						text = scan.next();
					}
				} 
				else 
				{
					System.out.println("Invalid choice");
				}
				switch(tool) //Calls the requested methods and sends them data to process.
				{
					case 1:
					Caesar caesar = new Caesar();
					while(incorrectInput) //Check if the choices the user has made are valid.
					{
						while(incorrectKey) //Check if the inputed key is valid.
						{
							System.out.println("Enter the key \n");
							key = scan.nextInt();
							if(key > 0 && key <= 25) incorrectKey = false;
							else System.out.println("The key must be a number from 1 to 25 \n");
						}
						System.out.println("[+] 1. Encrypt the text \n");
						System.out.println("[+] 2. Decrypt the text \n");
						System.out.println("[+] 3. Go back \n");
						choice = scan.nextInt();
						if(choice == 1) 
						{
							encryptedText = caesar.encrypt(text, key);
							incorrectInput = false;
						}
						else if(choice == 2) 
						{
							encryptedText = caesar.decrypt(text, key);
							incorrectInput = false;
						}
						else if(choice == 3)
						{
							incorrectInput = true;
						}
						else System.out.println("Your input is invalid!");
						System.out.println(encryptedText);
					}
					incorrectInput = true;
					break;
			
					case 2:
					Base64Tool b64t = new Base64Tool();
					while(incorrectInput) //Check if the choices the user has made are valid.
					{
						System.out.println("[+] 1. Encode the text \n");
						System.out.println("[+] 2. Decode the text \n");
						System.out.println("[+] 3. Go back \n");
						choice = scan.nextInt();
						if(choice == 1) 
						{
							encryptedText = b64t.encrypt(text);
							incorrectInput = false;
						}
						else if(choice == 2) 
						{
							encryptedText = b64t.decrypt(text);		
							incorrectInput = false;
						}
						else if(choice == 3)
						{
							incorrectInput = false;
						}
						else System.out.println("Your input is invalid!");
						System.out.println(encryptedText);
					}
					incorrectInput = true;
					break;
			
					case 3:
					showHelp();
					break;
					
					case 4:
					contFlag = false; //Break the loop and exit.
					break;
				}
				scan.nextLine(); //Clear the buffer.
			}
		}
		catch(Exception e)
		{
		  System.out.println("An error occurred! Details: \n");
		  e.printStackTrace();
		  showMenu(); 
		}
		
	}
	public static void showHelp() 
	{
		//Shows the user how to use this app.
		System.out.println("[+] This is a simple tool that can encrypt text using Caesar's cipher and Base64.");
		System.out.println("How to use the Caesar's Cipher tool:\n");
		System.out.println("Just enter the text you wish to encrypt or decrypt along with a number from 0 to 25.");
		System.out.println("That number is the key used to encrypt/decrypt the text.");
		System.out.println("How to use the Base64 tool:\n");
		System.out.println("Enter a text and choose whether you wish to encrypt or decrypt it.");
		System.out.println("NOTE: You cannot use spaces. You can use underscores or other characters to seperate words.");
	}
}
