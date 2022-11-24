package facade;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Personne {

    private String pseudo;

    private String mdp;

    private Map<Personne,Discussion> discussions;


    public Personne(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.discussions = new HashMap<>();
    }

    public boolean checkMdp(String mdp) {
        return this.mdp.equals(mdp);
    }

    public String getPseudo() {
        return pseudo;
    }


    private Discussion getDiscussionByPersonne(Personne personne) throws DiscussionInexistanteException {

        Discussion discussion = this.discussions.get(personne);

        if (Objects.isNull(discussion)) {
            throw new DiscussionInexistanteException();
        }
        else
            return discussion;
    }

    public void creerDiscussion(Personne invite) throws DiscussionDejaExistanteException {

        try {
            Discussion discussion = this.getDiscussionByPersonne(invite);
            throw new DiscussionDejaExistanteException();

        } catch (DiscussionInexistanteException e) {
            Discussion discussion = new Discussion(this,invite);
            this.discussions.put(invite,discussion);
            invite.inviteDiscussion(this,discussion);

        }

    }

    public void inviteDiscussion(Personne initiateur, Discussion discussion) throws DiscussionDejaExistanteException {
        try {
            Discussion d = this.getDiscussionByPersonne(initiateur);
            throw new DiscussionDejaExistanteException();

        } catch (DiscussionInexistanteException e) {
            this.discussions.put(initiateur,discussion);
        }
    }


    public void envoyerMessage(Personne dest,String contenu ) throws DiscussionDejaExistanteException {
        try {
            Discussion discussion = this.getDiscussionByPersonne(dest);
            discussion.ajouterMessage(this,contenu);

        } catch (DiscussionInexistanteException e) {
            Discussion discussion = new Discussion(this,dest);
            discussion.ajouterMessage(this,contenu);
            this.discussions.put(dest,discussion);
            dest.inviteDiscussion(this,discussion);
        }

    }





}
