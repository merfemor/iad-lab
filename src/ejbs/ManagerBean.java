package ejbs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import graphics.Point;
import graphics.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@Path("/")
@Local
public class ManagerBean {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @GET
    @Produces("application/json")
    @Path("/users/{owner_id}/points")
    public String getPoints(@PathParam("owner_id") String id) {
        Session session = sessionFactory.openSession();
        TypedQuery<Point> query = session.createQuery("from Point where owner.id=:paramName", Point.class);
        query.setParameter("paramName", Long.valueOf(id));
        List<Point> points = query.getResultList();
        if (points.size() == 0) {
            ExceptMessage mes = new ExceptMessage("No such items");
            return gson.toJson(mes);
        }
        session.close();

        return gson.toJson(points);
    }

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

    @POST
    @Produces("application/json")
    @Path("/users/{owner_id}/points")
    public String sendPoint(@PathParam("owner_id") String id, String pointJson) {
        Point point = gson.fromJson(pointJson, Point.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(point);
        session.getTransaction().commit();
        session.close();

        return gson.toJson(point);
    }

    @GET
    @Produces("application/json")
    @Path("/users/{owner_id}")
    public String getUser(@PathParam("owner_id") String id) {
        Session session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("from User where id=:paramName", User.class);
        query.setParameter("paramName", Long.valueOf(id));
        List<User> users = query.getResultList();
        if (users.size() == 0) {
            ExceptMessage mes = new ExceptMessage("No such items");
            return gson.toJson(mes);
        }
        User user = users.get(0);

        session.close();

        return gson.toJson(user);
    }

    @GET
    @Produces("text/plain")
    @Path("/hello")
    public String hello() {
        System.out.println("HUI");
        return "Hello, HUI";
    }
}
