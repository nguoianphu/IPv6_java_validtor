package validator;

public class Test {

	public static void main(String[] args) {
		
//		IPAddressValidator ipAddressValidator = new IPAddressValidator();
		Lucent ipLucent = new Lucent();
		
//		String ip = "192.168.94.6";
		String ip = "444:2001:dc9::d";
		
//		boolean ipTest = ipAddressValidator.isIpAddress(ip);
		boolean ipTest = ipLucent.validate(ip);
		
		System.out.println("Is IPAddress " + ip + " valid ? " + ipTest);

	}

}
