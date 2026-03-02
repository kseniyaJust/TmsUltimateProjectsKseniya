package org.example.hobbycatalog.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hobbycatalog.DTO.WalletDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name="Wallet Controller",description = "Controller that responsible for CRUD operations with wallet and money in it"+
"Only owner of wallet can make any operations below")
public interface WalletSwagger {

    @Operation(summary = "Method that gives amount of current balance of current user's wallet")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    String getBalance();

    @Operation(summary = "Method that put some given number to wallet of current user's wallet")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    String putMoney();

    @Operation(summary = "Method that allows to add new wallet and it's info of current user's wallet")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    String addWallet(@RequestBody WalletDTO wallet);

    @Operation(summary = "Method that allows to update info in wallet of current user's wallet")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    String updateWallet(@RequestBody WalletDTO wallet);

    @Operation(summary = "Method that allow to delete wallet for given id of current user's wallet")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "400", description = "")
    @ApiResponse(responseCode = "403", description = "")
    @ApiResponse(responseCode = "409", description = "")
    @ApiResponse(responseCode = "500", description = "")
    @Parameter(name = "",description = "")
    String deleteWallet(@RequestParam Long id_wallet);
}
