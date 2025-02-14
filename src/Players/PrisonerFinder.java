package Players;

import Game.Decision;

import java.util.Objects;

public class PrisonerFinder implements Prisoner {
    private final String name;
    private String mode;

    public PrisonerFinder() {
        this.name = "Finder";
        this.mode = "unclear";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        if (Objects.equals(this.mode, "unclear")) {
            if (opponentLastMoves.length == 0) {
                return Decision.DEFECT;
            }
            if (opponentLastMoves.length == 1) {
                if (opponentLastMoves[0] == Decision.DEFECT) {
                    return Decision.COOPERATE;
                }
                this.mode = "defect";
                return Decision.DEFECT;
            }
            if (opponentLastMoves[1] == Decision.DEFECT) {
                this.mode = "defect";
                return Decision.DEFECT;
            }
            this.mode = "cooperate";
            return Decision.COOPERATE;
        }

        else if (Objects.equals(this.mode, "defect")) {
            return Decision.DEFECT;
        }
        else {
            return Decision.COOPERATE;
        }
    }
}
