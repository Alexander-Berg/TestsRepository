import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AdvancedTest {
    public class CartManagerTestNonEmptyWithSetup {
        private CartManager manager = new CartManager();
        private PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
        private PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
        private PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);

        @BeforeEach
        public void setUp() {
            manager.add(first);
            manager.add(second);
            manager.add(third);
        }

        @Test
        public void shouldRemoveIfExists() {
            int idToRemove = 1;
            manager.removeById(idToRemove);

            PurchaseItem[] actual = manager.getAll();
            PurchaseItem[] expected = new PurchaseItem[]{third, second};

//    assertEquals(expected, actual);
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldNotRemoveIfNotExists() {
            int idToRemove = 4;

            manager.removeById(idToRemove);

            PurchaseItem[] actual = manager.getAll();
            PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

            assertArrayEquals(expected, actual);
        }

        class BookTest {
            @Test
            public void shouldHaveAllFieldsAndMethodFromSuperClass() {
                Book book = new Book();
//    book.
            }

            @Test
            public void shouldCastFromBaseClass() {
                Product product = new Book();
                if (product instanceof Book) {
                    Book book = (Book) product;
//      book.
                }
            }

            @Test
            public void shouldNotCastToDifferentClass() {
                Product product = new Book();
                TShirt shirt = (TShirt) product;
            }

            @Test
            public void shouldUseOverridedMethod() {
                Product product = new Book();
                // ???????????? ?? ??????????????????: ?????? ?????????? ???????????????????
                product.toString();
            }
        }

        class ProductTest {
            @Test
            public void shouldUseEquals() {
                Product first = new Product(1, "Java I", 1000);
                Product second = new Product(1, "Java I", 1000);
                assertEquals(first, second);
            }
        }
    }

    class ProductRepositoryTest {
        private ProductRepository repository = new ProductRepository();
        private Book coreJava = new Book();

        @Test
        public void shouldSaveOneItem() {
            repository.save(coreJava);

            Product[] expected = new Product[]{coreJava};
            Product[] actual = repository.findAll();
            assertArrayEquals(expected, actual);
        }
    }

    public class ServiceTest {
        private Service service = new Service();

        @Test
        public void shouldThrowCheckedException() {
            assertThrows(CheckedException.class, () -> service.throwChecked());
        }

        @Test
        public void shouldThrowUncheckedException() {
            assertThrows(UncheckedException.class, () -> service.throwUnchecked());
        }
    }

    class BoxTest {
        @Test
        public void shouldSaveAndReturnValue() {
            Product product = new Product();
            Box box = new Box(product);

            Object value = box.getValue();
            assertEquals(product, value);
        }
    }

    class GenericBoxTest {
        @Test
        public void shouldParametrizedWithProduct() {
            Product product = new Product();
            GenericBox<Product> productBox = new GenericBox<>(product);

            Product value = productBox.getValue();
            assertEquals(product, value);
        }

        @Test
        public void shouldParametrizedWithString() {
            String str = "Hello world";
            GenericBox<String> stringBox = new GenericBox<>(str);

            String value = stringBox.getValue();
            assertEquals(str, value);
        }
    }

    class ProductsTest {
        private Product first = new Product(1, "First", 1_000, 3.5);
        private Product second = new Product(2, "Second", 2_000, 4.5);
        private Product third = new Product(3, "Third", 3_000, 5.0);

        @Test
        public void shouldSortById() {
            Product[] expected = new Product[]{first, second, third};
            Product[] actual = new Product[]{third, first, second};

            Arrays.sort(actual);

            assertArrayEquals(expected, actual);
        }

        public class MathTest {
            @Test
            public void shouldCalculateSin() {
                double result = Math.sin(Math.PI / 2);
                double expected = 1.0;
                double delta = 0.01;
                Assertions.assertEquals(expected, result, delta);
            }
        }
    }
    public class CRUDRepositoryTest {
        @Nested
        public class Empty {
        }

        @Nested
        public class SingleItem {
        }

        @Nested
        public class MultipleItems {
        }
    }
    class ProductRepositoryTestWithListOf {
        private ProductRepository repository = new ProductRepository();

        @Test
        void shouldAddProduct() {
            repository.add(new Product());
        }

        @Test
        void shouldAddMultipleProducts() {
            Collection<Product> products = new ArrayList<>();
            products.add(new Product());
            products.add(new Product());
            repository.addAll(products);

            repository.addAll(List.of(new Product(), new Product()));
        }

        @Test
        void shouldAddBook() {
            repository.add(new Book());
        }

        @Test
        void shouldAddMultipleBooks() {
            boolean removed = repository.addAll(List.of(new Product(), new Product()));
        }
    }
    class ProductRepositoryTest {
        private ProductRepository repository = new ProductRepository();

        @Test
        void shouldAddProduct() {
            repository.add(new Product());
        }

        @Test
        void shouldAddMultipleProducts() {
            Collection<Product> products = new ArrayList<>();
            products.add(new Product());
            products.add(new Product());

            repository.addAll(products);
        }

        @Test
        void shouldAddBook() {
            repository.add(new Book());
        }

        @Test
        void shouldAddMultipleBooks() {
            Collection<Book> books = new ArrayList<>();
            books.add(new Book());
            books.add(new Book());

            boolean removed = repository.addAll(books);
        }
    }

}

