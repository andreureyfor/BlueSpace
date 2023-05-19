package bluespace.aplicacio.basedades;

import bluespace.aplicacio.model.Produccions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class ProduccionsDAO {

    public Produccions consultaProduccioBD(int Id) {

        Connection con = Connexio.getConection();

        Produccions produccio = null;

        String sentenciaSql = "SELECT id_produccio, nom, nacionalitat, any_produccio, favorit "
                + "FROM produccions WHERE id_produccio = ?";

        try ( PreparedStatement ps = con.prepareStatement(sentenciaSql)) {
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produccio = dadesBDProduccio(rs);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return produccio;

    }
    
    public void altaProduccioBD(Produccions p){}
    
    public void modificaProduccioBD(Produccions p){}
    
    public void baixaProduccioBD(Produccions p){}
    
    public Collection<Produccions> obtenirTotesProduccionsBD(){
        return null;
    }
    
    private Produccions dadesBDProduccio(ResultSet rs) throws SQLException {
        Produccions p = new Produccions();
        
        p.setId(rs.getInt("id_produccio"));
        p.setNom(rs.getString("nom"));
        p.setAny(rs.getInt("any_produccio"));
        p.setNacionalitat(rs.getString("nacionalitat"));
        p.setFavorit(rs.getInt("favorit"));
        
        return p;
    }
    
    private void dadesProduccioBD(PreparedStatement ps, Produccions p) throws SQLException {
        
        ps.setInt(1, p.getId());
        ps.setString(2, p.getNom());
        ps.setString(3, p.getNacionalitat());
        ps.setInt(4, p.getAny());
        ps.setInt(5, p.getFavorit());
    }

}
