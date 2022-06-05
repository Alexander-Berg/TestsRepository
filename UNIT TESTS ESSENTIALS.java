
//SIMPLE EXAMPLE
package test.main;

import org.junit.*;
import main.java.MySimpleMath;

public class MySimpleMathTest {
    
    @Test
    public void testCheckSignShouldReturnPositive() {
        MySimpleMath sm = new MySimpleMath();
        Assert.assertEquals("positive", sm.checkSign(5));
        Assert.assertEquals("positive", sm.checkSign(0));
    }
    
    @Test
    public void testCheckSignShouldReturnNegative() {
        MySimpleMath sm = new MySimpleMath();
        Assert.assertEquals("negative", sm.checkSign(-5));
    }
    
}

//ALL ASSSERTIONS

assertTrue(“message”,boolean condition)
assertFalse(…)
assertEquals(“message”, expected, actual, tolerance)
assertNotEquals(unexpected, actual);
assertNull(“message”, object)
assertNotNull(…)
assertSame(“message”, expected, actual)
assertNotSame(…)
assertArrayEquals(…)
assertArrayNotEquals(…)
fail()

//TESTING EXEPTIONS

package main.java;

public class MySimpleMath {
    
    /**
     * A simple method that takes and input and returns
     * "positive" or "negative" depending on the input number 
     */
    public String checkSign(int number) {
        if(number >= 0 ) {
            return "positive";
        } else {
            return "negative";
        }
    }

    /**
     * Returns the division of numerator by the denominator.
     * If the denominator is zero, it throws an Exception
     */
    public double divide(int num, int denom) {
        if(denom == 0) { 
            throw new ArithmeticException("Cannot divide by zero");
        } else {
            return num/(double)denom;
        }
        
    }
    
}

//TESTING EXEPTIONS 2

package test.main;

import org.junit.*;
import main.java.MySimpleMath;

public class MySimpleMathTest {
    
    @Test
    public void testCheckSignShouldReturnPositive() {
        MySimpleMath sm = new MySimpleMath();
        Assert.assertEquals("positive", sm.checkSign(5));
        Assert.assertEquals("positive", sm.checkSign(0));
    }
    
    @Test
    public void testCheckSignShouldReturnNegative() {
        MySimpleMath sm = new MySimpleMath();
        Assert.assertEquals("negative", sm.checkSign(-5));
    }
    
    @Test
    public void testDivisionShouldReturnPositiveQuotient() {
        MySimpleMath sm = new MySimpleMath();
        Assert.assertEquals(2.0, sm.divide(10, 5), 0);
        Assert.assertEquals(0.0, sm.divide(0, 5), 0);
    }
    
    @Test
    public void testDivisionShouldReturnNegativeQuotient() {
        MySimpleMath sm = new MySimpleMath();
        Assert.assertEquals(-2.0, sm.divide(10, -5), 0);
    }
    
    @Test (expected = ArithmeticException.class)
    public void testDivisionShouldThrowArithmeticException() {
        MySimpleMath sm = new MySimpleMath();
        sm.divide(10, 0);
    }
    
}

/*TESTING ARRAYS

Assume that we have a class that offers only two functionalities on an array, the findMin(int[] array) and the multiply(int[] array, int factor) where the first finds the min in an array, and the second multiplies each element of the array with a factor respectivelly
package main.java;
*/
public class MySimpleArrayOperations {
    
    public int findMin(int[] array) {
        if(!(array.length > 0)) {
            throw new IllegalArgumentException("Input array is empty");
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++) {
            if(array[i] <= min)
                min = array[i];
        }
        
        return min;
    }
    
    public void multiply(int[] array, int factor) {
        if(!(array.length > 0)) {
            throw new IllegalArgumentException("Input array is empty");
        }
        
        for( int i=0; i<array.length; i++ ) {
            array[i] = array[i] * factor;
        }
    }

}

/*TESTING ARRAYS (2)
For comparing the equality of arrays we use the assertArrayEquals(...) method provided by the JUnit library
The test class should have the following code

*/
package test.main;

import org.junit.*;
import static org.junit.Assert.*;

import main.java.MySimpleArrayOperations;

public class MySimpleArrayOperationsTest {
    
