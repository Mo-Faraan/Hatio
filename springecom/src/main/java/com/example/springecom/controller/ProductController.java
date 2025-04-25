package com.example.springecom.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springecom.model.Product;
import com.example.springecom.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getallproducts(){
        return new ResponseEntity<>(productService.getallproducts(), HttpStatus.OK);
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getproductbyid(@PathVariable("id") int id){
        Product product =  productService.getproductbyid(id);
        if (product != null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getimagebyid(@PathVariable int productId){
        Product product = productService.getproductbyid(productId);
        if (product != null)
            return new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }



    @PostMapping("/product")
    public ResponseEntity<?> addproduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product savedproduct;
        try {
            savedproduct = productService.addproduct(product,imageFile);
            return new ResponseEntity<>(savedproduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateproduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile){
    Product updatedproduct;
        try {
            updatedproduct = productService.updateproduct(product,imageFile);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteproduct(@PathVariable int id){
        Product product = productService.getproductbyid(id);
        if (product != null){
            productService.deleteproduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> products = productService.searchProducts(keyword);
        System.out.println("searching with :" + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // @GetMapping("/product/search/{keyword}/")
    // public List<JobPost> keywordsearch(@PathVariable("keyword") String keyword){
    //     return service.getjobsbykeyword(keyword);
    // }
}
