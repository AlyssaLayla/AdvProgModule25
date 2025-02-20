package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("ebb558egf-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("ebb558egf-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("aof9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEdit(){
        Product product = new Product();
        product.setProductId("ebb558egf-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product updatedProduct = new Product();
        updatedProduct.setProductName("Edited Version Sampo");
        updatedProduct.setProductQuantity(300);
        productRepository.edit(updatedProduct, product.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product editedProduct = productIterator.next();
        assertEquals(updatedProduct.getProductName(), editedProduct.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), editedProduct.getProductQuantity());
        assertEquals(product.getProductId(), editedProduct.getProductId());
    }

    @Test
    void testEditIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("aof9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Agus");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        Product updatedProduct = new Product();
        updatedProduct.setProductId(product1.getProductId());
        updatedProduct.setProductName("Sampo Cap Cecep");
        updatedProduct.setProductQuantity(150);

        productRepository.edit(updatedProduct, product1.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product editedProduct1 = productIterator.next();
        assertEquals(updatedProduct.getProductId(), editedProduct1.getProductId());
        assertEquals(updatedProduct.getProductName(), editedProduct1.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), editedProduct1.getProductQuantity());

        Product editedProduct2 = productIterator.next();
        assertEquals(product2.getProductId(), editedProduct2.getProductId());
        assertEquals(product2.getProductName(), editedProduct2.getProductName());
        assertEquals(product2.getProductQuantity(), editedProduct2.getProductQuantity());

        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditIfEmpty() {
        Product nonExistentProduct = new Product();
        nonExistentProduct.setProductId("1234-5678-9012");
        nonExistentProduct.setProductName("Sampo Cap Naga");
        nonExistentProduct.setProductQuantity(400);
        Product result= productRepository.edit(nonExistentProduct, nonExistentProduct.getProductId());
        assertNull(result);

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        productRepository.delete(product.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Agus");
        product2.setProductQuantity(250);
        productRepository.create(product2);

        productRepository.delete(product1.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteIfEmpty() {
        productRepository.delete("5678-9012-3456");
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testCreateWithoutProductId() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        Product savedProduct = productRepository.create(product);

        assertNotNull(savedProduct.getProductId(), "Product ID should be generated automatically if null");
        assertEquals("Sampo Cap Bambang", savedProduct.getProductName());
        assertEquals(100, savedProduct.getProductQuantity());
    }

    @Test
    void testFindByIdOfTwoProducts() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Cantika");
        product1.setProductQuantity(110);
        productRepository.create(product1);
        Product product2 = new Product();
        product2.setProductName("Sampo Cap Agus");
        product2.setProductQuantity(420);
        productRepository.create(product2);

        Product result = productRepository.findById(product2.getProductId());
        assertEquals(product2.getProductId(), result.getProductId());
    }
}