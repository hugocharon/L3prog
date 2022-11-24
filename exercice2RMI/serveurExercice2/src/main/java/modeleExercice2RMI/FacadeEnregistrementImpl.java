package modeleExercice2RMI;

import dto.ParametresIncorrectsException;
import dto.PseudoDejaPrisException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.sql.*;

public class FacadeEnregistrementImpl implements FacadeEnregistrement{

    private Map<String,Utilisateur> utilisateursInscrits;
    private Connection connection;


    public FacadeEnregistrementImpl() {
        this.utilisateursInscrits = new HashMap<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdraymond", "raymond", "pwraymond");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inscription(String pseudo, String mdp) throws PseudoDejaPrisException, ParametresIncorrectsException {

        if (Objects.isNull(pseudo) || Objects.isNull(mdp) || pseudo.isBlank() || mdp.isBlank()) {
            throw new ParametresIncorrectsException();
        }
        if (utilisateursInscrits.containsKey(pseudo)) {
            throw new PseudoDejaPrisException();
        }
        this.utilisateursInscrits.put(pseudo,new Utilisateur(pseudo,mdp));

    }

    public void inscription2(String pseudo, String mdp) throws PseudoDejaPrisException, ParametresIncorrectsException {
        PreparedStatement ps = null;
        if (Objects.isNull(pseudo) || Objects.isNull(mdp) || pseudo.isBlank() || mdp.isBlank()) {
            throw new ParametresIncorrectsException();
        }
        if (utilisateursInscrits.containsKey(pseudo)) {
            throw new PseudoDejaPrisException();
        }
        try {
            ps = connection.prepareStatement("insert into Utilisateur values(?, ?)");
            ps.setString(1, pseudo);
            ps.setString(2, mdp);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Utilisateur> getPersonnesInscrites() {
        return utilisateursInscrits.values();
    }
}
