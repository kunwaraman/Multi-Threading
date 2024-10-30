package eg.lambda;

public class SolutionOfthis {
    public static void main(String[] args) {
        Student engineeringStudent = new Student() {
            @Override
            public String getBio(String name) {
                return name +" is Engineering student";
            }
        };
        Student lawStudent = (String name)->{
            return name + " is Engineering Student";
        };

        String bio = engineeringStudent.getBio("Ram");
        System.out.println(bio);
        /*
        aab hame ye pata hai ki student ek aisha interface
        hai jishme ek hi abstract method hai to jo humne method likha hai na ishko convert kar sakte hai into lambda expression main ye get bio wala ko jo override hai

        aab same hum law student ke exmaple main dekh elambda ko ushe karke
         */
    }
}
