package service;

import dao.SessionPool;
import dao.UserDao;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {
    private UserDao userDao = UserDao.getInstance();

    public long createUser(String login,String password) {
        Session session = SessionPool.get();
        long id = userDao.createUserByLoginAndPassword(session, login,password);
        session.close();
        return id;
    }

    public User get(long id) {
        Session session = SessionPool.get();
        User user = userDao.getById(session,id);
        session.close();
        return user;
    }
}
