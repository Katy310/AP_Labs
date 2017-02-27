import java.util.*;

public class LabOne {
	
	public static Scanner s = new Scanner(System.in);
	public static int x, y;
	public static char val;
	public static Random rand = new Random(1);
	public static int[] answer = new int[2]; //Stores coordinates returned by AI algorithm
	
	public static int[] AI( char[][] arr, char val ) //Returns coordinates such that two places are occupied and one is blank
	{
		int[] array = new int[2];
		array[0] = 100;
		array[1] = 100;
		
		for ( int i = 0; i < 3; i++ )
		{
			if ( arr[i][0] == '-' && arr[i][1] == arr[i][2] && arr[i][1] == val )
			{
				array[0] = i;
				array[1] = 0;
				//System.out.println("1");
				return array;
			}
			
			else if ( arr[i][1] == '-' && arr[i][0] == arr[i][2] && arr[i][0] == val )
			{
				array[0] = i;
				array[1] = 1;
				//System.out.println("2");
				return array;
			}
			else if ( arr[i][2] == '-' && arr[i][0] == arr[i][1] && arr[i][0] == val )
			{
				array[0] = i;
				array[1] = 2;
				//System.out.println("3");
				return array;
			}
		}
		
		for ( int j = 0; j < 3; j++ )
		{
			if ( arr[0][j] == '-' && arr[1][j] == arr[2][j] && arr[1][j] == val )
			{
				array[0] = 0;
				array[1] = j;
				//System.out.println("4");
				return array;
			}
			
			else if ( arr[1][j] == '-' && arr[0][j] == arr[2][j] && arr[0][j] == val )
			{
				array[0] = 1;
				array[1] = j;
				//System.out.println("5");
				return array;
			}
			else if ( arr[2][j] == '-' && arr[0][j] == arr[1][j] && arr[0][j] == val )
			{
				array[0] = 2;
				array[1] = j;
				//System.out.println("6");
				return array;
			}
		}
		
		if ( arr[0][0] != '-' && arr[1][1] == arr[2][2] && arr[1][1] == val )
		{	
			array[0] = 0;
			array[1] = 0;
			//System.out.println("7");
			return array;
			
		}
		
		if ( arr[1][1] != '-' && arr[0][0] == arr[2][2] && arr[0][0] == val )
		{	
			array[0] = 1;
			array[1] = 1;
			//System.out.println("8");
			return array;
			
		}
		
		if ( arr[2][2] == '-' && arr[0][0] == arr[1][1] && arr[1][1] == val )
		{	
			array[0] = 2;
			array[1] = 2;
			//System.out.println("9");
			return array;
			
		}
		
		if ( arr[0][2] == '-' && arr[1][1] == arr[2][0] && arr[1][1] == val )
		{	
			array[0] = 0;
			array[1] = 2;
			//System.out.println("10");
			return array;
		}
		
		if ( arr[1][1] == '-' && arr[0][2] == arr[2][0] && arr[0][2] == val )
		{	
			array[0] = 1;
			array[1] = 1;
			//System.out.println("11");
			return array;
		}
		
		if ( arr[2][0] == '-' && arr[1][1] == arr[0][2] && arr[1][1] == val )
		{	
			array[0] = 2;
			array[1] = 0;
			//System.out.println("12");
			return array;
		}
		
		return array;
		
	}
	
