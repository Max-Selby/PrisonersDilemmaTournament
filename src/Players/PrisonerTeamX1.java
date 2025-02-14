package Players;

import Game.Decision;

public class PrisonerTeamX1 implements Prisoner {
    private final String name;

    public PrisonerTeamX1() {
        this.name = "Teamers: Booster";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        if (opponentLastMoves.length < 6) {
            return Decision.DEFECT;
        }

        if (
                opponentLastMoves[0] == Decision.DEFECT &&
                opponentLastMoves[1] == Decision.DEFECT &&
                opponentLastMoves[2] == Decision.DEFECT &&
                opponentLastMoves[3] == Decision.COOPERATE &&
                opponentLastMoves[4] == Decision.COOPERATE &&
                opponentLastMoves[5] == Decision.DEFECT
        ) {
            return Decision.COOPERATE;
        }
        return Decision.DEFECT;
    }
}
