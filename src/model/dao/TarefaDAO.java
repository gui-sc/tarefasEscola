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
import model.bean.Tarefa;

/**
 *
 * @author Guilherme
 */
public class TarefaDAO {
    
    public void remover(int id){
        Connection conn;
        try{
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE from tarefa"
                    + " WHERE id = ?");
            pstmt.setInt(1,id);
            pstmt.execute();
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void inserir(Tarefa tarefa) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tarefa (materia,data,descricao)"
                    + " VALUES (?,?,?)");
            pstmt.setInt(1, tarefa.getMateria().getId());
            pstmt.setString(2, tarefa.getData());
            pstmt.setString(3, tarefa.getDescricao());
            pstmt.execute();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Tarefa> listar() {
        Connection conn = null;
        List<Tarefa> tarefas = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM tarefa"
                    + " order by data");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MateriaDAO materiaDAO = new MateriaDAO();
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("id"));
                tarefa.setMateria(materiaDAO.buscar(rs.getInt("materia")));
                tarefa.setData(rs.getString("data"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefas.add(tarefa);
            }
            return tarefas;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
