package integrationtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Integration1IT {
    @Test
    public void integrationTest1() {
        System.out.println("++++++++++ This is sample integration test - 1 ++++++++++");
        Assert.assertEquals(true, true);
    }
}