import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AdvancedTest {
    import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class ConditionerTest {
        @Test
        public void shouldCreate() {
            Conditioner conditioner = new Conditioner();
        }

        @Test
        public void shouldInitFieldToZeroValues() {
            Conditioner conditioner = new Conditioner();
            assertNull(conditioner.name);
            assertEquals(0, conditioner.maxTemperature);
            assertEquals(0, conditioner.minTemperature);
            assertEquals(0, conditioner.currentTemperature);
            assertFalse(conditioner.on);
        }

        @Test
        @Disabled
        public void shouldThrowNPE() {
            Conditioner conditioner = new Conditioner();
            assertEquals(0, conditioner.name.length());
        }

        @Test
        public void shouldChangeFields() {
            Conditioner conditioner = new Conditioner();
            assertEquals(0, conditioner.currentTemperature);
            conditioner.currentTemperature = -100;
            assertEquals(-100, conditioner.currentTemperature);
        }
    }
    class ConditionerAdvancedTest {
        @Test
        public void shouldGetAndSet() {
            ConditionerAdvanced conditioner = new ConditionerAdvanced();
            String expected = "Кондишн";

            assertNull(conditioner.getName());
            conditioner.setName(expected);
            assertEquals(expected, conditioner.getName());
        }
    }
    class ConditionerTest {
        @Test
        public void shouldUseConstructor() {
            Conditioner conditioner = new Conditioner(
                    1,
                    "Winter Cold",
                    30,
                    10,
                    29,
                    true
            );
            assertEquals(29, conditioner.getCurrentTemperature());
        }

        @Test
        public void shouldUseNoArgsConstructor() {
            Conditioner conditioner = new Conditioner();
            assertEquals(22, conditioner.getCurrentTemperature());
        }
    }
    class ConditionerTest {
        @Test
        public void shouldInitFields() {
            Conditioner conditioner = new Conditioner();

            assertEquals("noname", conditioner.getName());
            assertEquals(30, conditioner.getMaxTemperature());
            assertEquals(15, conditioner.getMinTemperature());
            assertEquals(22, conditioner.getCurrentTemperature());
        }
    }
    import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;

    public class CartManagerTestNonEmpty {
        @Test
        public void shouldRemoveIfExists() {
            CartManager manager = new CartManager();
            int idToRemove = 1;
            PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
            PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
            PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
            manager.add(first);
            manager.add(second);
            manager.add(third);

            manager.removeById(idToRemove);

            PurchaseItem[] actual = manager.getAll();
            PurchaseItem[] expected = new PurchaseItem[]{third, second};

//    assertEquals(expected, actual);
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldNotRemoveIfNotExists() {
            CartManager manager = new CartManager();
            int idToRemove = 4;
            PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
            PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
            PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
            manager.add(first);
            manager.add(second);
            manager.add(third);

            manager.removeById(idToRemove);

            PurchaseItem[] actual = manager.getAll();
            PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

            assertArrayEquals(expected, actual);
        }
    }



}
