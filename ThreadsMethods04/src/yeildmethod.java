public class yeildmethod extends Thread {

    public yeildmethod(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+ "is running");
             Thread.yield(); // dono threads ko chance mil raha hai dushre ko bhi mauka dena hai
            // ish case main t1 aur t2 dono ko chnace mil raha hai
        }

    }

    public static void main(String[] args) {
        yeildmethod y1 = new yeildmethod("t1");
        yeildmethod y2 = new yeildmethod("y2");
        y1.start();
        y2.start();

    }
}
