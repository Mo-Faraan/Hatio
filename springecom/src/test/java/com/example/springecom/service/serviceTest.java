package com.example.springecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import com.example.springecom.model.Product;
import com.example.springecom.repo.ProductRepo;

@ExtendWith(MockitoExtension.class)
public class serviceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepo repo;

    private Product product;

    @BeforeEach
    void setup(){
        product = new Product(1, "Test Product", "Test Description", "Test Brand", BigDecimal.valueOf(100.00), "Test Category", new Date(), true, 10, null, null, null);
    }

    @Test
    void testGetAllProducts(){
        
  
        when(repo.findAll()).thenReturn(List.of(product));

        List<Product> response = service.getallproducts();
        assertEquals(1,response.size());
    }

    @Test
    void testGetProductById() {
        when(repo.findById(1)).thenReturn(Optional.of(product));
        Product found = service.getproductbyid(1);
        assertNotNull(found);
        assertEquals("Test Product", found.getName());
    }
    
    
    @Test
    void testAddProduct() throws IOException {
        MockMultipartFile file = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "data".getBytes());
        when(repo.save(any(Product.class))).thenReturn(product);
        Product saved = service.addproduct(product, file);
        assertNotNull(saved);
        assertEquals("test.jpg", saved.getImageName());
    }

    @Test
    void testUpdateProduct() throws IOException {
        MockMultipartFile file = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "data".getBytes());
        when(repo.save(any(Product.class))).thenReturn(product);
        Product updated = service.updateproduct(product, file);
        assertNotNull(updated);
        assertEquals("test.jpg", updated.getImageName());
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(repo).deleteById(1);
        service.deleteproduct(1);
        verify(repo, times(1)).deleteById(1);
    }

    @Test
    void testSearchProducts() {
        when(repo.searchProducts("test")).thenReturn(List.of(product));
        List<Product> result = service.searchProducts("test");
        assertEquals(1, result.size());
        assertEquals("Test Product", result.get(0).getName());
    }
}

