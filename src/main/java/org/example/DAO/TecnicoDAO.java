package org.example.DAO;

import org.example.Entity.Tecnicos;
import org.example.conection.db.ConectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TecnicoDAO {
    public void inserirTecnico(Tecnicos tecnicos){
        try(Connection conn = ConectionDB.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO tecnico (nome,especialidade)
                    VALUES (?,?) 
                    """);
            stmt.setString(1, tecnicos.getNome());
            stmt.setString(2, tecnicos.getEspecialidade());
            stmt.executeUpdate();
            System.out.println("Técnico adicionado ao banco de dados com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> listaNomes(){
        try(Connection conn = ConectionDB.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT nome FROM tecnico
                    """);
            ResultSet rs = stmt.executeQuery();
            ArrayList<String> listaNomes = new ArrayList<>();
            while (rs.next()){
                listaNomes.add(rs.getString("nome"));
            }
            return listaNomes;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
