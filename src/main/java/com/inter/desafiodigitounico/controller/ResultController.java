package com.inter.desafiodigitounico.controller;

import com.inter.desafiodigitounico.dtos.NumberDto;
import com.inter.desafiodigitounico.dtos.UserDto;
import com.inter.desafiodigitounico.entities.User;
import com.inter.desafiodigitounico.service.CacheMemoryService;
import com.inter.desafiodigitounico.service.ResultService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    ResultService resultService;

    @ApiOperation(value = "Calcula o digito único, com os parâmetros n e k inseridos no corpo.")
    @PostMapping("/calculation")
    public NumberDto calculateResult(@RequestParam int k, @RequestParam int n, @RequestParam(name = "userId", required = false, defaultValue = "0") int userId){
        return resultService.operateResult(userId != 0 ? new NumberDto(n, k, userId) : new NumberDto(n, k));
    }

    @ApiOperation(value = "Retorna todos os cáculos de digito único salvos no cache de 10 posições, tais como de n e k.")
    @GetMapping("/cacheMemory")
    public ResponseEntity<List<NumberDto>> listAllCacheContent(){
        return ResponseEntity.ok(CacheMemoryService.getCache());
    }
}
