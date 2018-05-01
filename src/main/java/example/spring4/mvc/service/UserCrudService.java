package example.spring4.mvc.service;

import example.spring4.mvc.model.User;

import java.util.List;
import java.util.Map;

public interface UserCrudService {

    /**
     * list users with optional listing parameters
     * @param options
     * @return
     */
    public List<User> findAllUsers(int max, int offset, Map<String, Object> options);

    /**
     * @param options
     * @return
     */
    public List<User> findAllUsers(Map<String, Object> options);

    /**
     * @param user
     * @return
     */
    public User addUser(User user);

    /**
     * @param id
     */
    public void deleteUser(long id);

    /**
     *
     * @param id
     * @return {@link User} instance, or null if not found
     */
    public User findUser(long id);

}
