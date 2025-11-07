package dao;

import entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
