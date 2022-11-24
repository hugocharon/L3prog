package dto;

import java.io.Serializable;

public class UtilisateurDTO implements Serializable {


    private String pseudo;

    public UtilisateurDTO(String pseudo) {
        this.pseudo = pseudo;
    }


    public UtilisateurDTO() {
    }


    public String getPseudo() {
        return pseudo;
    }
}
