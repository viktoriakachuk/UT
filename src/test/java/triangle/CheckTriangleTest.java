package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckTriangleTest {
    private Triangle triangle;

    @DataProvider
    public Object[][] triangleParam(){
        return new Object[][]{
                {1.0, 1.0, 4.0},
                {1.0, 4.0, 1.0},
                {4.0, 1.0, 1.0},
                {2.0, 2.0, 4.0},
                {2.0, 4.0, 2.0},
                {4.0, 2.0, 2.0},
        };
    }

    @Test(dataProvider = "triangleParam")
    public void checkTriangleInequalityNegativeTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertFalse(triangle.checkTriangle());
    }

    @Test
    public void checkTriangleZeroANegativeTest(){
        triangle = new Triangle(0.0, 4.0, 6.0);
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), "a<=0");
        Assert.assertFalse(triangle.checkTriangle());
    }
    @Test
    public void checkTriangleZeroBNegativeTest(){
        triangle = new Triangle(4.0, 0.0, 6.0);
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), "b<=0");
        Assert.assertFalse(triangle.checkTriangle());
    }
    @Test
    public void checkTriangleZeroCNegativeTest(){
        triangle = new Triangle(4.0, 6.0, 0.0);
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), "c<=0");
        Assert.assertFalse(triangle.checkTriangle());
    }
    @Test
    public void checkTrianglePositiveTest(){
        triangle = new Triangle(4.0, 6.0, 8.0);
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), "");
        Assert.assertTrue(triangle.checkTriangle());
    }

}
