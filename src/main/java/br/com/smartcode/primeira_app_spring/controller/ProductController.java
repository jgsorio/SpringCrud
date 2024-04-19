package br.com.smartcode.primeira_app_spring.controller;

import br.com.smartcode.primeira_app_spring.model.Product;
import br.com.smartcode.primeira_app_spring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return this.productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return this.productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        this.productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return this.productService.updateProduct(id, product);
    }
}
