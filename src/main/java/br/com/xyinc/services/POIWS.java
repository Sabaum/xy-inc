package br.com.xyinc.services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.xyinc.business.IPOIBusiness;
import br.com.xyinc.domain.POI;
import br.com.xyinc.exceptions.InternalServerException;

@Path("poi")
@Component
public class POIWS {

	private static final String ADD_ERROR_MSG = "Devem ser informados a posição x, a posição y e o nome do estabelecimento";
	private static final String NEAREST_ERROR_MSG = "Devem ser informados a posição x, a posição y e a distância máxima";

	@Autowired
	private IPOIBusiness poiBusiness;

	/**
	 * Lists all the Points of Interest (POI).
	 */
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<POI> list() {
		return poiBusiness.list();
	}

	/**
	 * Adds a new Point of Interest (POI).
	 * @param xPos POI's X position.
	 * @param yPos POI's Y position.
	 * @param name POI's name.
	 */
	@Path("/")
	@POST
	public void add(@QueryParam("x") Integer xPos,
			@QueryParam("y") Integer yPos, @QueryParam("name") String name) {
		if (xPos == null || yPos == null || StringUtils.isEmpty(name)) {
			throw new InternalServerException(ADD_ERROR_MSG);
		}
		poiBusiness.add(name, xPos, yPos);
	}

	/**
	 * List the nearest Points of Interest (POI).
	 * @param xPos Current X position.
	 * @param yPos Current Y position.
	 * @param maxDistance Max distance for POIs.
	 * @return
	 */
	@Path("/nearest")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<POI> findNearest(@QueryParam("x") Integer xPos,
			@QueryParam("y") Integer yPos,
			@QueryParam("dMax") Integer maxDistance) {
		if (xPos == null || yPos == null || maxDistance == null) {
			throw new InternalServerException(NEAREST_ERROR_MSG);
		}
		return poiBusiness.nearest(xPos, yPos, maxDistance);
	}
	
	/**
	 * Populates the database with default data.
	 */
	@Path("/populate")
	@POST
	public void populate() {
		poiBusiness.populate();
	}
	
	/**
	 * Deletes all data on database.
	 */
	@Path("/")
	@DELETE
	public void deleteAll() {
		poiBusiness.deleteAll();
	}
}
