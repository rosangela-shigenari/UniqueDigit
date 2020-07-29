package com.inter.desafiodigitounico.entities;

import com.inter.desafiodigitounico.dtos.NumberDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "numberSequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberSequence implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private int n;
    private int k;
    private int result;

    public NumberSequence(NumberDto numberDto){
        this.userId = numberDto.getUserId();
        this.k = numberDto.getK();
        this.n = numberDto.getN();
        this.result = numberDto.calculateUniqueDigit();
    }
}
