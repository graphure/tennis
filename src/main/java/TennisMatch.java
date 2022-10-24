import java.util.*;
import java.util.function.Consumer;

public class TennisMatch {

    private Map<String, Integer> players;
    private String player;
    private String message;
    private String advantage;
    private String winner;

    TennisMatch() {
        players = new HashMap<>();
        players.put("A", 0);
        players.put("B", 0);
        message = "";
        player = "";
        advantage = "";
        winner = "";
    }

    public static void main(String[] args) {
        String message = "";
        TennisMatch tennisMatch = new TennisMatch();
        // message = tennisMatch.getScore("A");
        // tennisMatch = new TennisMatch();
        // message = tennisMatch.getScore("AB");
        // tennisMatch = new TennisMatch();
        // message = tennisMatch.getScore("ABAA");
        //    tennisMatch = new TennisMatch();
        tennisMatch.getScore("ABABABAA");
    }

    public String getScore(String cmds) {
        for (int i = 0; i < cmds.length(); i++) {
            String cmd = String.valueOf(cmds.charAt(i));
            handleMessage(cmd);
        }
        return message;
    }

    private void handleMessage(String lastCmd) {

        CmdStrategy.of(lastCmd).handleMessage(this);
    }

    private void updateMessage() {
        if (!winner.isEmpty()) {
            message += "Player " + winner + " wins the game";
            System.out.println("Player " + winner + " wins the game");
        } else {
            System.out.println("Player A : " + players.get("A") + " / Player B : " + players.get("B"));
            message += "Player A : " + players.get("A") + " / Player B : " + players.get("B") + "\n";
        }
    }

    private enum CmdStrategy {
        A("A", tennisMatch -> {
            tennisMatch.player = "A";
            ScoreStrategy
                    .of(tennisMatch.players.get(tennisMatch.player))
                    .calculateScore(tennisMatch);
        }),
        B("B", tennisMatch -> {
            tennisMatch.player = "B";
            ScoreStrategy
                    .of(tennisMatch.players.get(tennisMatch.player))
                    .calculateScore(tennisMatch);
        });


        private final String playerValue;

        private final Consumer<TennisMatch> tennisMatchConsumer;

        CmdStrategy(String playerValue, Consumer<TennisMatch> tennisMatchConsumer) {
            this.playerValue = playerValue;
            this.tennisMatchConsumer = tennisMatchConsumer;
        }

        public static CmdStrategy of(String cmdStrategyValue) {
            return Arrays.stream(values())
                    .filter(actualcmdStrategy ->
                            cmdStrategyValue
                                    .equals(actualcmdStrategy.playerValue))
                    .findFirst()
                    .orElseThrow();
        }


        public void handleMessage(TennisMatch tennisMatch) {

            this.tennisMatchConsumer.accept(tennisMatch);
        }
    }

    private enum ScoreStrategy {
        ZERO(0, tennisMatch -> {
            tennisMatch.players.replace(
                    tennisMatch.player, 0, 15
            );
            tennisMatch.updateMessage();
        }),
        QUINZE(15, tennisMatch -> {
            tennisMatch.players.replace(
                    tennisMatch.player, 15, 30
            );
            tennisMatch.updateMessage();
        }),
        TRENTE(30, tennisMatch -> {
            tennisMatch.players.replace(
                    tennisMatch.player, 30, 40
            );
            tennisMatch.updateMessage();
        }),
        QUARANTE(40, tennisMatch -> {
            boolean playersEquality = tennisMatch
                    .players
                    .values()
                    .stream()
                    .distinct()
                    .limit(2)
                    .count() < 2;
            if (playersEquality) {
                if (tennisMatch.player.equals(tennisMatch.advantage)) {
                    tennisMatch.winner = tennisMatch.player;
                } else {
                    tennisMatch.advantage = tennisMatch.player;
                }
            } else {
                tennisMatch.winner = tennisMatch.player;
            }
            tennisMatch.updateMessage();
        });
        private final int scoreValue;

        private final Consumer<TennisMatch> tennisMatchConsumer;

        ScoreStrategy(int scoreValue, Consumer<TennisMatch> tennisMatchConsumer) {
            this.scoreValue = scoreValue;
            this.tennisMatchConsumer = tennisMatchConsumer;
        }

        public static ScoreStrategy of(int score) {
            return Arrays.asList(values())
                    .stream()
                    .filter(scoreStrategy -> score == scoreStrategy.scoreValue)
                    .findFirst()
                    .orElseThrow();
        }

        public void calculateScore(TennisMatch tennisMatch) {
            tennisMatchConsumer.accept(tennisMatch);
        }

    }


}
