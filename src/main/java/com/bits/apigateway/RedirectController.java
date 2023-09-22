package com.bits.apigateway;

import com.bits.apigateway.model.CartItem;
import com.bits.apigateway.model.LoginRequest;
import com.bits.apigateway.model.SignUpRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class RedirectController {


    @PostMapping("/api/loginredirect/")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String apiUrl = Constants.baseUrl + "/api/login/";
        System.out.println("$$$$Login redirect");

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Send the POST request and receive the response
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, request, String.class);

        return responseEntity;
    }

    @PostMapping("/api/registerRedirect/")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        String apiUrl = Constants.baseUrl + "/api/register/";
        System.out.println("$$$$ SignUp redirect");

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Send the POST request and receive the response
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, request, String.class);

        return responseEntity;
    }

    @GetMapping("/api/stockItemsRedirect/")
    public ResponseEntity<String> stockItems(@RequestParam String category) {
        String apiUrl = Constants.baseUrl + "/api/stockitems/?category=" + category;

        System.out.println("$$$$ Get Stock Items redirect");

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send the GET request and receive the response
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        return responseEntity;
    }

    @PostMapping("/api/cartitem/add/redirect")
    public ResponseEntity<String> addCartItem(@RequestBody CartItem request) {
        String apiUrl = Constants.baseUrl + "/api/cartitem/add/";
        System.out.println("$$$$ Add Cart Item redirect");

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Send the POST request and receive the response
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, request, String.class);

        return responseEntity;
    }

    @GetMapping("/api/cartItemsRedirect/")
    public ResponseEntity<String> getCartItems() {
        String apiUrl = Constants.baseUrl + "/api/cartitems/";
        System.out.println("$$$$ Get Stock Items redirect");

        // Create a RestTemplate instance
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        // Send the GET request and receive the response
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        return responseEntity;
    }

    @PostMapping("/api/placeorder/redirect")
    public ResponseEntity<String> placeOrder(@RequestBody List<CartItem> request) {
        String apiUrl = Constants.baseUrl + "/api/placeorder/";
        System.out.println("$$$$ Place Order redirect");

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Send the POST request and receive the response
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, request, String.class);

        return responseEntity;
    }

    @GetMapping("/api/vieworder/redirect")
    public ResponseEntity<String> viewOrders() {
        String apiUrl = Constants.baseUrl + "/api/vieworder/";
        System.out.println("$$$$ Get Stock Items redirect");

        // Create a RestTemplate instance
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        // Send the GET request and receive the response
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        return responseEntity;
    }
}
