package org.eldermoraes;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("secure")
@RequestScoped
public class SecureResource {
	
	@Claim(standard = Claims.preferred_username)
	private String username;
	
	@GET
	@Path("claim")
	public String getClaim() {
		return username;
	}
}
