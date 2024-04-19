package br.com.smartcode.primeira_app_spring.repository;

import br.com.smartcode.primeira_app_spring.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final ArrayList<Product> products = new ArrayList<>();
    private Integer lastId = 0;

    /**
     * Retorna todos os produtos adicionados
     * @return List of Products
     */
    public List<Product> getAll() {
        return this.products;
    }

    /**
     * Retorna o produto buscando pelo id
     * @return product if found
     */
    public Optional<Product> getById(Integer id) {
        return this.products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    /**
     * Cadastra um novo produto
     * @param product Product
     * @return new product
     */
    public Product save(Product product) {
        product.setId(++lastId);
        this.products.add(product);

        return product;
    }

    /**
     * Remove um produto pelo seu id
     * @param id Integer
     */
    public void delete(Integer id) {
        this.products.removeIf(product -> product.getId().equals(id));
    }

    public Product update(Integer id, Product product) {
        var productFound = this.getById(id);
        if (productFound.isEmpty()) {
            throw new InputMismatchException("Product not found");
        }

        var newProduct = product;
        newProduct.setId(id);
        this.delete(product.getId());
        this.products.add(newProduct);
        return newProduct;
    }
}
