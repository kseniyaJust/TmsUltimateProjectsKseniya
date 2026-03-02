package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hobbycatalog.DTO.UserAdressDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "",description = "")
public interface UserAdressSwagger {

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String getAllAdresses();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String addAdress(@RequestBody UserAdressDTO userAdress);

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String updateAdress(@RequestBody UserAdressDTO userAdress);

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    public String deleteAdress(@RequestParam Long id_adress);
}
