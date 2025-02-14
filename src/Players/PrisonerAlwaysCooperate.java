package Players;

import Game.Decision;

public class PrisonerAlwaysCooperate implements Prisoner {
    private final String name;

    public PrisonerAlwaysCooperate() {
        this.name = "Cooperator";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        return Decision.COOPERATE;
    }

}
