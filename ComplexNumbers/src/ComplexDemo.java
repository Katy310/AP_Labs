import java.util.Scanner;

public class ComplexDemo {

	public static void main(String[] args) {
		
		System.out.println("Normal class");
		Scanner scan = new Scanner(System.in);
		double a, b, c, d;
		System.out.println("Enter the real part of first number");
		a = scan.nextInt();
		System.out.println("Enter the imaginary part of first number");
		b = scan.nextInt();
		System.out.println("Enter the real part of second number");
		c = scan.nextInt();
		System.out.println("Enter the imaginary part of second number");
		d = scan.nextInt();
		
		
		Complex operand_1 = new Complex ( (int)a, (int)b );
		Complex operand_2 = new Complex ( (int)c, (int)d);
		Complex result;
		
		System.out.println("Add");
		result = operand_1.add(operand_2);
		result.display();
		
		System.out.println("Subtract");
		result = operand_1.subtract(operand_2);
		result.display();
		
		System.out.println("Multiply");
		result = operand_1.multiply(operand_2);
		result.display(); 
		
		System.out.println("Conjugate of first number");
		result = operand_1.conjugate();
		result.display();
		
		System.out.println("Absolute of second number");
		System.out.println( operand_2.absolute() );
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("Select type of operand");
		System.out.println("1. Int");
		System.out.println("2. Float");
		System.out.println("3. Double");
		
		int choice = scan.nextInt();
		
		if ( choice == 1 )
		{
			System.out.println("Enter the real part of first number");
			a = scan.nextInt();
			System.out.println("Enter the imaginary part of first number");
			b = scan.nextInt();
			System.out.println("Enter the real part of second number");
			c = scan.nextInt();
			System.out.println("Enter the imaginary part of second number");
			d = scan.nextInt();
		}
		
		else if ( choice == 2 )
		{	
			
			System.out.println("Enter the real part of first number");
			a = scan.nextFloat();
			System.out.println("Enter the imaginary part of first number");
			b = scan.nextFloat();
			System.out.println("Enter the real part of second number");
			c = scan.nextFloat();
			System.out.println("Enter the imaginary part of second number");
			d = scan.nextFloat();
		}
		
		else if ( choice == 3 )
		{
			System.out.println("Enter the real part of first number");
			a = scan.nextDouble();
			System.out.println("Enter the imaginary part of first number");
			b = scan.nextDouble();
			System.out.println("Enter the real part of second number");
			c = scan.nextDouble();
			System.out.println("Enter the imaginary part of second number");
			d = scan.nextDouble();
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Object Class");
		
		Complex2 operand1 = new Complex2 ( a, b );
		Complex2 operand2 = new Complex2 ( c, d);
		Complex2 result2;
		
		System.out.println("Add");
		result2 = operand1.complex_add(operand2);
		result2.display();
		
		System.out.println("Subtract");
		result2 = operand1.subtract(operand2);
		result2.display();
		
		System.out.println("Multiply");
		result2 = operand1.multiply(operand2);
		result2.display();
		
		System.out.println("Conjugate of first number");
		result2 = operand1.conjugate();
		result2.display();
		
		System.out.println("Asolute of second number");
		System.out.println( operand2.absolute() );
		
		System.out.println();
		System.out.println();
		
		
		
		
		System.out.println("Generic Class");
		
		Complex_Generic<Double> complex = new Complex_Generic(a,b);
		Complex_Generic<Double> complex2 = new Complex_Generic(c,d);
		Complex_Generic<Double> complex3;
		
		System.out.println("Add");
		complex3 = complex.add(complex2);
		complex3.display();
		
		System.out.println("Subtract");
		complex3 = complex.subtract(complex2);
		complex3.display();
		
		System.out.println("Multiply");
		complex3 = complex.multiply(complex2);
		complex3.display();
		
		System.out.println("Conjugate of first number");
		complex3 = complex.conjugate();
		complex3.display();
		
		System.out.println("Absolute of second number");
		System.out.println( complex2.absolute() );
		
		System.out.println();
		System.out.println();
		
		scan.close();
	}

}
