
public class Board {
	
	private char[][] arr = new char[3][3];
	private char current_player;
	
	public Board()
	{	
		for ( int i = 0; i < 3; i++ )
		{
			for ( int j = 0; j < 3; j++ )
			{
				arr[i][j] = '-';
			}
		}
		current_player = 'x';
	}
	
	public char get_player()
	{
		return current_player;
	}
	
	public void toggle_player()
	{
		if ( current_player == 'x' )
		{
			current_player = 'o';
		}
		else
		{
			current_player = 'x';
		}
	}
	
	public void put ( int x, int y, char val )
	{	
		if ( (x >= 0 && x < 3) && (y >= 0 && y < 3) )
		{
			arr[x][y] = val;
		}
		else
		{
			System.out.println("Invalid Coordinates");
		}
		
	}
	
	public char[][] get()
	{
		return arr;
	}
	
	public void print()
	{
		for ( int i = 0; i < 3; i++ )
		{
			for ( int j = 0; j < 3; j++ )
			{
				System.out.print(arr[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	
	public int check_state( )
	{	
		int flag = 0;
		
		for ( int i = 0; i < 3; i++ )
		{
			if ( arr[i][0] != '-' && arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2])
			{
				flag = 2;
				//System.out.println("1");
				
				return flag;
			}
		}
		
		
		for ( int j = 0; j < 3; j++ )
		{
			if ( arr[0][j] != '-' && arr[1][j] == arr[0][j] && arr[0][j] == arr[2][j])
			{
				flag = 2;
				//System.out.println("2");
				return flag;
			}
		}
		
		if ( arr[0][0] != '-' && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] )
		{	
			//System.out.println("3");
			flag = 2;
			return flag;
		}
		
		else if ( arr[0][2] != '-' && arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0] )
		{	
			//System.out.println("4");
			flag = 2;
			return flag;
		} 
		
		for ( int i = 0; i < 3; i++ )
		{
			for ( int j = 0; j < 3; j++ )
			{
				if ( arr[i][j] == '-' )
				{	
					flag = 1; // Board has an empty cell
					break;
				}
			}
			if ( flag == 1 ) // If board has an empty cell, break
			{
				break;
			} 
		}
		
		return flag;
	}
	
	public void print_state( int flag )
	{
		if ( flag == 0 )
		{
			System.out.println("Tie");
		}
		else if ( flag == 2 )
		{
			System.out.print(current_player);
			System.out.print(' ');
			System.out.println("wins");
		}
	}
	
	
}
