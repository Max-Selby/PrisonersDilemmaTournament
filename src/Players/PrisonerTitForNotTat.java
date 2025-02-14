package Players;

import Game.Decision;

public class PrisonerTitForNotTat implements Prisoner {
    private final String name;

    public PrisonerTitForNotTat() {
        this.name = "Tit for Not Tat";
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

        if (opponentLastMoves[opponentLastMoves.length - 1] == Decision.COOPERATE) {
            return Decision.DEFECT;
        }
        return Decision.COOPERATE;
    }
}
