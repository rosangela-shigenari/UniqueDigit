package com.inter.desafiodigitounico.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode
public class NumberDto {
    @Getter@Setter
    private int n;
    private int k;
    private int result;

    public int calculateUniqueDigit(){
        this.result = String.valueOf(this.n).repeat(this.k).chars().map(Character::getNumericValue).sum();
        return this.result;
    }
}
