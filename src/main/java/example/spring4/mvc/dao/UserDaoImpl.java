package example.spring4.mvc.dao;

import example.spring4.mvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> findAll(int max, int offset, Map<String, Object> options) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);

        if (options.get("firstName") != null) {
            cq.select(root).where(cb.equal(root.get("firstName"), options.get("firstName")));
        } else {
            cq.select(root);
        }

        Query<User> query = session.createQuery(cq)
                .setMaxResults(max)
                .setFirstResult(offset);
        return query.getResultList();
    }

    @Override
    public User get(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public long add(User user) {
        sessionFactory.getCurrentSession().persist(user);
        return user.getId();
    }


}
