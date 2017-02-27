import java.util.ArrayList;
//import java.util.Scanner;

/*
 * Authors:
 * 
 * Katyayani Singh 2015046
 * 
 * Sagar Khurana 2015167
 * 
 * 
 */





public class Person {
	
	private String User_Name;
	private String Password;
	private String Disp_Name;
	private int No_Friends;
	private int No_Pending;
	private String Status;
	private ArrayList<String> Friends = new ArrayList<String>();
	private ArrayList<String> Pending = new ArrayList<String>();
	public int Dist;
	public Boolean MSTSet;
	
	public Person(String username,String psswd,String dispname){
		User_Name = username;
		Password = psswd;
		Disp_Name = dispname;
		No_Friends = 0;
		No_Pending = 0;
		Status = "Hey!There";
		Dist = Integer.MAX_VALUE;
		MSTSet = false;
	}
	
	public String getUsername(){
		return(User_Name);
	}
	
	public String getDispname(){
		return(Disp_Name);
	}
	
	public String getPsswd(){
		return(Password);
	}
	
	public String getStatus(){
		return(Status);
	}
	
	public int getNoFriends(){
		return(No_Friends);
	}
	
	public int getNoPending(){
		return(No_Pending);
	}
	
	public ArrayList<String> getFriends(){
		return(Friends);
	}
	
	public ArrayList<String> getPending(){
		return(Pending);
	}
	
	public String getFriendsByindex(int index){
		return(Friends.get(index));
	}
	
	public String getPendingByindex(int index){
		return(Pending.get(index));
	}
	
	public void UpdateStatus(String stat){
		Status = stat;
	}
	
	public Boolean isFriend(String name){
		return(Friends.contains(name));
	}
	
	public Boolean isPending(String name){
		return(Pending.contains(name));
	}
	
	public void AddFriend(String friend_name){
		Friends.add(friend_name);
		No_Friends ++;
	}
	
	public void AddPending(String user_name){
		Pending.add(user_name);
		No_Pending ++;
	}
	
	public void acceptRequest(String un)
	{
		Friends.add(un);
		No_Friends++;
		Pending.remove(un);
		No_Pending--;
	}
	
	public void rejectRequest(String un)
	{
		System.out.println("Friend Request Deleted");
		Pending.remove(un);
		No_Pending--;
	}
	
	public void addRequest(String un){
		Pending.add(un);
		No_Pending++;
	}
	
	public void PrintFriends(){
		int i;
		for(i = 0; i < No_Friends; i++){
			System.out.print(Friends.get(i));
			if(i != No_Friends - 1)
			{
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	public void PrintMutualFriends(Person p){
		int i,j;
		ArrayList<String> save = new ArrayList<String>();
		for(i = 0; i < No_Friends; i++){
			for(j = 0;j < p.getNoFriends(); j++){
				if(getFriendsByindex(i).equals(p.getFriendsByindex(j))){
					save.add(getFriendsByindex(i));
				}
			}
		}
		if(save.size() == 0)
		{
			System.out.println("No Mutual Friends");
		}
		else
		{
			for( i = 0; i < save.size() - 1; i++){
				System.out.print(save.get(i) + ",");
			}
			System.out.println(save.get(save.size() - 1));
		}
	}
	
	public void PrintPending(){
		int i;
		if(No_Pending == 0)
		{
			System.out.println("No New Friend Requests");
		}
		else
		{
			for(i = 0; i < No_Pending; i++){
				System.out.println((i+1) + ". " + Pending.get(i));
			}
		}
	}

	public String toString(){
		String object = User_Name + "," + Password + "," + Disp_Name + "," + No_Friends + ",";
		int i;
		
		for(i = 0; i < No_Friends; i++){
			object+= Friends.get(i);
			object+=",";
		}
		object+= No_Pending + ",";
		for(i = 0; i < No_Pending; i++){
			object+= Pending.get(i);
				object+=",";
		}
		object+= Status;
		//object+="\n";
		return (object);
	}
	
	
	
	
	
}
