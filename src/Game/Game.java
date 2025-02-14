package Game;

import Players.Prisoner;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Prisoner prisoner1;
    private final Prisoner prisoner2;
    private int scoreP1;
    private int scoreP2;

    public Game(Prisoner prisoner1, Prisoner prisoner2) {
        this.prisoner1 = prisoner1;
        this.prisoner2 = prisoner2;
        this.scoreP1 = 0;
        this.scoreP2 = 0;
    }

    public void run(int iterations) {
        List<Decision> prisoner1LastMoves = new ArrayList<Decision>();
        List<Decision> prisoner2LastMoves = new ArrayList<Decision>();

        String tourneyTitle = this.prisoner1.getName() + "  VS  " + this.prisoner2.getName();
        System.out.println("=".repeat(tourneyTitle.length()));
        System.out.println("GAME BEGINS!!");
        System.out.println(tourneyTitle);
        System.out.println("=".repeat(tourneyTitle.length()));
        System.out.println("round   " + formTo(this.prisoner1.getName(), 25) + this.prisoner2.getName());

        for (int i = 0; i < iterations; i++) {
            Decision[] p1LastArray = prisoner1LastMoves.toArray(new Decision[0]);
            Decision[] p2LastArray = prisoner2LastMoves.toArray(new Decision[0]);

            Decision p1Decision = this.prisoner1.play(p2LastArray, p1LastArray);
            Decision p2Decision = this.prisoner2.play(p1LastArray, p2LastArray);

            prisoner1LastMoves.add(p1Decision);
            prisoner2LastMoves.add(p2Decision);

            int p1PointsThisRound;
            int p2PointsThisRound;

            if (p1Decision == Decision.DEFECT) {
                if (p2Decision == Decision.DEFECT) {
                    p1PointsThisRound = 1;
                    p2PointsThisRound = 1;
                }
                else {
                    p1PointsThisRound = 5;
                    p2PointsThisRound = 0;
                }
            }
            else {
                if (p2Decision == Decision.DEFECT) {
                    p1PointsThisRound = 0;
                    p2PointsThisRound = 5;
                }
                else {
                    p1PointsThisRound = 3;
                    p2PointsThisRound = 3;
                }
            }

            // Example:
            // 4       DEFECT 5                 COOPERATE 0
            System.out.println(
                    formTo(String.valueOf(i + 1), 8)
                    + formTo(String.valueOf(p1Decision) + " " + String.valueOf(p1PointsThisRound), 25)
                    + String.valueOf(p2Decision) + " " + String.valueOf(p2PointsThisRound)
            );

            this.scoreP1 += p1PointsThisRound;
            this.scoreP2 += p2PointsThisRound;
        }

        System.out.println("=".repeat(tourneyTitle.length()));
        System.out.println("GOOD GAME!");
        System.out.println(this.prisoner1.getName() + " earned " + scoreP1 + " points in this game.");
        System.out.println(this.prisoner2.getName() + " earned " + scoreP2 + " points in this game.");
        System.out.println("=".repeat(tourneyTitle.length()));
    }

    private String formTo(String str, int len) throws IllegalArgumentException {
        if (str.length() > len) {
            throw new IllegalArgumentException("formTo called where string was longer than length.");
        }

        return str + " ".repeat(len - str.length());
    }

    public int getScore(Prisoner prisoner) throws IllegalArgumentException {
        if (prisoner == prisoner1) {
            return this.scoreP1;
        }
        if (prisoner == prisoner2) {
            return this.scoreP2;
        }

        throw new IllegalArgumentException("Passed prisoner to getScore did not play in this game.");
    }
}
