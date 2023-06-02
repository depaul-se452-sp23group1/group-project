package edu.depaul.cdm.se452.transaction;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    ShippingService shippingService;

    //   @GetMapping(value="/id/{id}", produces = "application/json")
    //  public Shipping getShippingbyTransactionId(@PathVariable long tr_id) {
    //     return shippingService.findById??(tr_id);
    // }

    @GetMapping(value="/id/{id}", produces = "application/json")
    @Operation(summary = "Get shipping details by shipping Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipping details record found"),
    })
    public Shipping getShippingbyId(@PathVariable long id) {

        return shippingService.findById(id);
    }

    @PostMapping("/add")
    @Operation(summary = "Adds a new shipping record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "shipping record created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid URL")
    })
    public Shipping addShipping(@RequestBody Shipping newShipping) {

        return shippingService.addShipping(newShipping);
    }

    @GetMapping
    @Operation(summary = "Get all shipping records ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " All shipping records found ")
    })

    public List<Shipping> getAllShipping() {
        List<Shipping> shippings = shippingService.findAll();
        return shippings;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update shipping details ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully updated shipping details"),
            @ApiResponse(responseCode = "500",description = "Shipping details record not found")
    })
    public Shipping updateShipping(@RequestBody Shipping shipping) {
        return  shippingService.updateShipping(shipping);
    }
}


