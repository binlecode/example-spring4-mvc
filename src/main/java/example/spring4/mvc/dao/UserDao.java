package example.spring4.mvc.dao;

import example.spring4.mvc.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     *
     * @param options
     * @return
     */
    List<User> findAll(int max, int offset, Map<String, Object> options);

    /**
     *
     * @param id
     * @return {@link User} instance or null if not found
     */
    User get(long id);

    /**
     *
     * @param user
     * @return saved {@link User} entity instance id
     */
    long add(User user);

}
