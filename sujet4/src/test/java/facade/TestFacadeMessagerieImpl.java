package facade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFacadeMessagerieImpl {


    private FacadeMessagerieImpl instance;


    @Before
    public void initialisation() {
        instance = new FacadeMessagerieImpl();
    }


    @Test(expected = DonneesIncompletesException.class)
    public void testInscriptionKOPseudoNull() throws PseudoDejaPrisException, DonneesIncompletesException {
        instance.inscription(null,"mdp");
    }
    @Test(expected = DonneesIncompletesException.class)
    public void testInscriptionKOPseudoEmpty() throws PseudoDejaPrisException, DonneesIncompletesException {
        instance.inscription("    ","mdp");
    }

    @Test(expected = DonneesIncompletesException.class)
    public void testInscriptionKOMdpNull() throws PseudoDejaPrisException, DonneesIncompletesException {
        instance.inscription("yohan",null);
    }
    @Test(expected = DonneesIncompletesException.class)
    public void testInscriptionKOMdpEmpty() throws PseudoDejaPrisException, DonneesIncompletesException {
        instance.inscription("yohan","    ");
    }


    @Test(expected = PseudoDejaPrisException.class)
    public void testInscriptionKOPseudoDejaPris() throws PseudoDejaPrisException, DonneesIncompletesException {
        instance.inscription("yohan","mdp");

        instance.inscription("yohan","fjpai");
    }


    @Test
    public void testInscriptionOK() throws PseudoDejaPrisException, DonneesIncompletesException {
        instance.inscription("yohan","mdp");
        Assert.assertTrue(instance.personnes.containsKey("yohan"));

    }



}
