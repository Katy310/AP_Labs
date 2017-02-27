
public final class Complex_Generic < T extends Number > {
	
	private T real;
	private T imaginary;
	
	public Complex_Generic( T real_val, T imaginary_val)
	{
		real = real_val;
		imaginary = imaginary_val;
	}
	
	public T get_real()
	{
		return this.real;
	}
	
	public T get_imaginary()
	{
		return this.imaginary;
	}
	
	public Complex_Generic<T> add ( Complex_Generic<T> operand )
	{	
		double real_val = operand.get_real().doubleValue();
		double imaginary_val = operand.get_imaginary().doubleValue();
		Complex_Generic<T> result = new Complex_Generic( real.doubleValue() + real_val, imaginary.doubleValue()+ imaginary_val);
		return result;
	}
	
	public Complex_Generic<T> subtract ( Complex_Generic<T> operand )
	{	
		double real_val = operand.get_real().doubleValue();
		double imaginary_val = operand.get_imaginary().doubleValue();
		Complex_Generic<T> result = new Complex_Generic( real.doubleValue() - real_val, imaginary.doubleValue()- imaginary_val);
		return result;
	}
	
	public Complex_Generic<T> multiply ( Complex_Generic operand )
	{	
		double real_val = operand.get_real().doubleValue();
		double imaginary_val = operand.get_imaginary().doubleValue();
		Complex_Generic<T> result = new Complex_Generic( ( real.doubleValue() * real_val ) - ( imaginary.doubleValue() * imaginary_val ), ( real.doubleValue() * imaginary_val ) + ( imaginary.doubleValue() * real_val) );
		return result;
	}
	
	public Complex_Generic<T> conjugate()
	{
		Complex_Generic<T> result = new Complex_Generic ( real.doubleValue(), -1 * imaginary.doubleValue());
		return result;
	}
	
	public double absolute()
	{
		double result = ( real.doubleValue() * real.doubleValue() ) + ( imaginary.doubleValue() * imaginary.doubleValue() );
		result = Math.sqrt(result);
		return result;
	}

	public void display()
	{	
		if ( imaginary.doubleValue() >= 0 )
		{
			System.out.println( real + " + " + imaginary + "i");
		}
		else
		{
			System.out.println( real + " - " + Math.abs(imaginary.doubleValue()) + "i");
		}
	}
	
	
}
