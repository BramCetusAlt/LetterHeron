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
		int tool;
		String text;
		String encryptedText;
		Scanner scan = new Scanner(System.in);
		
	    try
		{
			while(contFlag)
			{
				text = "";
				
				System.out.println("Choose a tool. \n"); //Choose which tool will be used.
				System.out.println("[+] 1. Caesar Cipher tool \n");
				System.out.println("[+] 2. Base 64 tool \n");
				System.out.println("[+] 3. Show Help \n");
				System.out.println("[+] 4. Exit \n");
				tool = scan.nextInt();
				
				if(tool < 6 && tool > 0)
				{
					if(tool != 4) //If the user requested to exit the app, we won't need any more data.
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
					caesar.getInput(text);
					break;
			
					case 2:
					Base64Tool b64t = new Base64Tool();
					b64t.getInput(text);
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
