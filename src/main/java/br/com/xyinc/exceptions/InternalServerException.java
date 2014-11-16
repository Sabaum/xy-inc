package br.com.xyinc.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.xyinc.utils.JsonResult;

public class InternalServerException extends WebApplicationException {

	private static final long serialVersionUID = -5822223994525621986L;
	
	private String detail;

	public InternalServerException(String detail) {
		super(Response.status(Status.INTERNAL_SERVER_ERROR)
				.type(MediaType.APPLICATION_JSON)
				.entity(new JsonResult(detail))
				.build());
		this.detail = detail != null ? detail : "";
	}

	public String getDetail() {
		return detail;
	}

}