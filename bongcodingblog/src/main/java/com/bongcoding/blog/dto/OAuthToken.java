package com.bongcoding.blog.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude
@JsonPropertyOrder({ "access_token", "token_type", "refresh_token", "id_token", "expires_in", "scope",
	"refresh_token_expires_in" })
public class OAuthToken {

	@JsonProperty("access_token")
	public String access_token;
	@JsonProperty("token_type")
	public String token_type;
	@JsonProperty("refresh_token")
	public String refresh_token;
	@JsonProperty("id_token")
	public String id_token;
	@JsonProperty("expires_in")
	public Integer expires_in;
	@JsonProperty("scope")
	public String scope;
	@JsonProperty("refresh_token_expires_in")
	public Integer refresh_token_expires_in;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties(){
		return this.additionalProperties;
	}
	
	@JsonAnyGetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	
}