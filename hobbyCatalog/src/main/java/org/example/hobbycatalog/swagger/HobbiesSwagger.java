package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Hobbies controller",description = "Controller that holds all information about different types of hobby and their details (price, amount of players, etc.)")
public interface HobbiesSwagger {

    @Operation(summary = "Method gives list of all present hobbies. Filter is available")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String getAllCatalog();

    @Operation(summary = "Method gives 1 hobby for given id")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String getOneHobby(@PathVariable Long id);

    @Operation(summary = "Method that allows to create new hobby (only for admin)")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String createHobby();

    @Operation(summary = "Method that allows to update 1 existing hobby for given id (only for admin)")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String changeHobby(@PathVariable Long id);

    @Operation(summary = "Method that allows to delete existing hobby for given id(only for admin)")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String deleteHobby(@PathVariable Long id);
}
