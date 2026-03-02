package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Type of hobbies controller",description = "Controller that allow to make CRUD operations with types of hobbies. " +
"Functions below available only for admin")
public interface TypeItemSwagger {

    @Operation(summary = "Method gives a list of all existing types of hobbies")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String getAllTypes();

    @Operation(summary = "Method that allows to create new type of hobby")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String createNewType();

    @Operation(summary = "Method that allow to update 1 existing type of hobby for given id")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String updateType();

    @Operation(summary = "Method that allows to delete 1 existing type of hobby for given id")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    public String deleteType();
}
