import dao.SessionPool;
import dao.UserDao;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        try(Session session = SessionPool.get()) {
            System.out.println("ee");
        }
        SessionPool.stop();
    }
}
