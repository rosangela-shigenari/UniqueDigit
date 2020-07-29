package com.inter.desafiodigitounico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberSequence {
    @Id
    @GeneratedValue
    private int id;
    private int n;
    private int k;
    @Setter
    private int result;
}
