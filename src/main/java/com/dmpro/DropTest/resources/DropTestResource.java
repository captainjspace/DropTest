package com.dmpro.DropTest.resources;



import com.dmpro.DropTest.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class DropTestResource {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;

	public DropTestResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}

	@GET
	@Timed
	public Saying sayHello(@QueryParam("name") Optional<String> name) {
		//if (name == null || name.isEmpty()) name="DEF"
;		final String value = String.format(template, name.orElse(defaultName));
		return new Saying(counter.incrementAndGet(), value);
	}
}
