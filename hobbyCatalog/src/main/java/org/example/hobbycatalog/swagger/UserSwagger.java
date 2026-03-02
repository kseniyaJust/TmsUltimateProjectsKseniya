package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="User controller",description = "Controller that responsible for authorisation/authentification of user")
public interface UserSwagger {

    @Operation(summary = "Method, that register new user")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String registUser();

    @Operation(summary = "Method that log in existing user")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String loginUser();

    @Operation(summary = "Method that refresh token to continue current user session")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String refreshToken();
}
