public class LambdaExpressionExample {
    public static void main(String[] args) {
        /*
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        But this all can be replace with lambda
        same thing short the code
         */
//        Runnable runnable = () -> System.out.println("Hello");
//        Thread t1 = new Thread(runnable);
        Thread t1 = new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println("Hello world");
            }
        });
        t1.start();
    }
}
