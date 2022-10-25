public class TennisMatchSimple {

    private static String playerA;
    private static String playerB;

    private static String player;

    private static String winner;
    private static String advantage;
    private static String message;


    TennisMatchSimple() {
        playerA = "0";
        playerB = "0";
        winner = "";
        advantage = "";
        message = "";
        player = "";
    }

    public static void main(String[] args) {
        String message = "";
        TennisMatchSimple tennisMatchSimple = new TennisMatchSimple();
        // message = tennisMatchSimple.getScore("A");
        // tennisMatchSimple = new TennisMatchSimple();
        // message = tennisMatchSimple.getScore("AB");
        // tennisMatchSimple = new TennisMatchSimple();
        // message = tennisMatchSimple.getScore("ABAA");
        // tennisMatchSimple = new TennisMatchSimple();
        message = tennisMatchSimple.getScore("ABABABAA");
    }

    public String getScore(String cmds) {
        for (int i = 0; i < cmds.length(); i++) {
            String cmd = String.valueOf(cmds.charAt(i));
            checkWinner(cmd);
            if (winner.isEmpty()) {
                handlesScore(cmd);
                updateMessage();
            } else {
                updateMessage();
                break;
            }
        }
        return message;
    }

    private static void handlesScore(String cmd) {
        if (cmd.equals("A") && Integer.parseInt(playerA) < 40) {
            playerA = calculate(playerA);
        }
        if (cmd.equals("B") && Integer.parseInt(playerB) < 40) {
            playerB = calculate(playerB);
        }
    }

    private static void updateMessage() {
        if (!winner.isEmpty()) {
            message += "Player " + winner + " wins the game";
            System.out.println("Player " + winner + " wins the game");
        } else {
            System.out.println("Player A : " + playerA + " / Player B : " + playerB);
            message += "Player A : " + playerA + " / Player B : " + playerB + "\n";
        }
    }


    private static void checkWinner(String lastCmd) {
        if ((playerA.equals("40") && playerB.equals("40"))) {
            if (advantage.equals(lastCmd)) {
                winner = lastCmd;
            } else {
                advantage = lastCmd;
            }
        } else if (playerA.equals("40")) {
            winner = "A";
        } else if (playerB.equals("40")) {
            winner = "B";
        }
    }

    private static String calculate(String score) {
        switch (score) {
            case "0":
                return "15";
            case "15":
                return "30";
            case "30":
                return "40";
            case "40":
                return "40";
        }
        return "";
    }

}
