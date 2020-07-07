/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Guilherme
 */
public class Materia {
    private int id;
    private String nome;
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
