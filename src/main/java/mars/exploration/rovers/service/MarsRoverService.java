package mars.exploration.rovers.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import mars.exploration.rovers.MarsRover;

@Path("/mars")
public class MarsRoverService
{
	@GET
	@Path("/{directions}")
	@Produces("application/json; charset=UTF-8")
	public Response moveRover(@PathParam("directions") String directions)
	{
		String positionRover = "";
		String[] position = null;

		try
		{
			position = MarsRover.getInstance().moveRover(directions);
		}
		catch (Exception e)
		{
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}

		positionRover = MarsRover.getInstance().parsePositionToString(position);

		return Response.ok(positionRover).build();
	}
}
