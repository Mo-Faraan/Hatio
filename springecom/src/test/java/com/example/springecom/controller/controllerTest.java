package com.example.springecom.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import com.example.springecom.model.Product;
import com.example.springecom.service.ProductService;


@WebMvcTest(ProductController.class)
class controllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setup() {
        product = new Product(1, "Test Product", "Test Description", "Test Brand",
                BigDecimal.valueOf(100.00), "Test Category", new Date(), true, 10, null, null, null);
    }

    @Test
    void testGetAllProducts() throws Exception {
        when(productService.getallproducts()).thenReturn(List.of(product));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    void testGetProductByIdFound() throws Exception {
        when(productService.getproductbyid(1)).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/product/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Product"));
    }

    @Test
    void testGetProductByIdNotFound() throws Exception {
        when(productService.getproductbyid(1)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/product/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testAddProduct() throws Exception {
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "data".getBytes());
        MockMultipartFile productPart = new MockMultipartFile("product", "", "application/json",
                "{\"name\":\"Test Product\"}".getBytes());

        when(productService.addproduct(any(Product.class), any(MultipartFile.class))).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/product")
                        .file(productPart)
                        .file(imageFile))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateProduct() throws Exception {
        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", "data".getBytes());
        MockMultipartFile productPart = new MockMultipartFile("product", "", "application/json",
                "{\"name\":\"Updated Product\"}".getBytes());

        when(productService.updateproduct(any(Product.class), any(MultipartFile.class))).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/product/1")
                        .file(productPart)
                        .file(imageFile)
                        .with(request -> {
                            request.setMethod("PUT");
                            return request;
                        }))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteProductFound() throws Exception {
        when(productService.getproductbyid(1)).thenReturn(product);
        doNothing().when(productService).deleteproduct(1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/product/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteProductNotFound() throws Exception {
        when(productService.getproductbyid(1)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/product/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testSearchProducts() throws Exception {
        when(productService.searchProducts("test")).thenReturn(List.of(product));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/product/search")
                        .param("keyword", "test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }
}
