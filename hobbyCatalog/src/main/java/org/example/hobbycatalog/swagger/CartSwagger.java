package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="",description = "")
public interface CartSwagger {

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String getCart();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String addItemToCart();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String buyItemFromCart();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String deleteItemFromCart();
}
