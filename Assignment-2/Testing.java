import java.util.*;

class Hexa 
{
	public int hexdec(String str)
	{
		int value=0;
		String numbers="0123456789ABCDEF";
		str=str.toUpperCase();
		for(int i=0; i<str.length();i++)
		{
			char ch = str.charAt(i);
            int n = numbers.indexOf(ch);
            value = 16*value + n;
		}
		return value;
	    
		
	}
	
	public String dechex( int number)
	{
		int remainder;
		String output="";
		char hexa[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(number>0)
		{
			remainder=number%16;
			output=hexa[remainder]+output;
			number=number/16;
		}
		return output;
	}
	public int addhex()
	{
		String hex1,hex2;
		Scanner input = new Scanner(System.in);
		int dec1,dec2,out;
		System.out.print("Enter first hexadecimal number : ");
		hex1 = input.nextLine();
		System.out.print("Enter second hexadecimal number : ");
		hex2 = input.nextLine();
		dec1 = hexdec(hex1);
		dec2 = hexdec(hex2);
		System.out.println("first decimal number is " + dec1);
		System.out.println("second decimal number is " + dec2);
		out=dec1+dec2;
		System.out.println("Add="+out);
		return out;
		
	}
	public int subhex()
	{
		String hex1,hex2;
		Scanner input = new Scanner(System.in);
		int dec1,dec2,out;
		System.out.print("Enter first hexadecimal number : ");
		hex1 = input.nextLine();
		System.out.print("Enter second hexadecimal number : ");
		hex2 = input.nextLine();
		dec1 = hexdec(hex1);
		dec2 = hexdec(hex2);
		System.out.println("first decimal number is " + dec1);
		System.out.println("second decimal number is " + dec2);
		out=dec1-dec2;
		System.out.println("Sub="+out);
		return out;
		
	}
	public int multhex()
	{
		String hex1,hex2;
		Scanner input = new Scanner(System.in);
		int dec1,dec2,out;
		System.out.print("Enter first hexadecimal number : ");
		hex1 = input.nextLine();
		System.out.print("Enter second hexadecimal number : ");
		hex2 = input.nextLine();
		dec1 = hexdec(hex1);
		dec2 = hexdec(hex2);
		System.out.println("first decimal number is " + dec1);
		System.out.println("second decimal number is " + dec2);
		out=dec1*dec2;
		System.out.println("Mult="+out);
		return out;
		
	}
	public int divhex()
	{
		String hex1,hex2;
		Scanner input = new Scanner(System.in);
		int dec1,dec2,out;
		System.out.print("Enter first hexadecimal number : ");
		hex1 = input.nextLine();
		System.out.print("Enter second hexadecimal number : ");
		hex2 = input.nextLine();
		dec1 = hexdec(hex1);
		dec2 = hexdec(hex2);
		System.out.println("first decimal number is " + dec1);
		System.out.println("second decimal number is " + dec2);
		out=dec1/dec2;
		System.out.println("Div="+out);
		return out;
		
	}
	public boolean greathex()
	{
		int flag=0;
		String hex1,hex2;
		Scanner input = new Scanner(System.in);
		int dec1,dec2,out;
		System.out.print("Enter first hexadecimal number : ");
		hex1 = input.nextLine();
		System.out.print("Enter second hexadecimal number : ");
		hex2 = input.nextLine();
		if(hex1.length()>hex2.length())
		{
			flag=0;
		}
		else if(hex1.length()<hex2.length())
		{
			flag=flag+1;
		}
		else
		{
			for(int i=0;i<hex1.length();)
			{
				
				if(hex1.charAt(i)>hex2.charAt(i))
				{
					flag=0;
				}
				else if(hex1.charAt(i)<hex2.charAt(i))
				{
					flag=flag+1;
				}
				else
				{
					i++;
				}
			}	
			
		}
		if(flag==0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public boolean smallhex()
	{
		int flag=0;
		String hex1,hex2;
		Scanner input = new Scanner(System.in);
		int dec1,dec2,out;
		System.out.print("Enter first hexadecimal number : ");
		hex1 = input.nextLine();
		System.out.print("Enter second hexadecimal number : ");
		hex2 = input.nextLine();
		if(hex1.length()<hex2.length())
		{
			flag=0;
		}
		else if(hex1.length()>hex2.length())
		{
			flag=flag+1;
		}
		else
		{
			for(int i=0;i<hex1.length();)
			{
				if(hex1.charAt(i)<hex2.charAt(i))
				{
					flag=0;
				}
				else if(hex1.charAt(i)>hex2.charAt(i))
				{
					flag=flag+1;
				}
				else
				{
					i++;
				}
			}	
			
		}
		if(flag==0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public boolean equalhex()
	{
		String hex1,hex2;
		Scanner input = new Scanner(System.in);
		int dec1,dec2,out;
		System.out.print("Enter first hexadecimal number : ");
		hex1 = input.nextLine();
		System.out.print("Enter second hexadecimal number : ");
		hex2 = input.nextLine();
		if(hex1.length()==hex2.length())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		
}
public class Testing
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Hexa obj=new Hexa();
		System.out.println("Choose options: ");

		System.out.println("1. Hexadecimal Addition");
		System.out.println("2. Hexadecimal Subtraction");
		System.out.println("3. Hexadecimal Multiplication");
		System.out.println("4. Hexadecimal Division");
		System.out.println("5. First Hexadecimal Greater");
		System.out.println("6. First Hexadecimal Smaller");
		System.out.println("7. Both Hexadecimal Equal");
		System.out.println("8. Hexadecimal to Decimal Conversion");
		System.out.println("9. Decimal to Hexadecimal Conversion");
		int choice=input.nextInt();
		switch(choice)
		{
			case 1:
			{
				int output;
				System.out.println("You have chose addition ");
				output=obj.addhex();
				String hexadec="";
				hexadec=obj.dechex(output);
				System.out.println("Addition of hexadecimal number is: "+ hexadec);
				break;
			}
			case 2:
			{
				int output;
				System.out.println("You have chose subtraction ");
				output=obj.subhex();
				String hexadec="";
				hexadec=obj.dechex(output);
				System.out.println("Subtraction of hexadecimal number is: "+ hexadec);				
				break;
			}
			case 3:
			{
				int output;
				System.out.println("You have chose multiplication ");
				output=obj.multhex();
				String hexadec="";
				hexadec=obj.dechex(output);
				System.out.println("Multiplication of hexadecimal number is: "+ hexadec);							
				break;
			}
			case 4:
			{
				int output;
				System.out.println("You have chose Division ");
				output=obj.divhex();
				String hexadec="";
				hexadec=obj.dechex(output);
				System.out.println("Division of hexadecimal number gives: "+ hexadec);							
				break;
			}
			case 5:
			{
				
				System.out.println("You have chose First Hexadecimal Greater ");
				if(obj.greathex())
				System.out.println("Is first element greater? ");
						
				break;
			}
			case 6:
			{
				
				System.out.println("You have chose First Hexadecimal Smaller ");
				System.out.println("Is first element greater? "+obj.smallhex());
						
				break;
			}
			case 7:
			{
				
				System.out.println("You have chose Both Hexadecimal Equal ");
				System.out.println("Is first element greater? "+obj.equalhex());
						
				break;
			}
			case 8:
			{
				System.out.println("You have chose Hexadecimal to Decimal Conversion ");
				System.out.print("Enter a hexadecimal number : ");
				String tt="";
				tt=input.nextLine();
				System.out.println("hello");
				int dec;
				dec = obj.hexdec(tt);
				System.out.print("first decimal number is " + dec);
				break;
			}
			case 9:
			{
				System.out.println("You have chose Decimal to Hexadecimal Conversion ");
				System.out.print("Enter a decimal number : ");
				int num =input.nextInt();
				String hexadec="";
				hexadec=obj.dechex(num);
				System.out.print("Hexadecimal conversion of decimal is " + hexadec);
				break;
			}
			default: System.out.println("Wrong input!! Try again!!");
		}
	}
}