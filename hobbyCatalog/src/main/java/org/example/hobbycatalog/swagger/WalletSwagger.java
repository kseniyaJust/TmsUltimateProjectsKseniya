package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hobbycatalog.DTO.WalletDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name="",description = "")
public interface WalletSwagger {

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    String getBalance();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    String putMoney();

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    String addWallet(@RequestBody WalletDTO wallet);

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    String updateWallet(@RequestBody WalletDTO wallet);

    @Operation(summary = "")
    @ApiResponse(responseCode = "", description = "")
    @ApiResponse(responseCode = "", description = "")
    @Parameter(name = "",description = "")
    String deleteWallet(@RequestParam Long id_wallet);
}
