public class CharacterTool
{
	public static int count(String text, char charToCount)
	{
		int timesCharAppears = 0;
		for(int i = 0; i < text.length(); i++)
		{
		if(text.charAt(i) == charToCount)
		 {
		    timesCharAppears++;
		 }
		}
		return timesCharAppears;
	}
}