package javaspringproject.northwind.business.abstracts;

import javaspringproject.northwind.core.entities.User;
import javaspringproject.northwind.core.utilities.results.DataResult;
import javaspringproject.northwind.core.utilities.results.Result;

public interface UserService {
    Result add (User user);
    DataResult<User> findByEmail(String email);
}
