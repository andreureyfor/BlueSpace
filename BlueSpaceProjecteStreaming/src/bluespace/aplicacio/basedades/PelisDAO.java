package bluespace.aplicacio.basedades;

import bluespace.aplicacio.model.Pelis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PelisDAO {

    public Pelis consultaPeliculaBD(int id) {

        Connection con = Connexio.getConection();

        Pelis p = null;

        String sentenciaSql = "SELECT duracio FROM pelis WHERE id_produccio = ?";

        try ( PreparedStatement ps = con.prepareStatement(sentenciaSql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                p = dadesBDPelicula(id, rs.getDouble("duracio"));

            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return p;
    }

    private Pelis dadesBDPelicula(int id, double durada) {
        Pelis p = new Pelis();

        p.setDurada(durada);

        p.afegirCategoria(obtenirCategoria(id));
        p.afegirDirector(obtenirDirector(id));
        p.afegirActor(obtenirActor(id));

        return p;
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
