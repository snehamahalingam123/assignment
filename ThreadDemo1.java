
public class ThreadDemo1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override 
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("class starts"+i);
					
					
				}
				
				
			}
			
			
		});
		Runnable t2=()->{
			System.out.println("class started");
			
			
		};
		t1.start();
		new Thread (t2).start();
		
		t1.setPriority(10);
		
		
		

	}

}
