package mathoperations;

public class Formula {
    private static int sum;
    private static int difference;

    public static int calculation(int operand1, int operand2) {
        sum = Addition.addition(operand1, operand2);
        difference = Subtraction.subtraction(operand1, operand2);
        int formula = sum * difference;
        return formula;
    }

    public static int getAdditionValue() {
        return sum;
    }

    public static int getDifference() {
        return difference;
    }
}
