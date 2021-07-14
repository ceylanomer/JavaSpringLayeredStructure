package javaspringproject.northwind.api.controllers;

import javaspringproject.northwind.business.abstracts.ProductService;
import javaspringproject.northwind.core.utilities.results.DataResult;
import javaspringproject.northwind.core.utilities.results.Result;
import javaspringproject.northwind.core.utilities.results.SuccessDataResult;
import javaspringproject.northwind.entities.concretes.Product;
import javaspringproject.northwind.entities.dtos.ProductWithCategoryDto;
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
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

    @GetMapping("/getProductWithCategoryDetails")
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }
}
