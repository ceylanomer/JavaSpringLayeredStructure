package javaspringproject.northwind.api.controllers;

import javaspringproject.northwind.business.abstracts.ProductService;
import javaspringproject.northwind.core.utilities.results.DataResult;
import javaspringproject.northwind.core.utilities.results.Result;
import javaspringproject.northwind.core.utilities.results.SuccessDataResult;
import javaspringproject.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return productService.add(product);
    }
}
