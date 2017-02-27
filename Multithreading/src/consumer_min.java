
public class consumer_min extends Thread{
	double[] data;
	consumer_min(double a[]){
		data=a;
	}
	double min;
	public void run(){	
		min = data[0];
		for(int i=0;i<100;i++){
			if(data[i]<min){
				min=data[i];
			}
		}
		
		System.out.println(min);
	}
	public double getmin(){
		return min;
		
	}
	
}
