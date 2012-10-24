package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Lucent {
	
	private static Pattern VALID_IPV6_PATTERN = null;
	private static final String ipv6Pattern = "^(((?=(?>.*?::)(?!.*::)))(::)?([0-9A-F]{1,4}::?){0,5}|([0-9A-F]{1,4}:){6})(\\2([0-9A-F]{1,4}(::?|$)){0,2}|((25[0-5]|(2[0-4]|1\\d|[1-9])?\\d)(\\.|$)){4}|[0-9A-F]{1,4}:[0-9A-F]{1,4})(?<![^:]:|\\.)\\z";
	static {
		try {
			 VALID_IPV6_PATTERN = Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
		} catch (PatternSyntaxException e) {
			//logger.severe("Unable to compile pattern", e);
		}
	}
	
	public boolean validate(String fieldValue)
    {
		String fields[] = mySplit(fieldValue, ".");
		int octet;

		if ( fields.length != 4)
		{
			Matcher m2 = Lucent.VALID_IPV6_PATTERN.matcher(fieldValue);
		    if( m2.matches())
		    	return true;
		    else
			return false;
		}

		for( int i = 0; i < fields.length; i++)
		{
		    try
			{
        		Integer ival = new Integer(fields[i]);
        		octet = ival.intValue(); 
			}
			catch(Exception ex)
			{
        		return false;
			}  
			if ( (octet > 255) || (octet < 0))
			{
				return false;
			}
		}       
        return true;                  
    }

	private String[] mySplit( String value, String splitString)
	{
		int i;
		int scnt = 1;
		int startpos;
		int curStrIndex=0;

		// loop through one time to count 
		for( i=0; i< value.length();i++)
		{
			if (value.substring(i,i + splitString.length()).equals(splitString))scnt++;
		}
		String[] results = new String[scnt];
        
		// loop through again to assign the strings
		startpos = 0;
		for(i=0; i<value.length(); i++)
		{
			if (value.substring(i,i + splitString.length()).equals(splitString))
			{
				if (startpos == i )
				{
					results[curStrIndex]="";
				}
				else
				{
					results[curStrIndex] = value.substring(startpos,i);
				}
				startpos = i + splitString.length();
				curStrIndex++;
			}
		}
		if (startpos < value.length())
		{
			results[curStrIndex] = value.substring(startpos,value.length());
		}
		else
		{
			results[curStrIndex] = "";
		}
		return(results);
	}


}
