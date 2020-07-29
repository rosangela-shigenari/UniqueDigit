package com.inter.desafiodigitounico;

import com.inter.desafiodigitounico.dtos.NumberDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UniqueDigitTest {

    @Test
    public void testUniqueDigit(){
        NumberDto numberDto = new NumberDto(654, 2);
        assertEquals(30, numberDto.calculateUniqueDigit());
    }

    @Test
    public void testUniqueDigitWithNegativeK(){
        NumberDto numberDto = new NumberDto(654, -1);
        assertEquals(15, numberDto.calculateUniqueDigit());
    }
}
