import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    class BonusServiceTest {

        @org.junit.jupiter.api.Test
        void shouldCalculateForRegisteredAndUnderLimit() {
            BonusService service = new BonusService();

            // подготавливаем данные:
            long amount = 1000_60;
            boolean registered = true;
            long expected = 30;

            // вызываем целевой метод:
            long actual = service.calculate(amount, registered);

            // производим проверку (сравниваем ожидаемый и фактический):
            assertEquals(expected, actual);
        }

        @org.junit.jupiter.api.Test
        void shouldCalculateForRegisteredAndOverLimit() {
            BonusService service = new BonusService();

            // подготавливаем данные:
            long amount = 1_000_000_60;
            boolean registered = true;
            long expected = 500;

            // вызываем целевой метод:
            long actual = service.calculate(amount, registered);

            // производим проверку (сравниваем ожидаемый и фактический):
            assertEquals(expected, actual);
        }
    }


import static org.junit.jupiter.api.Assertions.assertEquals;

    class BonusServiceTest {
        @ParameterizedTest
        @CsvSource(
                value={
                        "'registered user, bonus under limit',100060,true,30",
                        "'registered user, bonus over limit',100000060,true,500"
                }
        )
        void shouldCalculate(String test, long amount, boolean registered, long expected) {
            BonusService service = new BonusService();

            // вызываем целевой метод:
            long actual = service.calculate(amount, registered);

            // производим проверку (сравниваем ожидаемый и фактический):
            assertEquals(expected, actual);
        }
    }
    lass StatisticsServiceTest {
        @Test
        void calculateSum() {
            StatisticsService service = new StatisticsService();

            long[] purchases = {1_000, 2_000, 500, 5_000, 2_000};
            long expected = 10_500;

            long actual = service.calculateSum(purchases);

            assertEquals(expected, actual);
        }

        @Test
        void findMax() {
            StatisticsService service = new StatisticsService();

            long[] purchases = {1_000, 2_000, 500, 5_000, 2_000};
            long expected = 5_000;

            long actual = service.findMax(purchases);

            assertEquals(expected, actual);
        }
    }
    class StatisticsServiceTest {
        @Test
        void calculateSum() {
            StatisticsService service = new StatisticsService();

            long[] purchases = {1_000, 2_000, 500, 5_000, 2_000};
            long expected = 10_500;

            long actual = service.calculateSum(purchases);

            assertEquals(expected, actual);
        }

        @Test
        void findMax() {
            StatisticsService service = new StatisticsService();

            long[] purchases = {1_000, 2_000, 500, 5_000, 2_000};
            long expected = 5_000;

            long actual = service.findMax(purchases);

            assertEquals(expected, actual);
        }
    }
    class StatisticsServiceTest {

        @Test
        void findMax() {
            StatisticsService service = new StatisticsService();

            long[] incomesInBillions = {12, 5, 8, 4, 5, 3, 8, 6, 11, 11, 12};
            long expected = 12;

            long actual = service.findMax(incomesInBillions);

            assertEquals(expected, actual);
        }
    }

}
