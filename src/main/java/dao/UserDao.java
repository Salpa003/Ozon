package dao;

import entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {
    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public long createUserByLoginAndPassword(Session session, String login, String password) {
        Transaction transaction = session.beginTransaction();
        User user = User.builder()
                .login(login)
                .password(password)
                .build();
        session.persist(user);
        transaction.commit();
        return user.getId();
    }

    public User getById(Session session ,long id) {
        Transaction transaction = session.beginTransaction();
        User user = session.find(User.class,id);
        transaction.commit();
        return user;
    }

    public User getByLogin(Session session, String login) {
        Transaction transaction = session.beginTransaction();
        List<User> user = session.createQuery("select u from User u where login = :login", User.class)
                .setParameter("login",login).getResultList();
        transaction.commit();
        if (user.isEmpty())
            return null;
        return user.get(0);
    }


}
