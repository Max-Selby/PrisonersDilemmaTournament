package Players;

import Game.Decision;

public class PrisonerAlwaysDefect implements Prisoner {
    private final String name;

    public PrisonerAlwaysDefect() {
        this.name = "Defector";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        return Decision.DEFECT;
    }
}
