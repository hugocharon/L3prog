package modeleTicTacToeOnline;


public class ProgrammePrincipal {


    public static void main(String[] args) throws PasDeVainqueurException, PartieTermineeException, CaseNonValideException, CoupDejaJoueException, PartieInconnueException, InviteInnattenduException, NomsIdentiquesException, PasTonTourException {

        FacadeTicTacToeOnLine facadeTicTacToe = new FacadeTicTacToeOnLineImpl();

        String identifiantPartie = facadeTicTacToe.creerPartie("j1","j2");
        facadeTicTacToe.rejoindrePartie("j2",identifiantPartie);

        facadeTicTacToe.jouer(identifiantPartie,"j1",1,1);
        facadeTicTacToe.jouer(identifiantPartie,"j2",0,1);
        facadeTicTacToe.jouer(identifiantPartie,"j1",0,2);
        facadeTicTacToe.jouer(identifiantPartie,"j2",2,0);
        facadeTicTacToe.jouer(identifiantPartie,"j1",1,2);
        facadeTicTacToe.jouer(identifiantPartie,"j2",1,0);
        facadeTicTacToe.jouer(identifiantPartie,"j1",2,2);


        System.out.println(facadeTicTacToe.partieTerminee(identifiantPartie));

        if ("j1".equals(facadeTicTacToe.getVainqueur(identifiantPartie))) {
            System.out.println("Visiblement ça marche !!!");
        };





    }
}
