package modeleTicTacToe;

public class ProgrammePrincipal {


    public static void main(String[] args) throws PasDeVainqueurException, PartieTermineeException, CaseNonValideException, CoupDejaJoueException {

        FacadeTicTacToe facadeTicTacToe = new FacadeTicTacToeImpl();

        try {
            facadeTicTacToe.creerPartie("j1","j2");
        } catch (NomsIdentiquesException e) {
            e.printStackTrace();
        }

        facadeTicTacToe.jouer(1,1);
        facadeTicTacToe.jouer(1,2);
        facadeTicTacToe.jouer(0,2);
        facadeTicTacToe.jouer(2,0);
        facadeTicTacToe.jouer(0,1);
        facadeTicTacToe.jouer(2,1);
        facadeTicTacToe.jouer(0,0);


        if ("j1".equals(facadeTicTacToe.getVainqueur())) {
            System.out.println("Visiblement ça marche !!!");
        };





    }
}
