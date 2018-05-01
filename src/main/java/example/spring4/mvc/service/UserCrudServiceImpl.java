package example.spring4.mvc.service;

import example.spring4.mvc.dao.UserDao;
import example.spring4.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserCrudServiceImpl implements UserCrudService {

    private int DEFAULT_MAX = 100;

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAllUsers(int max, int offset, Map options) {
        return userDao.findAll(max, offset, options);
    }

    @Override
    public List<User> findAllUsers(Map options) {
        return findAllUsers(DEFAULT_MAX, 0, options);
    }

    @Override
    public User addUser(User user) {
        long id = userDao.add(user);
        // personally prefer returning the persisted instance instead of void or id only
        return userDao.get(id);
    }

    @Override
    public void deleteUser(long id) {
    }

    @Override
    public User findUser(long id) {
        return userDao.get(id);
    }
}
