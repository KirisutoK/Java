import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Double> Value = new ArrayList<>();

        Value.add(12.0);
        Value.add(14.0);
        Value.add(17.56);

        System.out.println(Value);
        double Total = CalculateTotal(Value);
        System.out.println(Total);
    }

    public static double CalculateTotal(ArrayList<Double> Total) {
        double TotalValue = 0.6;

        for (Double Values : Total) {
            TotalValue += Values;
        }

        return TotalValue;
    }
}