package Draudimas;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuomenuBaze {

    Map<Integer, Integer> lx = new HashMap();                      // išgyvenusiųjų skaičius iš pradinės kohortos pagal amžių
    Map<Integer, Integer> lxMot = new HashMap();                  // išgyvenusių moterų skaičius iš pradinės kohortos pagal amžių
    Map<Integer, Integer> lxVyr = new HashMap();                  // išgyvenusių vyrų skaičius iš pradinės kohortos pagal amžių
    List<Integer> reikalingiLentelesDuomenys = new ArrayList();   //duomenys, kurių reikės pagal užpildytą formą

    public void paimtiIsDB(Forma forma) throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");

        Connection connection = null;

        try {

            //PRISIJUNGIAM PRIE DB IR ĮSIIMPORTUOJAM DUOMENIS

            connection = DriverManager.getConnection("jdbc:sqlite:MirtingumoLentelė.db");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from MirtingumoLentelė");

            while (rs.next()) {
                lx.put(rs.getInt("x"), rs.getInt("lx"));
                lxMot.put(rs.getInt("x"), rs.getInt("lx m"));
                lxVyr.put(rs.getInt("x"), rs.getInt("lx v"));
            }

            // IŠSIIMAM REIKALINGUS DUOMENIS PAGAL PASIRINKTĄ LYTĮ

            if (forma.getVyras().isSelected()) {
                for (int i = forma.kintamieji.getAmzius(); i <= forma.kintamieji.getAmzius() + forma.kintamieji.getn(); i++) {
                    reikalingiLentelesDuomenys.add(lxVyr.get(i));
                }
            }

            if (forma.getMoteris().isSelected()) {
                for (int i = forma.kintamieji.getAmzius(); i <= forma.kintamieji.getAmzius() + forma.kintamieji.getn(); i++) {
                    reikalingiLentelesDuomenys.add(lxMot.get(i));
                }
            }

            if (!forma.getMoteris().isSelected() && !forma.getVyras().isSelected()) {
                for (int i = forma.kintamieji.getAmzius(); i <= forma.kintamieji.getAmzius() + forma.kintamieji.getn(); i++) {
                    reikalingiLentelesDuomenys.add(lx.get(i));
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public double getDuomenis(int indeksas) {
        return (double) reikalingiLentelesDuomenys.get(indeksas);
    }
}
