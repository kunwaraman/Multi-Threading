package eg.lambda;

public class EngineeringStudent implements Student {

    @Override
    public String getBio(String name) {
        return name + " is Engineering student";
    }
}

