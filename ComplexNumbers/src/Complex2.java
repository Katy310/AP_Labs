
public final class Complex2 {
	
	private Object real;
	private Object imaginary;
	
	public Complex2()
	{
		real = 0;
		imaginary = 0;
	}
	
	public Complex2( Object real_val, Object imaginary_val)
	{
		real = real_val;
		imaginary = imaginary_val;
	}
	
	public Object get_real()
	{
		return real;
	}
	
	public Object get_imaginary()
	{
		return imaginary;
	}
	
	public double absolute()
	{
		double real_p = 0, imaginary_p = 0;
		
		if ( real instanceof Integer )
		{	
			real_p = ((Integer) real).intValue();
		}
		else if ( real instanceof Float )
		{
			real_p = ((Float) real).floatValue();
		}
		else if ( real instanceof Double )
		{
			real_p = ((Double) real).doubleValue();
		}
		
		
		if ( imaginary instanceof Integer )
		{	
			imaginary_p = ((Integer) imaginary).intValue();
		}
		else if ( real instanceof Float )
		{
			imaginary_p = ((Float) imaginary).floatValue();
		}
		else if ( real instanceof Double )
		{
			imaginary_p = ((Double) imaginary).doubleValue();
		}
		
		double result = ( real_p * real_p ) + ( imaginary_p * imaginary_p);
		result = Math.sqrt(result);
		return result;
	}
	
	public Complex2 conjugate()
	{
		double real_p = 0, imaginary_p = 0;
		
		if ( real instanceof Integer )
		{	
			real_p = ((Integer) real).intValue();
		}
		else if ( real instanceof Float )
		{
			real_p = ((Float) real).floatValue();
		}
		else if ( real instanceof Double )
		{
			real_p = ((Double) real).doubleValue();
		}
		
		
		if ( imaginary instanceof Integer )
		{	
			imaginary_p = ((Integer) imaginary).intValue();
		}
		else if ( real instanceof Float )
		{
			imaginary_p = ((Float) imaginary).floatValue();
		}
		else if ( real instanceof Double )
		{
			imaginary_p = ((Double) imaginary).doubleValue();
		}
		
		double result_real = real_p;
		double result_imaginary = -1 * imaginary_p;
		
		Double res_real = new Double ( result_real );
		Double res_imaginary = new Double ( result_imaginary );
		Complex2 result = new Complex2( res_real, res_imaginary );
		return result;
	}
		
	public Complex2 complex_add ( Complex2 operand )
	{	
		Object real_val = operand.get_real();
		Object imaginary_val = operand.get_imaginary();
		double real_p = 0, real_part = 0, imaginary_p = 0, imaginary_part = 0;
		
		if ( real instanceof Integer )
		{	
			real_p = ((Integer) real).intValue();
		}
		else if ( real instanceof Float )
		{
			real_p = ((Float) real).floatValue();
		}
		else if ( real instanceof Double )
		{
			real_p = ((Double) real).doubleValue();
		}
		
		
		if ( imaginary instanceof Integer )
		{	
			imaginary_p = ((Integer) imaginary).intValue();
		}
		else if ( real instanceof Float )
		{
			imaginary_p = ((Float) imaginary).floatValue();
		}
		else if ( real instanceof Double )
		{
			imaginary_p = ((Double) imaginary).doubleValue();
		}
		
		
		if ( real_val instanceof Integer )
		{	
			real_part = ((Integer) real_val).intValue();
		}
		else if ( real_val instanceof Float )
		{
			real_part = ((Float) real_val).floatValue();
		}
		else if ( real_val instanceof Double )
		{
			real_part = ((Double) real_val).doubleValue();
		}
		
		
		if ( imaginary_val instanceof Integer )
		{	
			imaginary_part = ((Integer) imaginary_val).intValue();
		}
		else if ( imaginary_val instanceof Float )
		{
			imaginary_part = ((Float) imaginary_val).floatValue();
		}
		else if ( real_val instanceof Double )
		{
			imaginary_part = ((Double) imaginary_val).doubleValue();
		} 
		
		double result_real = real_p + real_part;
		double result_imaginary = imaginary_p + imaginary_part;
		
		Double res_real = new Double ( result_real );
		Double res_imaginary = new Double ( result_imaginary );
		Complex2 result = new Complex2( res_real, res_imaginary );
		return result;
	}
	
