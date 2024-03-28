package ma.tp.tp2j2ee.web;

import ma.tp.tp2j2ee.entities.Product;
import ma.tp.tp2j2ee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRest {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public List<Product> products(){
        return productRepo.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id){
        Product product= productRepo.findById(id).orElse(null);
        return product;
    }


}
