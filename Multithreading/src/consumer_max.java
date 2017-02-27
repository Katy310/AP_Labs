
public class consumer_max extends Thread{
	double[] data;
	consumer_max(double a[]){
		data=a;
	}
	double max;
	public void run(){	
		max = data[0];
		for(int i=0;i<100;i++){
			if(data[i]>max){
				max=data[i];
			}
		}
		
		System.out.println(max);
	}
	public double getmax(){
		return max;
	}
	

}
