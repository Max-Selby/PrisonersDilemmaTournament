import Game.Game;
import Game.Tournament;
import Players.*;

public class Main {
    public static void main(String[] args) {
        Prisoner[] prisoners = new Prisoner[] {
            new PrisonerAlwaysDefect(),
            new PrisonerAlwaysCooperate(),
            new PrisonerTitForTat(),
            new PrisonerRandom(),
            new PrisonerForgivingTitForTat(),
            new PrisonerAlternator(),
            new PrisonerTitForTwoTats(),
            new PrisonerGary(),
            new PrisonerTitForNotTat(),
            new PrisonerTeamX1(),
            new PrisonerTeamX2()
        };
        Tournament tournament = new Tournament(prisoners);
        try {
            tournament.run();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
