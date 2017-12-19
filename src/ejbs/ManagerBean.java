package ejbs;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/hello")
public class ManagerBean implements ManagerBeanInterface {
//    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//
//    @Override
//    public List<Point> getPoints(User user) {
//        Session session = sessionFactory.openSession();
//        TypedQuery<Point> query = session.createQuery("from Point where owner=:paramName", Point.class);
//        query.setParameter("paramName", user);
//        List<Point> points = query.getResultList();
//        session.close();
//        return points;
//    }
//
//    @Override
//    public void sendUser(User user) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void sendPoint(Point point) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(point);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public User getUser(int id) {
//        Session session = sessionFactory.openSession();
//        TypedQuery<User> query = session.createQuery("from User where id=:paramName", User.class);
//        query.setParameter("paramName", id);
//        List<User> users = query.getResultList();
//        User user = users.get(0);
//        session.close();
//        return user;
//    }

    @GET
    @Produces("text/plain")
    @Override
    public String hello() {
        return "Hello, HUI";
    }
}
