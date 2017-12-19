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
    public String getPoints(@PathParam("owner_id") String id, @QueryParam("password") String password) {
        Session session = sessionFactory.openSession();
        TypedQuery<Point> pointQuery = session.createQuery("from Point where owner.id=:paramName", Point.class);
        pointQuery.setParameter("paramName", Long.valueOf(id));
        List<Point> points = pointQuery.getResultList();
        if (points.size() == 0) {
            ExceptMessage mes = new ExceptMessage("No such items");
            return gson.toJson(mes);
        }

        TypedQuery<User> userQuery = session.createQuery("from User where id=:paramName", User.class);
        userQuery.setParameter("paramName", Long.valueOf(id));
        List<User> users = userQuery.getResultList();
        User user = users.get(0);
        session.close();
        if (user.getPassword().equals(String.valueOf(password.hashCode()))) {
            return gson.toJson(points);
        } else {
            return gson.toJson("Incorrect password");
        }
    }

    @POST
    @Produces("application/json")
    @Path("/users")
    public String sendUser(String userJson) {
        User user = gson.fromJson(userJson, User.class);
        user.setPassword(String.valueOf((user.getPassword().hashCode())));

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
    public String sendPoint(@PathParam("owner_id") String id, String pointJson, @QueryParam("password") String password) {
        Session session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("from User where id=:paramName", User.class);
        query.setParameter("paramName", Long.valueOf(id));
        List<User> users = query.getResultList();
        User user = users.get(0);
        if (users.size() == 0) {
            ExceptMessage mes = new ExceptMessage("No such items");
            return gson.toJson(mes);
        }
        if (user.getPassword().equals(String.valueOf(password.hashCode()))) {
            Point point = gson.fromJson(pointJson, Point.class);
            point.setOwner(user);

            session.beginTransaction();
            session.save(point);
            session.getTransaction().commit();
            session.close();

            return gson.toJson(point);
        } else {
            return gson.toJson("Incorrect password");
        }
    }

    @GET
    @Produces("application/json")
    @Path("/users/{login}")
    public String getUser(@PathParam("login") String login, @QueryParam("password") String password) {
        Session session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("from User where login=:paramName", User.class);
        query.setParameter("paramName", login);
        List<User> users = query.getResultList();
        if (users.size() == 0) {
            ExceptMessage mes = new ExceptMessage("No such items");
            return gson.toJson(mes);
        }
        User user = users.get(0);
        session.close();
        if (user.getPassword().equals(String.valueOf(password.hashCode()))) {
            return gson.toJson(user.getId());
        } else {
            return gson.toJson("Incorrect password");
        }
    }
}
