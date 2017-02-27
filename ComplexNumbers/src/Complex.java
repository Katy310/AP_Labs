
public final class Complex {
	
	private int real;
	private int imaginary;
	
	public Complex()
	{
		real = 0;
		imaginary = 0;
	}
	
	public Complex( int real_val, int imaginary_val)
	{
		real = real_val;
		imaginary = imaginary_val;
	}
	
	public int get_real()
	{
		return real;
	}
	
	public int get_imaginary()
	{
		return imaginary;
	}
	
	public Complex add ( Complex operand )
	{	
		int real_val = operand.get_real();
		int imaginary_val = operand.get_imaginary();
		Complex result = new Complex( real + real_val, imaginary + imaginary_val);
		return result;
	}
	
	public Complex subtract ( Complex operand )
	{	
		int real_val = operand.get_real();
		int imaginary_val = operand.get_imaginary();
		Complex result = new Complex( real - real_val, imaginary - imaginary_val);
		return result;
	}
	
	public Complex multiply ( Complex operand )
	{	
		int real_val = operand.get_real();
		int imaginary_val = operand.get_imaginary();
		int result_real =  ( real * real_val ) - ( imaginary * imaginary_val );
		int result_imaginary = ( real * imaginary_val ) + ( imaginary * real_val );
		Complex result = new Complex( result_real, result_imaginary);
		return result;
	}
	
	public Complex conjugate()
	{
		Complex result = new Complex ( real, -imaginary);
		return result;
	}
	
	public double absolute()
	{
		double result = ( real * real ) + ( imaginary * imaginary );
		result = Math.sqrt(result);
		return result;
	}

	public void display()
	{	
		if ( imaginary >= 0 )
		{
			System.out.println( real + " + " + imaginary + "i");
		}
		else
		{
			System.out.println( real + " - " + Math.abs(imaginary) + "i");
		}
	}
	
	
}