	public Complex2 subtract ( Complex2 operand )
	{	
		Object real_val = operand.get_real();
		Object imaginary_val = operand.get_imaginary();
		double real_p = 0, real_part = 0, imaginary_p = 0, imaginary_part = 0;
		
		if ( real instanceof Integer )
		{	
			real_p = ((Integer) real).intValue();
		}
		else if ( real instanceof Float )
		{
			real_p = ((Float) real).floatValue();
		}
		else if ( real instanceof Double )
		{
			real_p = ((Double) real).doubleValue();
		}
		
		
		if ( imaginary instanceof Integer )
		{	
			imaginary_p = ((Integer) imaginary).intValue();
		}
		else if ( real instanceof Float )
		{
			imaginary_p = ((Float) imaginary).floatValue();
		}
		else if ( real instanceof Double )
		{
			imaginary_p = ((Double) imaginary).doubleValue();
		}
		
		
		if ( real_val instanceof Integer )
		{	
			real_part = ((Integer) real_val).intValue();
		}
		else if ( real_val instanceof Float )
		{
			real_part = ((Float) real_val).floatValue();
		}
		else if ( real_val instanceof Double )
		{
			real_part = ((Double) real_val).doubleValue();
		}
		
		
		if ( imaginary_val instanceof Integer )
		{	
			imaginary_part = ((Integer) imaginary_val).intValue();
		}
		else if ( imaginary_val instanceof Float )
		{
			imaginary_part = ((Float) imaginary_val).floatValue();
		}
		else if ( real_val instanceof Double )
		{
			imaginary_part = ((Double) imaginary_val).doubleValue();
		}
		
		double result_real = real_p - real_part;
		double result_imaginary = imaginary_p - imaginary_part;
		
		Double res_real = new Double ( result_real );
		Double res_imaginary = new Double ( result_imaginary );
		Complex2 result = new Complex2( res_real, res_imaginary );
		return result;
	}
	
	public Complex2 multiply ( Complex2 operand )
	{	
		/* Object real_val = operand.get_real();
		Object imaginary_val = operand.get_imaginary();
		Object result_real =  ( real * real_val ) - ( imaginary * imaginary_val );
		Object result_imaginary = ( real * imaginary_val ) + ( imaginary * real_val ); */
		
		Object real_val = operand.get_real();
		Object imaginary_val = operand.get_imaginary();
		double real_p = 0, real_part = 0, imaginary_p = 0, imaginary_part = 0;
		
		if ( real instanceof Integer )
		{	
			real_p = ((Integer) real).intValue();
		}
		else if ( real instanceof Float )
		{
			real_p = ((Float) real).floatValue();
		}
		else if ( real instanceof Double )
		{
			real_p = ((Double) real).doubleValue();
		}
		
		
		if ( imaginary instanceof Integer )
		{	
			imaginary_p = ((Integer) imaginary).intValue();
		}
		else if ( real instanceof Float )
		{
			imaginary_p = ((Float) imaginary).floatValue();
		}
		else if ( real instanceof Double )
		{
			imaginary_p = ((Double) imaginary).doubleValue();
		}
		
		
		if ( real_val instanceof Integer )
		{	
			real_part = ((Integer) real_val).intValue();
		}
		else if ( real_val instanceof Float )
		{
			real_part = ((Float) real_val).floatValue();
		}
		else if ( real_val instanceof Double )
		{
			real_part = ((Double) real_val).doubleValue();
		}
		
		
		if ( imaginary_val instanceof Integer )
		{	
			imaginary_part = ((Integer) imaginary_val).intValue();
		}
		else if ( imaginary_val instanceof Float )
		{
			imaginary_part = ((Float) imaginary_val).floatValue();
		}
		else if ( real_val instanceof Double )
		{
			imaginary_part = ((Double) imaginary_val).doubleValue();
		}
		
		double result_real = ( real_p * real_part ) - ( imaginary_p * imaginary_part );
		double result_imaginary = ( real_p * imaginary_part ) + ( imaginary_p * real_part );
		
		Double res_real = new Double ( result_real );
		Double res_imaginary = new Double ( result_imaginary );
		Complex2 result = new Complex2( res_real, res_imaginary );
		return result;
	
	}


	public void display()
	{	
		double real_result = ((Double) real).doubleValue();
		double imaginary_result = ((Double) imaginary).doubleValue();
		
		if ( imaginary_result >= 0 )
		{
			System.out.println( real_result + " + " + imaginary_result + "i");
		}
		else
		{
			System.out.println( real_result + " - " + Math.abs(imaginary_result) + "i");
		}
	} 
	
	
}
