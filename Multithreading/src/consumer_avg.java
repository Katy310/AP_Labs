
public class consumer_avg extends Thread {
	private double[] data;
	consumer_avg(double a[]){
		data=a;
	}
	private double avg;
	public void run(){	
		double total = 0;
		int count = 0;
		for(int i=0;i<100;i++){
			total = total + data[i];
			count++;
			
		}
		avg = total/count;
		System.out.println(avg);
	}
	public double getavg(){
		return avg;
		
	}
	

}
