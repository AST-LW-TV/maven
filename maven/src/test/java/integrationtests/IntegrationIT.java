package integrationtests;

import mathoperations.Addition;
import mathoperations.Formula;
import mathoperations.Subtraction;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// integration test to check the functioning of multiple modules
public class IntegrationIT {
    private int valueFromAdditionClass;
    private int valueFromSubtractionClass;
    private int valueOfAdditionFromFormula;
    private int valueOfSubtractionFromFormula;
    private int result;

    @BeforeClass
    public void setUp() {
        System.out.println("Integration Test started");
        int operand1 = 5;
        int operand2 = 3;
        valueFromAdditionClass = Addition.addition(operand1, operand2);
        valueFromSubtractionClass = Subtraction.subtraction(operand1, operand2);
        result = Formula.calculation(operand1, operand2);
        valueOfAdditionFromFormula = Formula.getAdditionValue();
        valueOfSubtractionFromFormula = Formula.getDifference();
    }

    @Test
    public void integrationTest1() {
        System.out.println("++++++++++ This is sample integration test - 1 ++++++++++");
        Assert.assertEquals(valueFromAdditionClass, valueOfAdditionFromFormula);
    }

    @Test
    public void integrationTest2() {
        System.out.println("++++++++++ This is sample integration test - 2 ++++++++++");
        Assert.assertEquals(valueFromSubtractionClass, valueOfSubtractionFromFormula);
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Integration Test Ended");
    }
}
