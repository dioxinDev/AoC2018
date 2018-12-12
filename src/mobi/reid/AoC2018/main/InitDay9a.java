package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Player;

import java.util.ArrayList;

public class InitDay9a {


    public static void main(String[] args) {
        int totalPlayers = 24;
        int highestScoreBall = 23;
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        board.add(0);
        int currPosition = 0;
        for (int i = 0; i < totalPlayers; i++) {
            players.add(new Player(i+1));
        }
        System.out.println("Start of Looping");
        for (int ball = 0; ball < highestScoreBall ;) {
            System.out.println("Start of inner Looping");
            for(Player player :players){
                 ball++;
                 if(ball%23==0){
                     player.score += ball;
                     if(currPosition-7<0){
                         currPosition = board.size()+currPosition-7;
                         player.score += board.remove(currPosition);
                         currPosition-=2;
                     } else {
                         currPosition-=8;
                         player.score += board.remove((currPosition));
                         currPosition-=2;
                     }

                 }
                 currPosition++;
                System.out.println("currpostion"+currPosition);
                 if(currPosition>=board.size()){
                     board.add(1,ball);
                     currPosition++;

                 } else if (currPosition==board.size()-1){
                     board.add(ball);
                     currPosition++;
                 } else {
                     board.add(currPosition,ball);
                     currPosition++;
                 }
                 if(ball==highestScoreBall){
                     System.out.println("highestBallReached");
                     System.out.println(ball%23);
                     break;
                 }
                System.out.println(board);
            }

        }
        for(Player player :players){
            System.out.println(player.name + ":"+player.score);
        }


    }
}
