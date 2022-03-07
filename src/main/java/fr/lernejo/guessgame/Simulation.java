package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long numPlayerAsk = this.player.askNextGuess();
        if (numPlayerAsk == this.numberToGuess) {
            this.logger.log("Player find number");
            return true;
        }
        this.player.respond(numPlayerAsk > this.numberToGuess);
        this.logger.log("Player didn't find the number");
        return false;
    }

    public void loopUntilPlayerSucceed(/*int maxLoop*/) {
        boolean end;
        do {
            end = this.nextRound();
            //maxLoop--;
        }while (!end);
    }
}
