package com.dmpro.DropTest;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import com.dmpro.DropTest.core.Template;

import org.hibernate.validator.constraints.*;

import java.util.Collections;
import java.util.Map;

import javax.validation.constraints.*;

public class KingBotConfiguration extends Configuration {
	@NotEmpty
	private String template;

	@NotEmpty
	private String defaultName = "Stranger";


	@JsonProperty
	public String getTemplate() {
		return template;
	}

	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}

	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}

	@JsonProperty
	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	public Template buildTemplate() {
		return new Template(template, defaultName);
	}

}
