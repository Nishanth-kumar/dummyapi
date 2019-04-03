package com.test.customer;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
	@RequestMapping("/")
	public String welcome() {

		final String uri = "http://dummy.restapiexample.com/api/v1/employees";

        SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.cognizant.com", 6050));
        clientHttpReq.setProxy(proxy);

        RestTemplate restTemplate = new RestTemplate(clientHttpReq);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        System.out.println("Connection Tried");
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        System.out.println("Connection Ends Here");
        System.out.println(result);
        return result.toString();


	}

	@RequestMapping("/getUsers")
	public String getUsers() {
		/*
		 * RestTemplate rt=new RestTemplate(); ResponseEntity<String> response =
		 * rt.getForEntity(("https://crowdserver/crowd/rest/usermanagement/1/user/"),
		 * String.class); System.out.println(response);
		 */
		return "Hai Hello How are you";
	}
}
