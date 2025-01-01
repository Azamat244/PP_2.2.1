package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private  SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Transactional
    @Override
    public User getUserByCarModelAndSeries(String model, String series) {
        String queryString = "FROM User u WHERE u.car.model = :model AND u.car.series = :series";
        Query<User> query = sessionFactory.getCurrentSession().createQuery(queryString, User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.uniqueResult();
    }
}
