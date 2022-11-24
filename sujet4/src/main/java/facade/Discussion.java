package facade;

import java.util.ArrayList;
import java.util.List;

public class Discussion {
    private Personne initiateur;
    private Personne invite;
    private List<Message> messages;

    public Discussion(Personne initiateur, Personne invite) {
        this.initiateur = initiateur;
        this.invite = invite;

        this.messages = new ArrayList<>();
    }

    public void ajouterMessage(Personne envoyeur,String contenu) {
        Message message = new Message(envoyeur,contenu);
        this.messages.add(message);

    }

    public List<Message> getMessages() {
        return messages;
    }

    public Personne getInitiateur() {
        return initiateur;
    }

    public Personne getInvite() {
        return invite;
    }
}
