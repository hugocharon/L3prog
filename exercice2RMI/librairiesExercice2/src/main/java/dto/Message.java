package dto;

import java.io.Serializable;

public class Message implements Serializable {


    private String contenu;

    public Message(String contenu) {
        this.contenu = contenu;
    }

    public Message() {
    }


    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


}
