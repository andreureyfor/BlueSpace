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

        String sentenciaSql = "SELECT COUNT(e.id_produccio) AS numcapitols, SUM(e.durada) AS duradatotal FROM series AS s "
                            + "INNER JOIN episodis e ON s.id_produccio = e.id_produccio "
                            + "WHERE s.id_produccio = ? AND s.id_produccio = e.id_produccio";

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
        s.setId(id);
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
                            + "INNER JOIN pertany_a AS pa ON g.id_categoria = pa.id_categoria"
                            + "WHERE g.id_categoria = ? AND g.id_categoria = pa.id_categoria";

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
                            + "INNER JOIN dirigeix_pelis AS dp ON d.id_director = dp.id_director "
                            + "WHERE dp.id_director = ? AND dp.id_director = d.id_director";

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

        String sentenciaSql = "SELECT a.nomactor FROM actor AS a "
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
