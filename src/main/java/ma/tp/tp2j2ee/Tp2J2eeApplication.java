package ma.tp.tp2j2ee;

import com.zaxxer.hikari.util.FastList;
import ma.tp.tp2j2ee.entities.Product;
import ma.tp.tp2j2ee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2J2eeApplication implements CommandLineRunner {
    @Autowired
    private ProductRepo productRepo;

    public static void main(String[] args) {
        SpringApplication.run(Tp2J2eeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepo.save(new Product(1, "Laptop", 15200, 2));
        productRepo.save(new Product(2, "Iphone", 12300, 5));
        productRepo.save(new Product(3, "Printer", 25000, 15));
        productRepo.save(new Product(4, "Smart Watch", 9500, 5));
        productRepo.save(new Product(5, "Ipod", 4000, 35));
        productRepo.save(new Product(6, "Headset", 1000, 5));
        productRepo.save(new Product(7, "Etui", 120, 1));
        List<Product> products = productRepo.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        Product product = productRepo.findById(Long.valueOf(1)).get();
        System.out.println("***********");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantite());
        System.out.println("***********");
        List<Product> productList = productRepo.findByNameContains("C");
        productList.forEach(p -> {
            System.out.println(p);
        });
        System.out.println("-----------");
        List<Product> productList2= productRepo.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-----------");
        List<Product> productList3= productRepo.findByPriceGreaterThan(3000);
        productList2.forEach(p->{
            System.out.println(p);
        });

    }
}