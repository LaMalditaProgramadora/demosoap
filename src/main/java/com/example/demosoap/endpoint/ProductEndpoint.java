package com.example.demosoap.endpoint;

import com.example.demosoap.repository.ProductRepository;
import com.example.demosoap.gen.GetProductRequest;
import com.example.demosoap.gen.GetProductResponse;
import com.example.demosoap.gen.GetProductsRequest;
import com.example.demosoap.gen.GetProductsResponse;
import com.example.demosoap.gen.PostProductRequest;
import com.example.demosoap.gen.PostProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";

    @Autowired
    private ProductRepository productRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productRepository.findByName(request.getName()));
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProducts(@RequestPayload GetProductsRequest request) {
        GetProductsResponse response = new GetProductsResponse();
        response.setProducts(productRepository.findAll());
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProductRequest")
    @ResponsePayload
    public PostProductResponse getProducts(@RequestPayload PostProductRequest request) {
        PostProductResponse response = new PostProductResponse();
        response.setProduct(productRepository.save(request.getProduct()));
        return response;
    }
}

