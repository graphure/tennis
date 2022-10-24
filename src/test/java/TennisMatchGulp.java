import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;

public class TennisMatchGulp {

    TennisMatch tennisMatch;

    String given;

    String actual;

    @Etantdonnéque("le démarrage du match")
    public void la_commande() {
        tennisMatch = new TennisMatch();
    }

    @Quand("j'entre la commande {word}")
    public void jentre_la_commande(String cmd) {
        actual = tennisMatch.getScore(cmd);
    }

    @Alors("le jeux affiche le message suivant : {string}")
    public void le_jeux_affiche_le_message_suivant(String expected) {
        Assert.assertEquals(actual, expected);
    }

}
