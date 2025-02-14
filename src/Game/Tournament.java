package Game;

import Players.Prisoner;
import Game.Game;

import java.util.*;

public class Tournament {
    private final Prisoner[] prisoners;

    public Tournament(Prisoner[] prisoners) throws IllegalArgumentException {
        for (Prisoner prisoner : prisoners) {
            for (Prisoner prisoner2 : prisoners) {
                if (!prisoner.equals(prisoner2) && prisoner.getName().equals(prisoner2.getName())) {
                    throw new IllegalArgumentException(
                            "Two prisoners cannot have the same name (" + prisoner.getName() + ")."
                    );
                }
            }
        }

        this.prisoners = prisoners;
    }

    private void welcomeMessage() {
        System.out.println("""
                Welcome to the tournament!\

                Today's contestants are:""");
        for (Prisoner p : prisoners) {
            System.out.println("- "+ p.getName());
        }
        System.out.println("Ready to start the tournament? Press enter.");
    }

    private void awaitEnter() {
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    private List<Prisoner[]> getMatchups() {
        List<Prisoner[]> matchups = new ArrayList<>();
        List<String> done = new ArrayList<>();

        for (Prisoner p1 : this.prisoners) {
            for (Prisoner p2 : this.prisoners) {
                if (!p1.equals(p2) && !done.contains(p1.getName() + p2.getName())) {
                    done.add(p1.getName() + p2.getName());
                    done.add(p2.getName() + p1.getName());

                    matchups.add(new Prisoner[] { p1, p2 });
                }
            }
        }

        return matchups;
    }

    private String getStrEnding(int i) {
        String ending = "";
        if (String.valueOf(i).endsWith("1") && (i != 11)) {
            ending = "st";
        }
        else if (String.valueOf(i).endsWith("2") && (i != 12)) {
            ending = "nd";
        }
        else if (String.valueOf(i).endsWith("3") && (i != 13)) {
            ending = "rd";
        }
        else {
            ending = "th";
        }
        return ending;
    }

    public void run() throws IllegalArgumentException {
        welcomeMessage();

        awaitEnter();

        List<Prisoner[]> matchups = getMatchups();

        Random rand = new Random();

        Map<String, Integer> points = new HashMap<String, Integer>();

        while (!matchups.isEmpty()) {
            Prisoner[] thisMatchup = matchups.get(rand.nextInt(matchups.size()));
            matchups.remove(thisMatchup);

            Game game = new Game(thisMatchup[0], thisMatchup[1]);

            game.run(100);

            if (points.containsKey(thisMatchup[0].getName())) {
                points.put(thisMatchup[0].getName(), points.get(thisMatchup[0].getName())
                        + game.getScore(thisMatchup[0]));
            }
            else {
                points.put(thisMatchup[0].getName(), game.getScore(thisMatchup[0]));
            }

            if (points.containsKey(thisMatchup[1].getName())) {
                points.put(thisMatchup[1].getName(), points.get(thisMatchup[1].getName())
                        + game.getScore(thisMatchup[1]));
            }
            else {
                points.put(thisMatchup[1].getName(), game.getScore(thisMatchup[1]));
            }

        }

        PlayerAndScoreCompare[] topPlayers = new PlayerAndScoreCompare[points.size()];

        int i = 0;
        for (String name : points.keySet()) {
            topPlayers[i] = new PlayerAndScoreCompare(name, points.get(name));
            i++;
        }

        Arrays.sort(topPlayers, Collections.reverseOrder());

        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("Congratulations to " + topPlayers[0].getName() + " for winning the tournament!!");

        int j = 1;
        for (PlayerAndScoreCompare p : topPlayers) {
            System.out.println(String.valueOf(j) + getStrEnding(j) + " place: " + p.getName()
                    + " with " + p.getScore() + " points.");
            j++;
        }
    }
}
