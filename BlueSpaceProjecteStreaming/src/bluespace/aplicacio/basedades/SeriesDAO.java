package bluespace.aplicacio.basedades;

import bluespace.aplicacio.model.Series;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeriesDAO {

    public Series consultaSerieBD(int id) {

        Connection con = Connexio.getConection();

        Series s = null;

        String sentenciaSql = "SELECT s.id_produccio, produccions.nom, any_produccio, nacionalitat, favorit, COUNT(e.id_produccio) AS numcapitols, SUM(e.durada) AS duradatotal FROM produccions INNER JOIN series AS s ON s.id_produccio = produccions.id_produccio INNER JOIN episodi e ON s.id_produccio = e.id_produccio WHERE s.id_produccio = ? AND s.id_produccio = e.id_produccio";

        try ( PreparedStatement ps = con.prepareStatement(sentenciaSql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                s = dadesBDSerie(id,rs);

            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return s;
    }

    private Series dadesBDSerie(int id, ResultSet rs) throws SQLException {
        
        Series s = new Series();
        
        s.setNom(rs.getString("nom"));
        s.setAny(rs.getInt("any_produccio"));
        s.setNacionalitat(rs.getString("nacionalitat"));
        s.setFavorit(rs.getInt("favorit"));
        s.setDuradaTotal(rs.getDouble("duradatotal"));
        s.setNumCapitols(rs.getInt("numcapitols"));

        s.afegirCategoria(obtenirCategoria(id));
        s.afegirDirector(obtenirDirector(id));
        s.afegirActor(obtenirActor(id));

        return s;
    }
    
    private String obtenirCategoria(int idProduccio) {

        Connection con = Connexio.getConection();

        String categoria = " ";

        String sentenciaSql = "SELECT g.nom FROM genere AS g "
                            + "INNER JOIN pertany AS p ON g.id_categoria = p.id_categoria "
                            + "WHERE g.id_categoria = ? AND g.id_categoria = p.id_categoria";

        try ( PreparedStatement ps = con.prepareStatement(sentenciaSql)) {

            ps.setInt(1, idProduccio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getString("nom");

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return categoria;
    }

    private String obtenirDirector(int idProduccio) {

        Connection con = Connexio.getConection();

        String director = " ";

        String sentenciaSql = "SELECT d.nomdirector FROM director AS d "
                            + "INNER JOIN dirigeix_episodi AS de ON d.id_director = de.id_director "
                            + "WHERE de.id_director = ? AND de.id_director = d.id_director";

        try ( PreparedStatement ps = con.prepareStatement(sentenciaSql)) {

            ps.setInt(1, idProduccio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getString("nomdirector");

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return director;
    }
    
    private String obtenirActor(int idProduccio) {

        Connection con = Connexio.getConection();

        String actor = " ";

        String sentenciaSql = "SELECT a.nomactor FROM actors AS a "
                            + "INNER JOIN actuen AS at ON a.id_actor = at.id_actor "
                            + "WHERE at.id_actor = ? AND at.id_actor = a.id_actor";

        try ( PreparedStatement ps = con.prepareStatement(sentenciaSql)) {

            ps.setInt(1, idProduccio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getString("nomactor");

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return actor;
    }

}