	public static void main(String[] args) 
	{
		Board b = new Board();
		char[][] ttt = b.get();
		System.out.println("Choose game mode:");
		System.out.println("1. User1 versus User2");
		System.out.println("2. User versus computer");
		System.out.println("3. AI User versus computer");
		System.out.println("4. AI CPU versus User");
		
		int k = s.nextInt();
		b.print();
		System.out.println();
		switch (k)
		{
		case 1: do 
				{	
					ttt = b.get();
					do
					{	
						System.out.println("Enter coordinates:");
						x = s.nextInt();
						y = s.nextInt();
					}
					while ( (x < 0 || x >= 3) || (y < 0 || y >= 3) || ttt[x][y] != '-');
					
					val = b.get_player();
					b.put(x, y, val);
					b.print();
					int j = b.check_state();
					b.print_state( j );
					b.toggle_player();
					System.out.println();
				}
				while ( b.check_state() == 1 );
				break;
		case 2: int p = 0;
				do 
				{	
					if ( p % 2 == 0 )
					{	
						System.out.println("User");
						ttt = b.get();
						do
						{	
							System.out.println("Enter coordinates:");
							x = s.nextInt();
							y = s.nextInt();
						}
						while ( (x < 0 || x >= 3) || (y < 0 || y >= 3) || ttt[x][y] != '-');
						
						val = b.get_player();
						b.put(x, y, val);
						b.print();
						int j = b.check_state();
						b.print_state( j );
						b.toggle_player();
						System.out.println();
					}
					else
					{	
						System.out.println("Computer");
						ttt = b.get();
						do 
						{
							x = rand.nextInt(3);
							y = rand.nextInt(3);
						}
						while ( ttt[x][y] != '-' );
						
						val = b.get_player();
						b.put(x, y, val);
						b.print();
						int j = b.check_state();
						b.print_state( j );
						b.toggle_player();
						System.out.println();
					}
					p++;
					
				}
				while ( b.check_state() == 1 );
				break;
		case 3: p = 0;
				do 
				{		
					ttt = b.get();
					if ( p % 2 != 0 )
					{	
						System.out.println("AI");
						char player = b.get_player();
						answer = AI( ttt, player );
						if ( answer[0] != 100 ) //If current player has a winning move, make it
						{
							b.put(answer[0], answer[1], b.get_player());
							b.print();
							int j = b.check_state();
							b.print_state( j );
							b.toggle_player();
							System.out.println();
						}
						else if ( answer[0] == 100 )
						{
							if ( player == 'x' )
							{
								player = 'o';
							}
							else
							{
								player = 'x';
							}
							answer = AI( ttt, player );
							if ( answer[0] != 100 ) //If opposing player has a winning move, stop it
							{
								b.put(answer[0], answer[1], b.get_player());
								b.print();
								int j = b.check_state();
								b.print_state( j );
								b.toggle_player();
								System.out.println();
							}
							
							else
							{
								do 
								{
									x = rand.nextInt(3);
									y = rand.nextInt(3);
								}
								while ( ttt[x][y] != '-' );
								
								b.put(x, y, b.get_player());
								b.print();
								int j = b.check_state();
								b.print_state( j );
								b.toggle_player();
								System.out.println();
							}
							
						}
						
					}
					else 
					{		
						System.out.println("Computer");
						ttt = b.get();
						do 
						{
							x = rand.nextInt(3);
							y = rand.nextInt(3);
						}
						while ( ttt[x][y] != '-' );
						
						val = b.get_player();
						b.put(x, y, val);
						b.print();
						int j = b.check_state();
						b.print_state( j );
						b.toggle_player();
						System.out.println();
					}
					p++;
				
				}
				while ( b.check_state() == 1 );
				break; 
		case 4: p = 0;
				do 
				{		
					ttt = b.get();
					if ( p % 2 == 0 )
					{	
						System.out.println("AI");
						char player = b.get_player();
						answer = AI( ttt, player );
						if ( answer[0] != 100 ) //If current player has a winning move, make it
						{
							b.put(answer[0], answer[1], b.get_player());
							b.print();
							int j = b.check_state();
							b.print_state( j );
							b.toggle_player();
							System.out.println();
						}
						else if ( answer[0] == 100 )
						{	
							char player2;
							if ( player == 'x' )
							{
								player2 = 'o';
							}
							else
							{
								player2 = 'x';
							}
							ttt = b.get();
							answer = AI( ttt, player2 );
							//System.out.println(answer[0]);
							//System.out.println(answer[1]);
							if ( answer[0] != 100 ) //If opposing player has a winning move, stop it
							{
								b.put(answer[0], answer[1], b.get_player());
								b.print();
								int j = b.check_state();
								b.print_state( j );
								b.toggle_player();
								System.out.println();
							}
							
							else
							{	
								//System.out.println("Here");
								do 
								{
									x = rand.nextInt(3);
									y = rand.nextInt(3);
								}
								while ( ttt[x][y] != '-' );
								
								b.put(x, y, b.get_player());
								b.print();
								int j = b.check_state();
								b.print_state( j );
								b.toggle_player();
								System.out.println();
							}
							
						}
						
					}
					else 
					{		
						System.out.println("User");
						ttt = b.get();
						do
						{	
							System.out.println("Enter coordinates:");
							x = s.nextInt();
							y = s.nextInt();
						}
						while ( (x < 0 || x >= 3) || (y < 0 || y >= 3) || ttt[x][y] != '-');
						
						val = b.get_player();
						b.put(x, y, val);
						b.print();
						int j = b.check_state();
						b.print_state( j );
						b.toggle_player();
						System.out.println();
					}
					p++;
				
				}
				while ( b.check_state() == 1 );
				break; 
  
		}
	
	}
}
	

