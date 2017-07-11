package com.shukla.umang.v1.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shukla.umang.domain.Cart;
import com.shukla.umang.dto.error.ErrorDetail;
import com.shukla.umang.dto.request.AddToCartRequest;
import com.shukla.umang.service.Impl.CartServiceImpl;
import com.shukla.umang.service.Impl.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.security.Principal;

/**
 * All apis endpoints related to cart stay here.
 */
@RestController("cartControllerV1")
@RequestMapping("/v1/")
@Api(value = "items", description = "Cart API")
public class CartController {

    @Inject
    private CartServiceImpl cartServiceImpl;

    @Inject
    private UserServiceImpl userServiceImpl;


    @RequestMapping(path="/addToCart", method=RequestMethod.POST)
    @ApiOperation(value="Add product to cart",
        notes = "Adds product with the given quantity to the cart of the given user. " +
            "If the same product is already present the quantity is updated")
    @ApiResponses({
        @ApiResponse(code=200, message="Product added to cart successfully", response=Cart.class),
        @ApiResponse(code=500, message="Invalid request", response=ErrorDetail.class),
    })
    public ResponseEntity<Cart> addToCart(
        @Valid @RequestBody AddToCartRequest addToCartRequest, Principal principal) {
        Long userID = userServiceImpl.getLoggedInUserId(principal);
        Cart cart = cartServiceImpl.addToCart(userID, addToCartRequest);
        return new ResponseEntity<> (cart, HttpStatus.OK);
    }

}
