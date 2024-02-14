package org.LLD;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Snakes {
    private int startPoint;
    private int endPoint;

    public Snakes(int startPoint, int endPoint){
        if(startPoint<endPoint){
            throw new IllegalArgumentException("STARTPOINT SHOULD BE MORE THAN ENDPOINT FOR SNAKES !");
        }
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
