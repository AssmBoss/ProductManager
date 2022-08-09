import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Product Book1 = new Book(1, "AB-name", 11, "First", "A-book");
    Product Book2 = new Book(2, "BC-name", 22, "Second", "B-book");
    Product Book3 = new Book(3, "CD-name", 33, "Third", "C-book");
    Product Smart1 = new Smartphone(4, "DE-name", 44, "D-phone", "D-vendor");
    Product Smart2 = new Smartphone(5, "EF-name", 55, "E-phone", "E-vendor");
    Product Smart3 = new Smartphone(6, "FG-name", 66, "F-phone", "F-vendor");

    @Test
    public void shouldFillRepositoryInOrder() {
        ProductRepository testRepository = new ProductRepository();
        testRepository.save(Book1);
        testRepository.save(Book2);
        testRepository.save(Book3);

        ProductManager manager = new ProductManager(testRepository);
        manager.add(Smart1);
        manager.add(Smart2);
        manager.add(Smart3);

        Product[] expected = {Book1, Book2, Book3, Smart1, Smart2, Smart3};
        Product[] actual = testRepository.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository testRepository = new ProductRepository();
        testRepository.save(Book1);
        testRepository.save(Book2);
        testRepository.save(Book3);
        testRepository.save(Smart1);

        testRepository.removeById(2);

        Product[] expected = {Book1, Book3, Smart1};
        Product[] actual = testRepository.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextTwoProducts() {
        ProductRepository testRepository = new ProductRepository();
        ProductManager manager = new ProductManager(testRepository);
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Book3);
        manager.add(Smart1);
        manager.add(Smart2);
        manager.add(Smart3);

        Product[] expected = {Book3, Smart1};
        Product[] actual = manager.searchBy("D");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextOneProduct() {
        ProductRepository testRepository = new ProductRepository();
        ProductManager manager = new ProductManager(testRepository);
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Book3);
        manager.add(Smart1);
        manager.add(Smart2);
        manager.add(Smart3);

        Product[] expected = {Book2};
        Product[] actual = manager.searchBy("BC");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextNoProduct() {
        ProductRepository testRepository = new ProductRepository();
        ProductManager manager = new ProductManager(testRepository);
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Book3);
        manager.add(Smart1);
        manager.add(Smart2);
        manager.add(Smart3);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("ABC");
        Assertions.assertArrayEquals(expected, actual);
    }
}