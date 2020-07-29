package com.inter.desafiodigitounico.service;
import com.inter.desafiodigitounico.entities.NumberSequence;
import com.inter.desafiodigitounico.dtos.NumberDto;
import com.inter.desafiodigitounico.repositories.ResultRepository;
import com.inter.desafiodigitounico.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    ResultRepository resultRepository;

    public NumberDto operateResult(NumberDto numberSequence){
        NumberDto number = CacheMemoryService.searchDigit(numberSequence);

        if(number != null){
            return number;
        }
        else{
            NumberSequence newNumber = new NumberSequence(numberSequence);
            CacheMemoryService.saveInCache(numberSequence);
            resultRepository.save(newNumber);
        }
        return numberSequence;
    }
}
