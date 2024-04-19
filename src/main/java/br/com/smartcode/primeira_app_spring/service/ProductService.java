package br.com.smartcode.primeira_app_spring.service;

import br.com.smartcode.primeira_app_spring.model.Product;
import br.com.smartcode.primeira_app_spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.getAll();
    }

    public Optional<Product> getProductById(int id) {
        return this.productRepository.getById(id);
    }

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    public void deleteProduct(int id) {
        this.productRepository.delete(id);
    }

    public Product updateProduct(Integer id, Product product) {
        return this.productRepository.update(id, product);
    }
}
