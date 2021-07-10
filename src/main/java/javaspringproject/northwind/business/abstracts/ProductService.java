package javaspringproject.northwind.business.abstracts;

import javaspringproject.northwind.core.utilities.results.DataResult;
import javaspringproject.northwind.core.utilities.results.Result;
import javaspringproject.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);
}
