import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Stubs {

    @Test
    public void testAddition() {
        // Create a stub for the CalculatorService interface
        CalculatorService calculatorService = mock(CalculatorService.class);

        // Create an instance of the Calculator class and inject the stub
        Calculator calculator = new Calculator(calculatorService);

        // Define the behavior of the stub
        when(calculatorService.add(2, 3)).thenReturn(5);

        // Perform the operation
        int result = calculator.add(2, 3);

        // Verify the result
        assertEquals(5, result);

        // Verify that the add method of the calculatorService was called with the correct arguments
        verify(calculatorService).add(2, 3);
    }
}

// Calculator interface
public interface CalculatorService {
    int add(int a, int b);
}

// Calculator class
public class Calculator {
    private CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int add(int a, int b) {
        return calculatorService.add(a, b);
    }
}
//* In this example, we have a Calculator class that depends on a CalculatorService interface.
// The CalculatorService interface represents an external service that performs addition operations.
// In the unit test, we create a stub for the CalculatorService interface using Mockito's mock() method.
// We then define the behavior of the stub using when().thenReturn() to specify that when the add() method
// is called with arguments 2 and 3, it should return 5.
//
//Next, we instantiate the Calculator class and inject the stubbed CalculatorService instance.
// We call the add() method on the Calculator instance and assert that the result is equal to the expected
// value of 5 using assertEquals().
// We also use verify() to ensure that the add() method of the CalculatorService was called with the correct arguments.
//
//By using stubs, we can isolate the unit under test and provide controlled behavior for its dependencies,
// allowing us to test its functionality in isolation.
