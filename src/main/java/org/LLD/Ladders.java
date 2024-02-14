package org.LLD;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Builder
public class Ladders {
    private int startPoint;
    private int endPoint;

    public Ladders(int startPoint, int endPoint){
        if(startPoint>endPoint){
            throw new IllegalArgumentException("STARTPOINT SHOULD BE LESS THAN ENDPOINT FOR LADDERS !");
        }
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
