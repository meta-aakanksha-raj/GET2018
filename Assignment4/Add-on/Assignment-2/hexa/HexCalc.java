package hexa;

public class HexCalc {
	/**
	 * To convert hexadecimal to decimal
	 * @param hexanum, is the hexadecimal number passed
	 * @return decimal value of hexadecimal number
	 */
	public int hexDec(String hexanum) {
		int value=0;
		String numbers="0123456789ABCDEF";
		hexanum=hexanum.toUpperCase();
		for(int i=0; i<hexanum.length();i++) {
			char ch = hexanum.charAt(i);
            int n = numbers.indexOf(ch);
            value = 16*value + n;
		}
		return value;	
	}

	/**
	 * To convert decimal to hexadecimal
	 * @param number is the decimal number passed
	 * @return hexadecimal value of decimal number
	 */
	public String decHex( int number) {
		int remainder;
		String output="";
		char hexa[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(number>0) {
			remainder=number%16;
			output=hexa[remainder]+output;
			number=number/16;
		}
		return output;
	}

	/**
	 * To add two hexadecimal values
	 * @param hex1, it is first hexadecimal number
	 * @param hex2, it is second hexadecimal number
	 * @return hexadecimal value after addition
	 */
	public String addHex(String hex1, String hex2) {
		int dec1,dec2,out;
		String hexadec="";
		dec1 = hexDec(hex1);
		dec2 = hexDec(hex2);
		out=dec1+dec2;
		hexadec=decHex(out);
		return hexadec;	
	}

	/**
	 * To subtract two hexadecimal values
	 * @param hex1, it is first hexadecimal number
	 * @param hex2, it is second hexadecimal number
	 * @return hexadecimal value after subtraction
	 */
	public String subHex(String hex1, String hex2) {
		int dec1,dec2,out;
		String hexadec="";		
		dec1 = hexDec(hex1);
		dec2 = hexDec(hex2);
		out=dec1-dec2;
		hexadec=decHex(out);
		return hexadec;	
	}

	/**
	 * To multiply two hexadecimal values
	 * @param hex1, it is first hexadecimal number
	 * @param hex2, it is second hexadecimal number
	 * @return hexadecimal value after multiplication
	 */
	public String multHex(String hex1, String hex2) {
		int dec1,dec2,out;
		String hexadec="";
		dec1 = hexDec(hex1);
		dec2 = hexDec(hex2);
		out=dec1*dec2;
		hexadec=decHex(out);
		return hexadec;
	}

	/**
	 * To division two hexadecimal values
	 * @param hex1, it is first hexadecimal number
	 * @param hex2, it is second hexadecimal number
	 * @return hexadecimal value after division
	 */
	public String divHex(String hex1, String hex2) {
		int dec1,dec2,out;
		String hexadec="";
		dec1 = hexDec(hex1);
		dec2 = hexDec(hex2);
		out=dec1/dec2;
		hexadec=decHex(out);
		return hexadec;
	}

	/**
	 * To find if first hexadecimal value is greater or not
	 * @param hex1, it is first hexadecimal number
	 * @param hex2, it is second hexadecimal number
	 * @return true if first number is greater else returns false
	 */
	public boolean greatHex(String hex1, String hex2) {
		boolean flag= false;
		int dec1,dec2,out;
		if(hex1.length()>hex2.length()) {
			flag=true;
		}
		else if(hex1.length()<hex2.length()) {
			flag=false;
		}
		else {
			if(hex1.length()==hex2.length()) {
				for(int i=0; i < hex1.length(); i++) {
					
					if(hex1.charAt(i) > hex2.charAt(i)) {
						flag=true;
						break;
					}
					else if(hex1.charAt(i) < hex2.charAt(i)) {
						flag=false;
						break;
					}
				}
			}				
		}
		return flag;
	}

	/**
	 * To find if first hexadecimal value is smaller or not
	 * @param hex1, it is first hexadecimal number
	 * @param hex2, it is second hexadecimal number
	 * @return true if first number is smaller else returns false
	 */
	public boolean smallHex(String hex1, String hex2) {
		boolean flag= false;
		int dec1,dec2,out;
		if(hex1.length()<hex2.length()) {
			flag= true;
		}
		else if(hex1.length()>hex2.length()) {
			flag=false;
		}
		else {
			if(hex1.length()==hex2.length()) {			
				for(int i=0;i<hex1.length();i++) {
					if(hex1.charAt(i)<hex2.charAt(i)) {
						flag=true;
						break;
					}
					else if(hex1.charAt(i)>hex2.charAt(i)) {
						flag=false;
						break;
					}	
				}	
			}	
		}
		return flag;
	}

	/**
	 * To find if both hexadecimal values are equal or not
	 * @param hex1, it is first hexadecimal number
	 * @param hex2, it is second hexadecimal number
	 * @return true if both are equal else returns false
	 */
	public boolean equalHex(String hex1, String hex2) {
		boolean flag= true;
		int dec1,dec2,out;
		if(hex1.length()==hex2.length()) {
			for(int i=0;i<hex1.length();i++) {
				if(hex1.charAt(i)!=hex2.charAt(i)) {
						flag=false;
						break;
				}	
			}		
		}
		else {
			flag=true;
		}
		return flag;
	}		
}