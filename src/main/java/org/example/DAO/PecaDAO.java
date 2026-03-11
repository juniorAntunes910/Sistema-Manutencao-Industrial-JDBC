package org.example.DAO;

import org.example.Entity.Pecas;
import org.example.conection.db.ConectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO {

    public void cadastrarPeca(Pecas peca){
        try(Connection conn = ConectionDB.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO peca (nome, estoque) 
                    VALUES(?,?)
                    """);
            stmt.setString(1, peca.getNome());
            stmt.setDouble(2, peca.getEstoque());
            stmt.executeUpdate();
            System.out.println("Peça cadastrada ao banco de dados");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }








    public ArrayList<String> listaNomes(){
        try (Connection conn = ConectionDB.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    Select nome, estoque FROM peca
                    """);
            ResultSet rs = stmt.executeQuery();
            ArrayList<String> listaNomes = new ArrayList<>();
            while(rs.next()){
                listaNomes.add(rs.getString("nome"));
            }
            return listaNomes;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
