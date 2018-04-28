package com.epam.spring.ws;

import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://company.com/user-web-service";

    @Autowired
	private UserService countryRepository;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public User getUser(@RequestPayload User request) {
		User user = new User();
		user.setFirstName(request.getFirstName());
		return user;
	}
}