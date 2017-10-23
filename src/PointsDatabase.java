import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import point.Point;

import javax.persistence.TypedQuery;
import java.util.List;

public class PointsDatabase {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void store(Point point) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(point);
        session.getTransaction().commit();
        session.close();
    }

    public List<Point> getPoints() {
        Session session = sessionFactory.openSession();
        TypedQuery<Point> query = session.createQuery("from Point", Point.class);
        List<Point> points = query.getResultList();
        session.close();
        return points;
    }
}
