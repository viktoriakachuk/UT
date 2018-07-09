package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DetectTriangleTest {
    final int TR_EQUILATERAL = 1; // равносторонний
    final int TR_ISOSCELES = 2;   // равнобедренный
    final int TR_ORDINARY = 4;    // обычный
    final int TR_RECTANGULAR = 8; // прямоугольный
    final int TR_ISOSCELES_EQUILATERAL = 3;   // равнобедренный + равносторонний
    final int TR_ISOSCELES_RECTANGULAR = 10;   // равнобедренный + прямоугольный

    private Triangle triangle;

    @DataProvider
    public Object[][] rectangularParam(){
        return new Object[][]{
                {3.0, 4.0, 5.0},
                {4.0, 5.0, 3.0},
                {5.0, 3.0, 4.0},
        };
    }
    @DataProvider
    public Object[][] isoscelesParam(){
        return new Object[][]{
                {4.0, 4.0, 5.0},
                {5.0, 4.0, 4.0},
                {4.0, 4.0, 5.0},
        };
    }
    @DataProvider
    public Object[][] isoscelesRectangularParam(){
        return new Object[][]{
                {1.0, 1.0, Math.sqrt(2)},
                {Math.sqrt(2), 1.0, 1.0},
                {1.0, 1.0, Math.sqrt(2)},
        };
    }

    @Test(dataProvider = "rectangularParam")
    public void detectRectangularTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), TR_RECTANGULAR);
    }

    @Test(dataProvider = "isoscelesParam")
    public void detectIsoscelesTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), TR_ISOSCELES);
    }

    @Test(dataProvider = "isoscelesRectangularParam", groups = {"combination"})
    public void detectIsoscelesRectangularTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), TR_ISOSCELES_RECTANGULAR);
    }

    @Test(groups = {"combination"})
    public void detectEquilateralTest(){
        triangle = new Triangle(2.0,2.0,2.0);
        Assert.assertEquals(triangle.detectTriangle(), TR_ISOSCELES_EQUILATERAL);
    }

    @Test
    public void detectOrdinaryTest(){
        triangle = new Triangle(6.0,3.0,5.0);
        Assert.assertEquals(triangle.detectTriangle(), TR_ORDINARY);
    }

    @Test
    public void detectTriangleNegativeTest(){
        triangle = new Triangle(-20.0,4.0,6.0);
        Assert.assertEquals(triangle.detectTriangle(), "can't detect false triangle",
                "need to checkTriangle() first, if true -- detect triangle");
    }


}
