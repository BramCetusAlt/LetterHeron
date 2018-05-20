import java.util.Base64;

public class Base64Tool
{
	public static String encrypt(String txt)
	{
		byte[] encoded = Base64.getEncoder().encode(txt.getBytes());
		return new String(encoded);
	}
	public static String decrypt(String txt)
	{
		byte[] text = txt.getBytes();
		byte[] decode = Base64.getDecoder().decode(text);
		return new String(decode);
	}
}