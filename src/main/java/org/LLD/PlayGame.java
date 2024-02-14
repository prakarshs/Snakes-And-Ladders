package org.LLD;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Queue;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayGame {
    private Queue<Players> players;
    private Dice dice;
    private GameBoard gameBoard;
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer> ladders;
    private Map<Players,Integer> playerCurrentPosition;

    public PlayGame(GameBoard gameBoard, Dice dice, Map<Integer,Integer> snakes, Map<Integer,Integer> ladders, Queue<Players> players, Map<Players,Integer> playerCurrentPosition){
        this.gameBoard = gameBoard;
        this.dice = dice;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        this.playerCurrentPosition = playerCurrentPosition;
    }

    public void startGame(){
        while (players.size() > 1){
            Players player = players.poll();

            int diceValue = dice.rollDice(dice.getNumberOfDice());

            int newPosition = playerCurrentPosition.get(player) + diceValue;

            if(newPosition > gameBoard.getGameBoardSize()){
                System.out.println(player.getPlayerName() + " rolled " + diceValue + " and is out of board ! Wait out for next turn.");
                players.offer(player);
            }
            else{
                int newCell = newPosition;
                boolean won = false;
                if(snakes.containsKey(newCell)){
                    newPosition = snakes.get(newCell);
                    System.out.println(player.getPlayerName() + " rolled " + diceValue + " and got bit by snake ! and now went down to " + newPosition);

                } else if (ladders.containsKey(newCell)) {
                    newPosition = ladders.get(newCell);
                    System.out.println(player.getPlayerName() + " rolled " + diceValue + " and got a ladder ! and now went up to " + newPosition);

                } else if (newCell == gameBoard.getGameBoardSize()) {
                    System.out.println(player.getPlayerName() + " rolled " + diceValue + " and WON THE GAME !!");
                    won = true;
                }

                if(!won){
                    playerCurrentPosition.put(player,newPosition);
                    players.offer(player);
                    System.out.println(player.getPlayerName() + " rolled " + diceValue + " and advanced to " + newPosition);
                }else{
                    System.out.println("Remaining Players : "+ players.size());
                }

            }
        }
    }
}
