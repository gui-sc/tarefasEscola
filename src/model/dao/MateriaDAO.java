/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.ConnectionFactory;
import model.bean.Materia;

/**
 *
 * @author Guilherme
 */
public class MateriaDAO {
    public List<Materia> listar(){
        List<Materia> materias = new ArrayList<>();
        Connection conn;
        try{
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM materias");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setNome(rs.getString("nome"));
                materias.add(materia);
            }
            conn.close();
            return materias;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    public Materia buscar(int id){
        Connection conn;
        try{
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM materias"
                    + " WHERE id = ?");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setNome(rs.getString("nome"));
                return materia;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
