import java.io.*;
import java.util.*;

/*
 * Authors:
 *
 * Katyayani Singh 2015046
 *
 * Sagar Khurana 2015167
 *
 *
 */






public class myNetwork {

	public static Person[] members = new Person[1000];
	public static int No_Members = 0;

	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Integer> que = new ArrayList<Integer>();
	public static int[] color_array = new int[100001];
	public static int[] previous = new int[100001];
	public static int check = 0;



	public static int Welcome() throws FileNotFoundException, UnsupportedEncodingException{
		int choice;
		System.out.println("1. Sign up\n2. Login\n3. Exit");
		choice = scan.nextInt();
		if(choice == 1)
		{
			System.out.println();
			Signup();
			return 0;
		}
		else if(choice == 2)
		{
			System.out.println();
			Login();
			return 0;
		}
		else
		{
			Write();
			// System Exit
			System.exit(0);
			return 0;
		}
	}


	public static int Signup() throws FileNotFoundException, UnsupportedEncodingException
	{
		String array[] = new String[3]; //Store user name, password, display name

		System.out.print("Enter username: ");
		array[0] = scan.next();
		System.out.print("Enter display name: ");
		scan.nextLine();
		array[2] = scan.nextLine();
		System.out.print("Enter password: ");
		array[1] = scan.next();
		System.out.println();

		if(IndexFinder(array[0]) == 0) //if user does not exist already
		{
			members[No_Members] = new Person(array[0], array[1], array[2]); // create a new user
			No_Members++; // increase the number of users by one
			System.out.println("Registration successful. User " + array[0] + " created.\n");
			//Print_Data();
			Write();
		}
		else // if user already exists, throw an exception
		{
			Write();
			try {
				throw new IOException("UserName Already Exist");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		//Write();
		Welcome(); // Return to Welcome screen
		return 0;

	}


	public static int Login() throws FileNotFoundException, UnsupportedEncodingException
	{
		String array[] = new String[3]; // Store user name, password

		System.out.print("Please enter your username: ");
		array[0] = scan.next();

		System.out.print("Please enter your password: ");
		array[1] = scan.next();

			if (IndexFinder(array[0]) != 0 ) //If user already exists
			{
				int i = IndexFinder(array[0]); //store index of the user

				if ( (members[i].getPsswd()).equals(array[1]) ) //if password of user at member[i] matches with password entered
				{
					System.out.println("\n" + members[i].getDispname() + " logged in now."); //Print logged in message
					System.out.println(members[i].getStatus() + "\n"); //Print status
					LoggedIn(array[0]); //Go to logged in screen
					return 0;
				}
				else //If password is incorrect, throw an exception
				{
					Write();
					try {
						throw new IOException("Your password is incorrect");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					Login(); //Return to login screen
					return 0;
				}
			}

			else //If user does not exist already, throw an exception
			{
				Write();
				try {
					throw new IOException("User Doesn't exist");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Welcome();
				return 0;
			}
	}


	public static int LoggedIn( String user ) throws FileNotFoundException, UnsupportedEncodingException
	{
		int index = IndexFinder( user ); //Find the index of the user in the members array
		//Print options
		System.out.println("1. List Friends");
		System.out.println("2. Search");
		System.out.println("3. Update status");
		System.out.println("4. Pending request");
		System.out.println("5. Logout");
		System.out.println();
		int option;
		option = scan.nextInt(); //Input option
		switch( option )
		{
			case 1: if(members[index].getNoFriends() == 0) //If user has no friends print message
					{
						System.out.println( "No Friends!:( Go Get a Life! ");
						LoggedIn(user); //Return to Logged in Screen
						return 0;
					}
					else //If user has friends, print them
					{
						System.out.print( "Your friends are ");
						members[index].PrintFriends();
						System.out.println();
						LoggedIn(user);
						return 0;
					}
					//break;
			case 2: System.out.print( "Enter UserName: "); //Enter user name of person the user wishes to search for
					String name = scan.next();
					Search(user,name); //Search the specified user in the members array
					return 0;
				//	break;
			case 3: System.out.print("Enter status: "); //Enter status to update
					scan.nextLine();
					String status = scan.nextLine();
					members[index].UpdateStatus( status ); //Update status
					System.out.println("Status updated!!"); //Print message
					Write();
					LoggedIn(user); //Return to logged in screen
					return 0;
					//break;
			case 4: Solve_Pending(index); //Resolve the pending requests
					return 0;
					//break;
			case 5: Write(); //If the user wishes to logout, write the changes to the file
					System.out.println("User " + members[index].getUsername() + " Logged Out Successfully!!");
					Welcome(); //Return t welcome screen
					return 0;


			//return 0;
		}
		return 0;

	}


	public static int Search  ( String user_name, String search ) throws FileNotFoundException, UnsupportedEncodingException
	{
		//User logged in: user
		//User to be searched: search
		int i,j;
		if(IndexFinder(search) == 0){ //If user to be searched does not exist,
			try {
				throw new IOException("User Doesn't Exist");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			LoggedIn(user_name); //Return o Logged in screen
			return 0;
		}
		else //If user to be searched exists
		{
			i = IndexFinder(user_name); //Find index of logged in user
			j = IndexFinder(search); //Find index of user to be searched
			char choice;
			if(members[i].isFriend(search)) //If logged in user is a friend of searched user
			{
				System.out.println("You and " + search + " are Friends"); //Print message
				System.out.println("Display Name: " + members[j].getDispname()); //print display name of searched user
				System.out.println("Status: " + members[j].getStatus()); //Print status of searched user
				System.out.print("Friends: "); //Print friends of searched user
				members[j].PrintFriends();
				System.out.print("Mutual Friends: "); //Print mutual friends of logged in user and searched user
				members[j].PrintMutualFriends(members[i]);
				System.out.println("b. Back");
				choice = scan.next().charAt(0);
				if(choice != 'b')
				{
					//Write();
					try {
						throw new IOException("Wrong Choice!!");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
				}
				LoggedIn(user_name); //return to logged in screen
				return 0;
			}
			else //If logged in user is not a friend of searched user
			{
				System.out.println(search + " is not your Friend"); //Print message
				System.out.print("Mutual Friends: "); //Print mutual friends
				members[j].PrintMutualFriends(members[i]);
				//System.out.print("Mutual Friends: ");
				System.out.print("Shortest Route: ");
				shortest_route(user_name,search);
				if(members[j].isPending(members[i].getUsername())) // If logged in user has sent searched user a friend request
				{
					System.out.println("Request is Pending."); //print message
					System.out.println("1. Cancel Request");
					System.out.println("b. Back");
					choice = scan.next().charAt(0);
					if(choice == '1') //If logged in user wants to cancel the pending request
					{
						members[j].rejectRequest(members[i].getUsername());
						Write();
					}
					else if(choice != 'b')
					{
						//Write();
						try {
							throw new IOException("Wrong Choice!!");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
					}
					LoggedIn(user_name); //Return to logged in screen
					return 0;
				}
				else //If logged in user has not sent a friend request to the searched user
				{
					System.out.println("1. Send Request");
					System.out.println("b. Back");
					choice = scan.next().charAt(0);
					if(choice == '1') //If logged in user wants to send a friend request to the searched user
					{
						members[j].addRequest(members[i].getUsername());
						Write();
						System.out.println("Request Sent.\n");
					}
					else if(choice != 'b')
					{
						Write();
						try {
							throw new IOException("Wrong Choice!!");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
					}
					//LoggedIn(user_name);
					Search(user_name,search);

					return 0;
				}
			}
		}
	}


	public static int IndexFinder(String un) //return the index of the user in the members array
	{
		int i, flag = 0;
		for(i = 0; i < No_Members; i++){
			if(members[i].getUsername().equals(un) ){
				flag = i;
			}
		}
		return flag;
	}

	public static int Solve_Pending(int index) throws FileNotFoundException, UnsupportedEncodingException   //Resolve pending friend requests
	{

		members[index].PrintPending(); //Print pending requests of logged in user
		System.out.println("b. Back");
		String Pending_Name;


		char choice = scan.next().charAt(0);
		int ch = choice - '0';
		int AR;  // Accept or reject 1 or 2.
		if(choice != 'b') //If user does not choose to go back
		{
			Pending_Name = members[index].getPendingByindex(ch - 1); //Print user name of chosen pending request
			System.out.println(members[IndexFinder(Pending_Name)].getDispname());
			System.out.println("1. Accept\n 2. Reject"); //Display options
			AR = scan.nextInt();
			if(AR == 1) // if user wants to accept the request
			{
				String user2 = members[index].getPendingByindex(ch - 1);
				members[index].acceptRequest(members[index].getPendingByindex(ch - 1)); //Accept the request
				System.out.println("You are now Friends with " + user2); //print message
				//System.out.println();
				members[IndexFinder(user2)].AddFriend(members[index].getUsername()); //Add logged in user to the friend list of the user who sent the request
				Write();
				Solve_Pending(index);
				return 0;
			}
			else //If user wants to reject the request
			{
				members[index].rejectRequest(members[index].getPendingByindex(ch - 1));
				Solve_Pending(index); // Prompt the user to resolve other pending requests
				return 0;
			}
		}
		else //If user chooses to go back
		{
			LoggedIn(members[index].getUsername()); //return to logged in screen
			return 0;
		}
	}


	public static void Print_Data() //Print all available data

	{
		int i;
		for ( i=0; i<No_Members; i++ )
		{
			System.out.print(members[i].toString());
		}
	}


	public static void Read_File() throws IOException //Read the text file database
	{
		int line = 0, j, k, friends = 0, pending = 0, count_members = 0;
		BufferedReader br = null;

		try
		{
			String sCurrentLine;

			br = new BufferedReader(new FileReader("src\\input.txt"));

			System.out.println("Reading database file...");
			line = 0;
			while ((sCurrentLine = br.readLine()) != null)
			{
				String s[]= sCurrentLine.split(",");
				//ArrayList<String> elephantList = Arrays.asList(sCurrentLine.split(","));
				//System.out.println(s[1] + s[2] + s[0]);
				members[line] = new Person(s[0], s[1], s[2]);
				friends = Integer.parseInt(s[3]);
				for  ( j = 4; j < friends+4; j++)
				{
					members[line].AddFriend(s[j]);
				}
				pending = Integer.parseInt(s[friends+4]);
				for  ( k = (friends + 4 + 1); k < (friends + 4 + 1 + pending); k++)
				{
					//System.out.println("z");
					members[line].AddPending(s[k]);
				}
				members[line].UpdateStatus(s[friends + 4 + 1 + pending]);
				line++;
				count_members++;
			}

		}
		catch (IOException e)
		{
			//e.printStackTrace();
		}
		finally
		{
			try
			{
				if (br != null)br.close();
			}
			catch (IOException ex)
			{
				//ex.printStackTrace();
			}
		}
		System.out.println("Network is ready\n");
		No_Members = count_members;
	}

	public static void Write() throws FileNotFoundException, UnsupportedEncodingException //Write the contents of members array to the text file
	{
		PrintWriter writer = new PrintWriter("src\\input.txt");

		for (int i = 0; i< No_Members; i++)
		{
			writer.println(members[i].toString());
		}
		writer.close();
	}


	public static void print_path( int destination )
	{


		if ( previous[destination] != -1 )
		{
			print_path( previous[ destination ]);
		}

		if ( check != destination )
		{
			System.out.print( members[destination].getUsername() + " -> " );
		}
		else
		{
			System.out.println( members[destination].getUsername() );
		}


	}


	public static void shortest_route( String Source, String Destination )
	{
		for ( int i = 0; i < 100001; i++ )
		{
			previous[i] = -1;
		}
		for ( int i = 0; i < 100001; i++ )
		{
			color_array[i] = 0;
		}

		//System.out.print(Source + " -> ");
		int[] queue = new int[100001];

		int current = -1;

		int source = IndexFinder( Source );
		int destination = IndexFinder( Destination );
		check = destination;
		color_array[ source ] = 1;

		int front = -1;
		int rear = -1;

		if( front == rear )
	    {
	        front++;
	        rear++;
	    }

	    else
	    {
	        rear++;
	    }

		queue[rear] = source;

	    while ( front <= rear && current != destination )
	    {
	        current = queue[front];
	        front++;

	        int temp = 0;
	        ArrayList<String> Friends_of_current = new ArrayList<String>();
	        Friends_of_current = members[current].getFriends();
	        while ( temp < members[current].getNoFriends() )
	        {
	            if ( color_array[ IndexFinder(Friends_of_current.get( temp )) ] == 0 )
	            {
	                color_array[ IndexFinder(Friends_of_current.get( temp )) ] = 1;
	                previous[ IndexFinder(Friends_of_current.get( temp )) ] = current;
	                //System.out.print( Friends_of_current.get(temp) + "->" );
	                rear++;
	                queue[rear] = IndexFinder(Friends_of_current.get( temp ));


	            }

	            temp++;
	        }
	        //System.out.println("Done1");
	        color_array[ current ] = 2;
	       //System.out.print( members[current].getUsername() + " -> " );
	    }

	   print_path(destination);

	}

}
