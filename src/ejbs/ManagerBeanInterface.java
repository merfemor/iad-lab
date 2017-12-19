package ejbs;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Local
public interface ManagerBeanInterface {
//
//    @GET
////    @Path("points")
//    public List<Point> getPoints(User user);
//
//    @POST
////    @Path("user/id")
//    public void sendUser(User user);
//
//    @POST
////    @Path("user/id")
//    public void sendPoint(Point point);
//
//    @GET
////    @Path("user")
//    public User getUser(int id);

    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello();
}
