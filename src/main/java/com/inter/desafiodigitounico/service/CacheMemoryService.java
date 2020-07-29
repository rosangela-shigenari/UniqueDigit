package com.inter.desafiodigitounico.service;

import com.inter.desafiodigitounico.dtos.NumberDto;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CacheMemoryService {

    @Getter
    private static List<NumberDto> cache = new ArrayList<>();

    public static void saveInCache(NumberDto numberSequence){
        if (cache.size() == 10) {
            cache.remove(0);
        } else {
            cache.add(numberSequence);
        }
    }

    public static NumberDto searchDigit(NumberDto numberSequence){
        for(NumberDto number : cache){
            if(number.equals(numberSequence)){
                return number;
            }
        }
        return null;
    }
}
