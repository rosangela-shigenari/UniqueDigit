package com.inter.desafiodigitounico.dtos;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class NumberDto {
    private int userId;
    private int n;
    private int k;
    private int result;

    public NumberDto(int n, int k){
        this.n = n;
        this.k = k;
    }

    public NumberDto(int n, int k, int userId){
        this.n = n;
        this.k = k;
        this.userId = userId;
    }

    public int calculateUniqueDigit(){
        if(this.k < 0){
            k = 1;
        }
        this.result = String.valueOf(this.n).repeat(this.k).chars().map(Character::getNumericValue).sum();
        return this.result;
    }
}
