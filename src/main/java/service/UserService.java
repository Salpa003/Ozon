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

    public long login(String login, String password) {
        Session session = SessionPool.get();
        User user = userDao.getByLogin(session,login);
        session.close();
        if (user==null)
            return -1;
        if (user.getPassword().equals(password))
            return user.getId();
        else
            return -2;
    }

    public boolean donate(long id, double sum) {
        Session session = SessionPool.get();
        boolean b = userDao.donate(session,id,sum);
        session.close();
        return b;
    }
}
