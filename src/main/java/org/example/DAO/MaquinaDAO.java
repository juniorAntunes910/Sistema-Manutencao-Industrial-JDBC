package org.example.DAO;

import org.example.DTO.MaquinaDTO;
import org.example.Entity.Maquina;
import org.example.conection.db.ConectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaquinaDAO {
    public void cadastrarMaquina(Maquina maquinas){
        try(Connection conn = ConectionDB.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO maquina (nome, setor, status)
                    VALUES (?,?,?)
                    """);
            stmt.setString(1, maquinas.getNome());
            stmt.setString(2, maquinas.getSetor());
            stmt.setString(3, maquinas.getStatus());
            stmt.executeUpdate();
            System.out.println("Maquina adicionada com sucesso ao banco de dados!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<MaquinaDTO> retornaMaquinaNome(){
        try(Connection conn = ConectionDB.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT nome, setor FROM maquina;
                    """);
            ResultSet rs = stmt.executeQuery();
            ArrayList<MaquinaDTO> listaMaquinaDTO = new ArrayList<>();
            while (rs.next()){
                listaMaquinaDTO.add(new MaquinaDTO(
                        rs.getString("nome"), rs.getString("setor")
                ));
            }
            return listaMaquinaDTO;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Maquina> retornaMaquinaOperacao(){
        try (Connection conn = ConectionDB.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
             SELECT id, nome, setor, status FROM maquina
        """);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
