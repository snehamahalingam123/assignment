
public class LambdaExpression {

	public static void main(String[] args) {
		Thread t= new Thread(new Job());
		
	

		Runnable r1=new Runnable(){
			public void run() {
				System.out.println("Thread1 is Running...");
			}
			
		};
		Thread t1= new Thread(r1);
		t1.start();
		
		Runnable r2=()->{
			System.out.println("Thread2 is Running...");
			
		};
		Thread t3= new Thread(r2);
		t3.start();
		

	}

}
class Job implements Runnable{
	@Override
	public void run() {
		System.out.println("thread execution logic...");
	}
	
	
}