    @Test
    public void testFindMin() {
        MySimpleArrayOperations msao = new MySimpleArrayOperations();
        int[] array = {10, 2, 3, 10, 1, 0, 2, 3, 16, 0, 2};
        assertEquals(0, msao.findMin(array));
        assertNotEquals(10, msao.findMin(array));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testFindMinShouldThrowException() {
        MySimpleArrayOperations msao = new MySimpleArrayOperations();
        msao.findMin(new int[]{});
    }
    
    @Test
    public void testMultiply() {
        MySimpleArrayOperations msao = new MySimpleArrayOperations();
        int[] array = {10, 2, 3, 10, 1, 0, 2, 3, 16, 0, 2};
        msao.multiply(array, 10);
        assertArrayEquals(new int[]{100, 20, 30, 100, 10, 0, 20, 30, 160, 0, 20}, array);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMultiplyShouldThrowException() {
        MySimpleArrayOperations msao = new MySimpleArrayOperations();
        msao.multiply(new int[]{}, 0); //method call with dummy arguments
    }
    
}

/* Testing Arrays (2)
For comparing the equality of arrays we use the assertArrayEquals(...) method provided by the JUnit library
The test class should have the following code
/* */
package test.main;

import org.junit.*;
import static org.junit.Assert.*;

import main.java.MySimpleArrayOperations;

public class MySimpleArrayOperationsTest {
    
    @Test
    public void testFindMin() {
        MySimpleArrayOperations msao = new MySimpleArrayOperations();
        int[] array = {10, 2, 3, 10, 1, 0, 2, 3, 16, 0, 2};
        assertEquals(0, msao.findMin(array));
        assertNotEquals(10, msao.findMin(array));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testFindMinShouldThrowException() {
        MySimpleArrayOperations msao = new MySimpleArrayOperations();
        msao.findMin(new int[]{});
    }
    
    @Test
    public void testMultiply() {
        MySimpleArrayOperations msao = new MySimpleArrayOperations();
        int[] array = {10, 2, 3, 10, 1, 0, 2, 3, 16, 0, 2};
        msao.multiply(array, 10);
        assertArrayEquals(new int[]{100, 20, 30, 100, 10, 0, 20, 30, 160, 0, 20}, array);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMultiplyShouldThrowException() {
        MySimpleArrayOperations msao = new MySimpleArrayOperations();
        msao.multiply(new int[]{}, 0); //method call with dummy arguments
    }
    
}

/*SIMPLIFY TEST CASES (2)
*/
package test.main;

import org.junit.*;
import static org.junit.Assert.*;

import main.java.MySimpleArrayOperations;

public class MySimpleArrayOperationsTest {
    private MySimpleArrayOperations msao = new MySimpleArrayOperations();
    private int[] array;
    
    @Before
    public void initInstanceVariables() {
        System.out.println(this.getClass().getName() + " --> initializing fields");
        this.msao = new MySimpleArrayOperations();
        this.array = new int[] {10, 2, 3, 10, 1, 0, 2, 3, 16, 0, 2};
    }
    
    @Test
    public void testFindMin() {
        assertEquals(0, msao.findMin(array));
        assertNotEquals(10, msao.findMin(array));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testFindMinShouldThrowException() {
        msao.findMin(new int[]{});
    }
    
    @Test
    public void testMultiply() {
        msao.multiply(array, 10);
        assertArrayEquals(new int[]{100, 20, 30, 100, 10, 0, 20, 30, 160, 0, 20}, array);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMultiplyShouldThrowException() {
        msao.multiply(new int[]{}, 0); //method call with dummy arguments
    }
    
}

/*TEST SUITES
Suites allow grouping of Test classes. They are empty classes, annotated with the @RunWith and the @Suite.SuiteClasses annotations
When the suite class run all the tests in the included classes will also run
*/
package test.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MyMathTest.class, MyMathSimpleTest.class })

public class MathTestSuite {
    /* the class remains empty, used only as a holder for  
     * the above annotations
     */
}

/*EXECUTING MULTIPLE TESTS
The JUnitCore.runClasses allows the execution of multiple Test classes and suites.
The results are stored in a Result object as defined by the JUnit framework.
We can execute the JUnitCore in (for example) main method like the following:
*/
package test.java;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(MathTestSuite.class, 
              MyArrayOperationsTest.class);
        
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
        
      System.out.println(result.wasSuccessful());
   }
} 

