import lombok.Cleanup;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        @Cleanup SessionFactory sessionFactory = configuration.buildSessionFactory();

    }
}
