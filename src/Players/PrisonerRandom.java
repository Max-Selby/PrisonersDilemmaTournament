package Players;

import Game.Decision;
import java.util.Random;

public class PrisonerRandom implements Prisoner {
    private final String name;

    public PrisonerRandom() {
        this.name = "Random";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        Random rand = new Random();

        if (rand.nextInt(2) == 0) {
            return Decision.DEFECT;
        }
        else {
            return Decision.COOPERATE;
        }
    }
}
