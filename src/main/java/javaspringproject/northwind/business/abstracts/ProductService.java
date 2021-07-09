package javaspringproject.northwind.business.abstracts;

import javaspringproject.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

}
