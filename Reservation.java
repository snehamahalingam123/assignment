public class Reservation{ 
public static void main(String[] args) {
        Thread t=Thread.currentThread();
        t.setName("Shavani");
        System.out.println("Reservation counter starting working..."+t.getName());
        
        ReservationCounter central=new ReservationCounter();
        
        Thread sneha=new Thread(new BookingJob(central,1000),"sneha");
        Thread srinetha=new Thread(new BookingJob(central,500),"srinetha");
        
        sneha.start();
        srinetha.start();
        
}

}

class BookingJob implements Runnable{
    ReservationCounter central;int amt;
    public BookingJob(ReservationCounter central,int amt) {
        this.central=central;
        this.amt=amt;
    }
    @Override
    public void run() {
        central.bookTicket(amt);
        central.giveChange();
    }
}

class ReservationCounter{
    int amt;
    public void bookTicket(int amt) {
        Thread t=Thread.currentThread();
        this.amt=amt;
        String name=t.getName();
        System.out.println(name+" has come to book the ticket...");
        System.out.println(name+" brought...:"+amt);
    }
    
    public void giveChange() {
        Thread t=Thread.currentThread();
        String name=t.getName();
        System.out.println("Change given to...:"+name);
        System.out.println(name+" takes...:"+(amt-100));
    }

Runnable r=()->
{
System.out.println("reservation done successfully...");
};
new Thread (r).start();

}

