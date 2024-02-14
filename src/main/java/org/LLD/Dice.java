package org.LLD;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dice {
    private int numberOfDice;
    public int rollDice(int numberOfDice){
        Random random = new Random();

        return random.nextInt(6*numberOfDice) + 1;
    }
}
