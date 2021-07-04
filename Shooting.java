
public class Shooting {
	public static void main(String[] args) {
		
        Canon bofors=new Canon();
        ShootingTask st=new ShootingTask(bofors);
        Thread shavani=new Thread(st,"shavani");
        Thread sam=new Thread(st,"sam");
        
        shavani.start();
        sam.start();
      
        
       
      
}
}

class ShootingTask implements Runnable{
    Canon gun;
    public ShootingTask(Canon gun) {
        this.gun=gun;
    }
    @Override
    public void run() {
        Thread t=Thread.currentThread();
        if(t.getName().equals("shavani")) {
            for(int i=0;i<5;i++) {
                gun.fill();
            };
        }
        else if(t.getName().equals("sam")) {
            for(int i=0;i<5;i++) {
                gun.shoot();
            }
        }
    }
}
class Canon{
    boolean flag;
    synchronized public void fill() {
        Thread t=Thread.currentThread();
        String name=t.getName();
        if(flag) {
            try{wait();}catch(Exception e) {}
        }
        System.out.println(name+" fills the gun.......");
        flag=true;
        notify();
    }
	 synchronized public void shoot() {
		 Thread t=Thread.currentThread();
		 String name=t.getName();
		 if(!flag) {
			 try {
				 wait();
			 }
			 catch(Exception e) {
			 }
			 System.out.println(name+"shoot..");
			 flag=false;
			 notify();
			 new  Thread(()->System.out.println("the gun is ready to shoot..")).start();
			 }
			 }
		 }
		


