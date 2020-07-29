package com.inter.desafiodigitounico.controller;

import com.inter.desafiodigitounico.dtos.NumberDto;
import com.inter.desafiodigitounico.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculateResult")
public class ResultController {
    @Autowired
    ResultService resultService;

    @PostMapping("calculation")
    public NumberDto calculateResult(@RequestBody NumberDto numberSequence){
        return resultService.operateResult(numberSequence);
    }
}
