package org.example.hobbycatalog.controller;

import org.example.hobbycatalog.DTO.WalletDTO;
import org.example.hobbycatalog.entity.Wallet;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @GetMapping
    private String getBalance(){
        return "balance";
    }

    @PutMapping
    private String putMoney(){
        return "money";
    }

    @PostMapping
    private String addWallet(@RequestBody WalletDTO wallet){
        return "new wallet";
    }

    //wallet can be deleted or updated only by owner user
    @PutMapping
    private String updateWallet(@RequestBody WalletDTO wallet){
        return "update wallet";
    }

    @DeleteMapping
    private String deleteWallet(@RequestParam Long id_wallet){
        return "delete wallet";
    }
}
