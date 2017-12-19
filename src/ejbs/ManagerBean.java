package ejbs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import graphics.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/")
@Local
public class ManagerBean {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
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
@POST
@Produces("application/json")
@Path("/users")
public String sendUser(String userJson) {
    User user = gson.fromJson(userJson, User.class);

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(user);
    session.getTransaction().commit();
    session.close();

    return gson.toJson(user);
}
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
    @Path("/hello")
    public String hello() {
        System.out.println("HUI");
        return "Hello, HUI";
    }
}
