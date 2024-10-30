import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
public class BankAccount {
    private int balance=100;

  //  public synchronized void withdraw(int amount){ // ek baar main dono acces na kar le ishliye hm synchnized laga denge yaha
       public void withdraw(int amount){ // ish case main synchronized haat denge because we explicit lock
        // to jab t1 access karge ishko t2 acces nahi kar payega
        // jab tak t1 ishko khatam nahi kar lega ishko including this sleep  tb tak t2 nahi aayega
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw" + amount);
        if(balance>=amount){
            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
            try{
                Thread.sleep(3000);
                //ye chale hi ja rha hai time le rha hai t2 ko time hi nahi mil pa rha hai
                // thats why we use explicit lock
                // to oviously hm synchronized hata denge explicity kam karne ja rhe hai

            }catch (InterruptedException e){

            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName() + "completed withdrawnl,Remaining balance:"+balance);

        }else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
    }
}
 ye sab chij ko dekhete hm apna khud ka lock banayenge explicit lock
 via lock interface
 */
public class BankAccount{
    private int balance = 100;
    private final Lock lock  = new ReentrantLock();
    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + "attempting to withdraw" +amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance>=amount){
                    try {
                        System.out.println(Thread.currentThread().getName() + "proceeding with withdrawal");
                        Thread.sleep(3000);
                        balance-=amount;
                        System.out.println(Thread.currentThread().getName() + "completed withdrawal.Remaining balance: " + balance);
                    }catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally { // in finally we release the resources
                        lock.unlock();

                    }
                }else {

                }
            }else {
                System.out.println(Thread.currentThread().getName() + "could not acquire the lock will try later");


            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }

    }


}
