/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ia.model;

/**
 *
 * @author oberdan.pinheiro
 */
public class No {
    
    public static final String MOVER_CIMA = "C";
    public static final String MOVER_BAIXO = "B";
    public static final String MOVER_ESQUERDA = "E";
    public static final String MOVER_DIREITA = "D";
    
    private String estado;
    private No pai;
    private String acao;
    private int custo;
    private boolean visitado = Boolean.FALSE;

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the pai
     */
    public No getPai() {
        return pai;
    }

    /**
     * @param pai the pai to set
     */
    public void setPai(No pai) {
        this.pai = pai;
    }

    /**
     * @return the acao
     */
    public String getAcao() {
        return acao;
    }

    /**
     * @param acao the acao to set
     */
    public void setAcao(String acao) {
        this.acao = acao;
    }

    /**
     * @return the custo
     */
    public int getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(int custo) {
        this.custo = custo;
    } 

    /**
     * @return the visitado
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     * @param visitado the visitado to set
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }   
    
}
