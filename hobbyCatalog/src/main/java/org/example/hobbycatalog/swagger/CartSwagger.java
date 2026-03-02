package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name="Cart controller",description = "Controller that holds data about id user and items that he has")
public interface CartSwagger {

    @Operation(summary = "Method gets all items that current user has")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String getCart();

    @Operation(summary = "Method adds new item for current user")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String addItemToCart();

    @Operation(summary = "Method decreases balance and delete item for given id from table if purchase succed")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String buyItemFromCart();

    @Operation(summary = "Method deletes item from table for given id")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String deleteItemFromCart();
}
