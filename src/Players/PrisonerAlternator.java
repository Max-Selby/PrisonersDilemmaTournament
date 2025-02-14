package Players;

import Game.Decision;

public class PrisonerAlternator implements Prisoner {
    private final String name;

    public PrisonerAlternator() {
        this.name = "Alternator";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        if (opponentLastMoves.length % 2 == 0) {
            return Decision.COOPERATE;
        }
        return Decision.DEFECT;
    }
}
