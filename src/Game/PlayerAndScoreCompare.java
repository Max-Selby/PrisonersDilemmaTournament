package Game;

public class PlayerAndScoreCompare implements Comparable {

    private String name;
    private int score;

    public PlayerAndScoreCompare(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public int compareTo(Object o) {
        if (!(o instanceof PlayerAndScoreCompare)) {
            throw new ClassCastException("Can't compare");
        }

        return this.score - ((PlayerAndScoreCompare) o).getScore();
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}
