package ejbs;

import graphics.Point;
import graphics.User;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/")
@Local
public interface ManagerBeanInterface {

    @GET
    @Path("points")
    public List<Point> getPoints(User user);

    @POST
    @Path("user/id")
    public void sendUser(User user);

    @POST
    @Path("user/id")
    public void sendPoint(Point point);

    @GET
    @Path("user")
    public User getUser(int id);

    @GET
    @Path("hello")
    public String hello();
}
