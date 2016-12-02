package com.dmpro.DropTest;

import com.dmpro.DropTest.health.TemplateHealthCheck;
import com.dmpro.DropTest.resources.DropTestResource;

import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KingBotApplication extends Application<KingBotConfiguration> {

	public static void main(final String[] args) throws Exception {
		new KingBotApplication().run(args);
	}

	@Override
	public String getName() {
		return "KingBot";
	}

	@Override
	public void initialize(final Bootstrap<KingBotConfiguration> bootstrap) {
		bootstrap.addBundle(new Java8Bundle());
	}

	@Override
	public void run(final KingBotConfiguration configuration,
			final Environment environment) {
		final DropTestResource resource = new DropTestResource(
				configuration.getTemplate(),
				configuration.getDefaultName()
				);
		final TemplateHealthCheck healthCheck =
				new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
		environment.jersey().register(healthCheck);
	}

}
