package Players;

import Game.Decision;

public interface Prisoner {
    Decision play(Decision[] opponentLastMoves, Decision[] yourLastMoves);

    String getName();
}
