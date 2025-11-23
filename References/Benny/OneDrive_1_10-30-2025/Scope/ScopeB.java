package Scope;

import java.util.Scanner;


public class ScopeB 
{

	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args)
	{
		int x, y, z;
		x = 1;
		y = 2;
		z = 3;
		String s = "4";
		System.out.println("main: " + x + y + z + s);

		y = a(x);
		z = a(z);
		System.out.println("main: " + x + y + z + s);


		b(x, y, s);

		System.out.println("main: " + x + y + z + s);
	}

	public static int a(int x)
	{
		int y = 4;

		x = x + 1;
		y = x + 4;
		System.out.println("a: " + x + y);
		return y;
	}

	public static void b(int x, int y, String st)
	{
		System.out.println("b: " + x + y + st);
		st = "Hello World."	;
		System.out.println("b: " + x + y + st);

	}

}