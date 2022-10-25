import org.testng.Assert;
import org.testng.annotations.Test;

public class TennisMatchSimpleTest {


    @Test
    public void if_A_then_playerA15_playerB0() {
        String given = "A";
        String expected = "Player A : 15 / Player B : 0\n";

        TennisMatchSimple tennisMatchSimple = new TennisMatchSimple();
        String actual = tennisMatchSimple.getScore(given);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void if_AB_then_playerA15_playerB15() {
        String given = "AB";
        String expected = "Player A : 15 / Player B : 0\nPlayer A : 15 / Player B : 15\n";
        TennisMatchSimple tennisMatchSimple = new TennisMatchSimple();
        String actual = tennisMatchSimple.getScore(given);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void if_ABAAA_then_playerA_wins() {
        String given = "ABAAA";
        String expected = "Player A : 15 / Player B : 0\n" +
                "Player A : 15 / Player B : 15\n" +
                "Player A : 30 / Player B : 15\n" +
                "Player A : 40 / Player B : 15\n" +
                "Player A wins the game";
        TennisMatchSimple tennisMatchSimple = new TennisMatchSimple();
        String actual = tennisMatchSimple.getScore(given);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void if_ABABABAA_then_playerA_wins() {
        String given = "ABABABAA";
        String expected = "Player A : 15 / Player B : 0\n" +
                "Player A : 15 / Player B : 15\n" +
                "Player A : 30 / Player B : 15\n" +
                "Player A : 30 / Player B : 30\n" +
                "Player A : 40 / Player B : 30\n" +
                "Player A wins the game";
        TennisMatchSimple tennisMatchSimple = new TennisMatchSimple();
        String actual = tennisMatchSimple.getScore(given);
        Assert.assertEquals(actual, expected);
    }


}
