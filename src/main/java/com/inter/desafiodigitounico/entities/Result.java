package com.inter.desafiodigitounico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
@Data
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue
    private int id;
    private int n;
    private int k;
    private int result;

    public int calculateUniqueDigit(int n, int k){
        return String.valueOf(n).repeat(k).chars().map(Character::getNumericValue).sum();
    }
}
