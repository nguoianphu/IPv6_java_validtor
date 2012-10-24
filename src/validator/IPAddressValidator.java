package validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class IPAddressValidator {
	
	private static Pattern VALID_IPV4_PATTERN = null;
	  private static Pattern VALID_IPV6_PATTERN = null;
	  private static final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
	  private static final String ipv6Pattern = "^(((?=(?>.*?::)(?!.*::)))(::)?([0-9A-F]{1,4}::?){0,5}|([0-9A-F]{1,4}:){6})(\\2([0-9A-F]{1,4}(::?|$)){0,2}|((25[0-5]|(2[0-4]|1\\d|[1-9])?\\d)(\\.|$)){4}|[0-9A-F]{1,4}:[0-9A-F]{1,4})(?<![^:]:|\\.)\\z";

	  static {
	    try {
	      VALID_IPV4_PATTERN = Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
	      VALID_IPV6_PATTERN = Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
	    } catch (PatternSyntaxException e) {
	      //logger.severe("Unable to compile pattern", e);
	    }
	  }
	  
	  public boolean isIpAddress(String ipAddress) {

		    Matcher m1 = IPAddressValidator.VALID_IPV4_PATTERN.matcher(ipAddress);
		    if (m1.matches()) {
		      return true;
		    }
		    Matcher m2 = IPAddressValidator.VALID_IPV6_PATTERN.matcher(ipAddress);
		    return m2.matches();
	  }

}
