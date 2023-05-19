package bluespace.aplicacio.basedades;

import bluespace.aplicacio.model.Compte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompteDAO {

    /*public ArrayList<Compte> obtenirComptesModalitatBD(int modalitat) {
        Connection con = Connexio.getConection();
        
        ArrayList<Compte> c = new ArrayList();

        String sentenciaSql = "SELECT * FROM compte AS"
                + "WHERE s.id_compte = ? AND s.id_produccio = e.id_produccio";

        try (PreparedStatement ps = con.prepareStatement(sentenciaSql)) {

            ps.setInt(1, modalitat);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                c = c.add(dadesBDCompte(rs));

            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return c;
    }
    
    private Compte dadesBDCompte(ResultSet rs) throws SQLException {
        Compte c = new Compte();
        
        c.setIdCompte(rs.getInt("idCompte"));
        c.setUsuari(rs.getString("usuari"));
        c.setContrasenya(rs.getString("contrasenya"));
        c.setDataAlta(rs.setDataAlta());
        c.setIdClient(rs.getInt("idClient"));
        c.setEmail(rs.getString("email"));
        c.setNomCli(rs.getString("nom"));
        c.setIdModalitat(rs.getInt("idModalitat"));
        
        return c;
    }
    
    private void dadesCompteBD(PreparedStatement ps, Compte c) throws SQLException {
        
        ps.setInt(1, c.getIdCompte());
        ps.setString(2, c.getUsuari());
        ps.setString(3, c.getContrasenya());
        ps.setDate(4, c.getDataAlta());
        ps.setInt(5, c.getIdClient());
        ps.setString(6, c.getEmail());
        ps.setString(7, c.getNomCli());
        ps.setInt(6, c.getIdModalitat());
        
        
    }*/

}
