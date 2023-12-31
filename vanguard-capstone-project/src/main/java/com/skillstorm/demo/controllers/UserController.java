package com.skillstorm.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * The Class UserController.
 */
@RestController
@CrossOrigin(allowCredentials = "true", originPatterns = "http://simran-proj-react-bucket.s3-website-us-east-1.amazonaws.com")
public class UserController {
	
	/** The client service. */
	@Autowired
	private OAuth2AuthorizedClientService clientService;

	// Redirects the user to the frontend application (S3 bucket, localhost:5173)
	// Users should ONLY access the app using this
	/**
	 * Redirect view.
	 *
	 *
	 * @return the redirect view
	 */
	// This is done to get the JSESSIONID cookie established (login with Google)
	@GetMapping("/signin")
	public RedirectView redirectView() {
		RedirectView redirectView = new RedirectView("http://simran-proj-react-bucket.s3-website-us-east-1.amazonaws.com");
		return redirectView;
	}
	
	/**
	 * User info.
	 *
	 * @param user the user
	 * @return the map
	 */
	@GetMapping("/userinfo")
	@ResponseBody // Send the data as JSON
	public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User user) {
		// Info about the user
		return user.getAttributes();
	}
	
	/**
	 * Access token.
	 *
	 * @param auth the auth
	 * @return the string
	 */
	// Return access token
	@GetMapping("/access")
	@ResponseBody
	public String accessToken(Authentication auth) {
		if (auth instanceof OAuth2AuthenticationToken) {
			OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) auth;
			OAuth2AuthorizedClient client = clientService
					.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(), authToken.getName());
			return client.getAccessToken().getTokenValue();
		}
		return "";
	}
	
}
