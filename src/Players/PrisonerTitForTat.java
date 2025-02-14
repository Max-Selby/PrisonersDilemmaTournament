package Players;

import Game.Decision;

public class PrisonerTitForTat implements Prisoner {
    private final String name;

    public PrisonerTitForTat() {
        this.name = "Tit For Tat";
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

        return opponentLastMoves[opponentLastMoves.length - 1];
    }
}
