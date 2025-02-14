package Players;

import Game.Decision;

public class PrisonerGary implements Prisoner {
    private final String name;

    public PrisonerGary() {
        this.name = "Gary";
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

        int coop = 0;
        int def = 0;
        for (Decision d : opponentLastMoves) {
            if (d == Decision.COOPERATE) {
                coop++;
            }
            else {
                def++;
            }
        }

        if (coop >= def) {
            return Decision.COOPERATE;
        }
        else {
            return Decision.DEFECT;
        }
    }
}
