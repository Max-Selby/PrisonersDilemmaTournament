package Players;

import Game.Decision;

public class PrisonerTeamX2 implements Prisoner {
    private final String name;

    public PrisonerTeamX2() {
        this.name = "Teamers: Boosted";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves) {
        switch (opponentLastMoves.length) {
            case 0:
                return Decision.DEFECT;
            case 1:
                return Decision.DEFECT;
            case 2:
                return Decision.DEFECT;
            case 3:
                return Decision.COOPERATE;
            case 4:
                return Decision.COOPERATE;
            case 5:
                return Decision.DEFECT;
            default :
                break;
        }

        return Decision.DEFECT;
    }
}
