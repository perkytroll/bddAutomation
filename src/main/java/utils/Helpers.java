package utils;

public class Helpers {
	
	public static String getOSName()
	{
		String OSName= "";
		try
		{
			OSName = System.getProperty("os.name");
		} 
		catch (Exception e )
		{
			OSName = "unknown";
		}
		return OSName;
	}
}
