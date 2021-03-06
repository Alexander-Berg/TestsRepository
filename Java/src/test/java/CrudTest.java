import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CrudTest {
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

