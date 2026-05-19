package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserRepository {
    private final SessionFactory sf;

    public User create(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Ошибка создания пользователя", e);
        } finally {
            session.close();
        }
        return user;
    }

    public void update(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            "UPDATE User SET login = :flogin, password = :fpassword WHERE id = :fId")
                    .setParameter("flogin", user.getLogin())
                    .setParameter("fpassword", user.getPassword())
                    .setParameter("fId", user.getId())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Ошибка обновления пользователя", e);
        } finally {
            session.close();
        }
    }

    public void delete(Integer userId) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM User WHERE id = :fId")
                    .setParameter("fId", userId)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Ошибка удаления пользователя", e);
        } finally {
            session.close();
        }
    }

    public List<User> findAllOrderById() {
        Session session = sf.openSession();
        try {
            return session.createQuery("FROM User ORDER BY id ASC", User.class)
                    .getResultList();
        } finally {
            session.close();
        }
    }

    public Optional<User> findById(Integer userId) {
        Session session = sf.openSession();
        try {
            return Optional.ofNullable(session.createQuery(
                            "FROM User AS i WHERE i.id = :fId", User.class)
                    .setParameter("fId", userId)
                    .uniqueResult());
        } finally {
            session.close();
        }
    }

    public List<User> findByLikeLogin(String key) {
        Session session = sf.openSession();
        try {
            return session.createQuery(
                            "FROM User AS i WHERE i.login LIKE :fKey", User.class)
                    .setParameter("fKey", "%" + key + "%")
                    .getResultList();
        } finally {
            session.close();
        }
    }

    public Optional<User> findByLogin(String login) {
        Session session = sf.openSession();
        try {
            return Optional.ofNullable(session.createQuery(
                            "FROM User AS i WHERE i.login = :fLogin", User.class)
                    .setParameter("fLogin", login)
                    .uniqueResult());
        } finally {
            session.close();
        }
    }
}