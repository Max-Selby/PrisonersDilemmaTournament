# Prisoner's Dilemma Tournament Runner
This program runs a tournament of the Iterated Prisoner's Dilemma.
It is based on Axelrod's tournament and uses the same rules.

On each round of the Iterated Prisoner's Dilemma, contestants choose to either Cooperate or Defect.
If both cooperate, they both gain 3 points. If only one defects, the defector gains 5 points while the cooperator gains 0. If both defect, both gain 1 point.
Each match lasts 100 rounds, and every strategy in the tournament competes against every other strategy.
In the end, all the points are added up, and the strategy which gained the most total points wins.

Additional strategies can be added to the src/Players/ folder. These strategies should follow the src/Players/Prisoner.java interface, and must also be initialized in the array in the src/Main.java file.
There are several simple strategies already implemented.

This program produces a lot of output. This is so you can see the results of each game, as well as the leaderboard at the end.
