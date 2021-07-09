package javaspringproject.northwind.business.concretes;

import javaspringproject.northwind.business.abstracts.ProductService;
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
    public List<Product> getAll() {
        return productDao.findAll();
    }

}
