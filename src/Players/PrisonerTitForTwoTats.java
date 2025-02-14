package Players;

import Game.Decision;

public class PrisonerTitForTwoTats implements Prisoner {
    private final String name;

    public PrisonerTitForTwoTats() {
        this.name = "Tit For Two Tats";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        if (opponentLastMoves.length == 0 || opponentLastMoves.length == 1) {
            return Decision.COOPERATE;
        }

        if (
                opponentLastMoves[opponentLastMoves.length - 1] == Decision.DEFECT
                && opponentLastMoves[opponentLastMoves.length - 2] == Decision.DEFECT
        ) {
            return Decision.DEFECT;
        }
        return Decision.COOPERATE;
    }
}
