package javaspringproject.northwind.business.concretes;

import javaspringproject.northwind.business.abstracts.UserService;
import javaspringproject.northwind.core.dataAccess.UserDao;
import javaspringproject.northwind.core.entities.User;
import javaspringproject.northwind.core.utilities.results.DataResult;
import javaspringproject.northwind.core.utilities.results.Result;
import javaspringproject.northwind.core.utilities.results.SuccessDataResult;
import javaspringproject.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email));
    }

}
