package Players;

import Game.Decision;

import java.util.Random;

public class PrisonerForgivingTitForTat implements Prisoner {
    private final String name;

    public PrisonerForgivingTitForTat() {
        this.name = "Forgiving Tit For Tat";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        if (opponentLastMoves.length == 0) {
            return Decision.COOPERATE;
        }

        Random rand = new Random();

        if (rand.nextInt(100) < 4) {
            return Decision.COOPERATE;
        }

        return opponentLastMoves[opponentLastMoves.length - 1];
    }
}
