package br.com.xyinc.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

@Provider
public final class JsonMessageBodyHandler extends JacksonJsonProvider {

	/**
	 * Serialization writer.
	 */
	@Override
	public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
		super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, entityStream);
	}

}