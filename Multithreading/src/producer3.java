import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class producer3 extends Thread{
	public void run(){
		FileReader in;
		try {
			sleep(15000);
			in = new FileReader("rainfall");
			BufferedReader in1 = new BufferedReader(in);
			String a = in1.readLine();
			double b;
			double[] data1 = new double[100];
			
			for(int i=0;i<100;i++){
				b = Double.parseDouble(a);
				data1[i]=b;
				a = in1.readLine();
				if(i==99 || i==199 || i==299 || i==399){
					a = in1.readLine();
				}
			}
			//in1.close();
			System.out.println("Dataset 1");
			consumer_max max = new consumer_max(data1);
			System.out.println("the maximum rainfall is: " );
			
			max.start();
			sleep(1000);
			//double temp_max = max.getmax();
			consumer_min min = new consumer_min(data1);
			System.out.println("the minimum rainfall is: " );
			min.start();
			sleep(1000);
			//double temp_min = min.getmin();
			
			consumer_avg avg = new consumer_avg(data1);
			System.out.println("the average rainfall is: ");
			avg.start();
			sleep(1000);
			//double temp_avg = avg.getavg();
			
			
			double[] data2 = new double[100];
			
			for(int i=0;i<100;i++){
				b = Double.parseDouble(a);
				data2[i]=b;
				a = in1.readLine();
				if(i==99 || i==199 || i==299 || i==399){
					a = in1.readLine();
				}
			}
			//in1.close();
			System.out.println("Dataset 2");
			max = new consumer_max(data2);
			System.out.println("the maximum rainfall is: ");
			max.start();
			//temp_max = max.getmax();
			sleep(1000);
			min = new consumer_min(data2);
			System.out.println("the minimum rainfall is: ");
			min.start();
			sleep(1000);
			//temp_min = min.getmin();
			
			avg = new consumer_avg(data2);
			System.out.println("the average rainfall is: ");
			avg.start();
			sleep(1000);
			//temp_avg = avg.getavg();
			
			
			double[] data3 = new double[100];
			for(int i=0;i<100;i++){
				b = Double.parseDouble(a);
				data3[i]=b;
				a = in1.readLine();
				if(i==99 || i==199 || i==299 || i==399){
					a = in1.readLine();
				}
			}
			//in1.close();
			System.out.println("Dataset 3");
			max = new consumer_max(data3);
			System.out.println("the maximum rainfall is: ");
			max.start();
			sleep(1000);
			//temp_max = max.getmax();
			
			min = new consumer_min(data3);
			System.out.println("the minimum rainfall is: ");
			min.start();
			sleep(1000);
			//temp_min = min.getmin();
			
			avg = new consumer_avg(data3);
			System.out.println("the average rainfall is: ");
			avg.start();
			sleep(1000);
			//temp_avg = avg.getavg();
			
			double[] data4 = new double[100];
			
			for(int i=0;i<100;i++){
				b = Double.parseDouble(a);
				data4[i]=b;
				a = in1.readLine();
				if(i==99 || i==199 || i==299 || i==399){
					a = in1.readLine();
				}
			}
			//in1.close();
			System.out.println("Dataset 4");
			max = new consumer_max(data4);
			System.out.println("the maximum rainfall is: ");
			max.start();
			sleep(1000);
			//temp_max = max.getmax();
			
			min = new consumer_min(data4);
			System.out.println("the minimum rainfall is: ");
			min.start();
			sleep(1000);
			//temp_min = min.getmin();
			
			avg = new consumer_avg(data4);
			System.out.println("the average rainfall is: ");
			avg.start();
			sleep(1000);
			//temp_avg = avg.getavg();
			
			
			double[] data5 = new double[100];
			for(int i=0;i<100;i++){
				b = Double.parseDouble(a);
				data5[i]=b;
				a = in1.readLine();
				if(i==99 || i==199 || i==299 || i==399){
					a = in1.readLine();
				}
			}
			in1.close();
			System.out.println("Dataset 5");
			max = new consumer_max(data5);
			System.out.println("the maximum rainfall is: ");
			max.start();
			sleep(1000);
			//temp_max = max.getmax();
			
			min = new consumer_min(data5);
			System.out.println("the minimum rainfall is: ");
			min.start();
			sleep(1000);
			//temp_min = min.getmin();
			
			avg = new consumer_avg(data5);
			System.out.println("the average rainfall is: ");
			avg.start();
			sleep(1000);
			//temp_avg = avg.getavg();
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
