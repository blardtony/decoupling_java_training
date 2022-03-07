package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("computer");
    private final Scanner scanner = new Scanner(System.in);
    private  Long max;
    private  long min;
    private boolean higther;

    public ComputerPlayer(Long parseLong) {
        this.max = parseLong;
        this.min = - 1;
        this.higther = false;
    }


    @Override
    public long askNextGuess() {
        long guess = -1;
        if (this.min == -1L) {
            guess = this.max / 2;
            this.min = 0;
        }
        else {
            this.min = this.higther ? guess : this.min;
            this.max = !this.higther ? guess : this.max;
            guess = (this.min + this.max) / 2;
        }
        this.logger.log("Answer : " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        this.higther = lowerOrGreater;
        if (lowerOrGreater) {
            this.logger.log("la solution est plus petit");
            System.out.println("La réponse est plus petit");
        }
        else{
            this.logger.log("la solution est plus grand");
            System.out.println("La réponse est plus grand");
        }
    }

}
