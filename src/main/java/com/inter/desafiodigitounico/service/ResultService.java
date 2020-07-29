package com.inter.desafiodigitounico.service;
import com.inter.desafiodigitounico.entities.NumberSequence;
import com.inter.desafiodigitounico.dtos.NumberDto;
import com.inter.desafiodigitounico.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultService {
    @Autowired
    ResultRepository resultRepository;

    public NumberDto operateResult(NumberDto numberSequence){
        NumberDto number = CacheMemoryService.searchDigit(numberSequence);

        if(number != null){
            return number;
        }
        else{
            NumberSequence newNumber = new NumberSequence();
            newNumber.setResult(numberSequence.calculateUniqueDigit());
            newNumber.setK(numberSequence.getK());
            newNumber.setN(numberSequence.getN());
            resultRepository.save(newNumber);
        }
        return numberSequence;
    }
}
