/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author Guilherme
 */
public class Tarefa {

    private int id;
    private Materia materia;
    private String data;
    private String descricao;

    public void setId(int id) {
        this.id = id;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }
    
    public Materia getMateria(){
        return materia;
    }
    
    public String getData(){
        return data;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
}
