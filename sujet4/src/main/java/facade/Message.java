package facade;

import java.time.LocalDateTime;

public class Message {

    private Personne createur;
    private String contenu;
    private LocalDateTime date;

    public Message(Personne createur, String contenu) {
        this.createur = createur;
        this.contenu = contenu;
        this.date = LocalDateTime.now();
    }

    public Personne getCreateur() {
        return createur;
    }

    public String getContenu() {
        return contenu;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
