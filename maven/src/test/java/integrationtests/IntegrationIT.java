package integrationtests;

import mathoperations.Addition;
import mathoperations.Formula;
import mathoperations.Subtraction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Integration2IT {
    @Test
    public void integrationTest2() {
        int operand1 = 5;
        int operand2 = 3;
        int valueFromAdditionClass = Addition.addition(operand1, operand2);
        int valueFromSubtractionClass = Subtraction.subtraction(operand1, operand2);

        int result = Formula.calculation(operand1, operand2);
        int valueOfAdditionFromFormula = Formula.getAdditionValue();
        int valueOfSubtractionFromFormula = Formula.getDifference();

        System.out.println("++++++++++ This is sample integration test - 2 ++++++++++");
        Assert.assertEquals(valueFromAdditionClass, valueOfAdditionFromFormula);
        Assert.assertEquals(valueFromSubtractionClass, valueOfSubtractionFromFormula);
    }
}
