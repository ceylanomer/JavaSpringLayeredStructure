package javaspringproject.northwind.business.concretes;

import javaspringproject.northwind.business.abstracts.ProductService;
import javaspringproject.northwind.core.utilities.results.*;
import javaspringproject.northwind.dataAccess.abstracts.ProductDao;
import javaspringproject.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(this.productDao.findAll(), "Data listelendi.");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

}
