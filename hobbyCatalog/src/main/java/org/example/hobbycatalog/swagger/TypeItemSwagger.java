package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "",description = "")
public interface TypeItemSwagger {

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String getAllTypes();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String createNewType();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String updateType();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String deleteType();
}
