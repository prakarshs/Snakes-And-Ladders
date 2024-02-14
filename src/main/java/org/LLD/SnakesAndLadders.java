package org.LLD;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders {
    public static void main(String[] args) {

        Dice dice = Dice.builder()
                .numberOfDice(2)
                .build();

        Players player1 = Players.builder()
                .playerId(1)
                .playerName("Raju")
                .build();
        Players player2 = Players.builder()
                .playerId(1)
                .playerName("Shyam")
                .build();
        Players player3 = Players.builder()
                .playerId(1)
                .playerName("Chintu")
                .build();

        Queue<Players> players = new LinkedList<>();

        players.add(player1);
        players.add(player2);
        players.add(player3);

        GameBoard gameBoard = GameBoard.builder()
                .gameBoardSize(100)
                .build();

        Snakes snake1 = Snakes.builder()
                .startPoint(17)
                .endPoint(7)
                .build();
        Snakes snake2 = Snakes.builder()
                .startPoint(54)
                .endPoint(34)
                .build();
        Snakes snake3 = Snakes.builder()
                .startPoint(87)
                .endPoint(24)
                .build();
        Snakes snake4 = Snakes.builder()
                .startPoint(99)
                .endPoint(78)
                .build();

        Map<Integer,Integer> snakes = new HashMap<>();
        snakes.put(snake1.getStartPoint(), snake1.getEndPoint());
        snakes.put(snake2.getStartPoint(), snake2.getEndPoint());
        snakes.put(snake3.getStartPoint(), snake3.getEndPoint());
        snakes.put(snake4.getStartPoint(), snake4.getEndPoint());

        Ladders ladder1 = Ladders.builder()
                .startPoint(4)
                .endPoint(14)
                .build();
        Ladders ladder2 = Ladders.builder()
                .startPoint(9)
                .endPoint(31)
                .build();
        Ladders ladder3 = Ladders.builder()
                .startPoint(28)
                .endPoint(84)
                .build();
        Ladders ladder4 = Ladders.builder()
                .startPoint(71)
                .endPoint(91)
                .build();

        Map<Integer,Integer> ladders = new HashMap<>();
        ladders.put(ladder1.getStartPoint(), ladder1.getEndPoint());
        ladders.put(ladder2.getStartPoint(), ladder2.getEndPoint());
        ladders.put(ladder3.getStartPoint(), ladder3.getEndPoint());
        ladders.put(ladder4.getStartPoint(), ladder4.getEndPoint());

        Map<Players,Integer> playerCurrentPosition = new HashMap<>();
        playerCurrentPosition.put(player1, 1);
        playerCurrentPosition.put(player2, 1);
        playerCurrentPosition.put(player3, 1);

        PlayGame playGame = PlayGame.builder()
                .dice(dice)
                .gameBoard(gameBoard)
                .players(players)
                .snakes(snakes)
                .ladders(ladders)
                .playerCurrentPosition(playerCurrentPosition)
                .build();
        playGame.startGame();

    }
}