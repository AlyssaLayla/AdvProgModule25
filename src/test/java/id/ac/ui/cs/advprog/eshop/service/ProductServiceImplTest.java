package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product();
        product1.setProductId("ebb558egf-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sabun Mandi Alex");
        product1.setProductQuantity(100);

        product2 = new Product();
        product2.setProductId("aof9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sabun Mandi Jesicca");
        product2.setProductQuantity(50);
    }

    @Test
    void testCreate() {
        when(productRepository.create(product1)).thenReturn(product1);

        Product createdProduct = productService.create(product1);

        assertNotNull(createdProduct);
        assertEquals(product1.getProductId(), createdProduct.getProductId());
        assertEquals(product1.getProductName(), createdProduct.getProductName());
        assertEquals(product1.getProductQuantity(), createdProduct.getProductQuantity());

        verify(productRepository, times(1)).create(product1);
    }

    @Test
    void testFindAll() {
        Iterator<Product> iterator = Arrays.asList(product1, product2).iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> productList = productService.findAll();

        assertNotNull(productList);
        assertEquals(2, productList.size());
        assertEquals(product1.getProductId(), productList.get(0).getProductId());
        assertEquals(product2.getProductId(), productList.get(1).getProductId());

        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testDelete() {
        doNothing().when(productRepository).delete(product1.getProductId());

        productService.delete(product1.getProductId());

        verify(productRepository, times(1)).delete(product1.getProductId());
    }

    @Test
    void testFindById() {
        when(productRepository.findById(product1.getProductId())).thenReturn(product1);

        Product foundProduct = productService.findById(product1.getProductId());

        assertNotNull(foundProduct);
        assertEquals(product1.getProductId(), foundProduct.getProductId());

        verify(productRepository, times(1)).findById(product1.getProductId());
    }

    @Test
    void testEdit() {
        when(productRepository.edit(product1, product1.getProductId())).thenReturn(product1);

        Product editedProduct = productService.edit(product1, product1.getProductId());

        assertNotNull(editedProduct);
        assertEquals(product1.getProductId(), editedProduct.getProductId());
        assertEquals(product1.getProductName(), editedProduct.getProductName());

        verify(productRepository, times(1)).edit(product1, product1.getProductId());
    }
}
