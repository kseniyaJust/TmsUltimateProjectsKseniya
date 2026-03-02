package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="",description = "")
public interface UserSwagger {

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String registUser();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String loginUser();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String refreshToken();
}
