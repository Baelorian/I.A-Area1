/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ia.search;

import br.com.ia.model.No;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author oberdan.pinheiro
 */
public class BuscaEmLargura {

    private Queue<No> arvore = new LinkedList<No>();
    private List<String> lista = new LinkedList<String>();
    private No raiz = new No();
    private int custoTotal = 0;
    public static final int M = 5, N = 5;
    public static final int[][] MAPA = {{0, 1, 1, 1, 1},
                                        {1, 2, 2, 2, 1},
                                        {2, 1, 1, 1, 1},
                                        {2, 1, 1, 1, 1},
                                        {1, 1, 1, 3, 1}};

    public BuscaEmLargura() {
        initComponents();
    }

    private void initComponents() {
        raiz.setEstado("3:3");
        raiz.setCusto(0);
        lista.add("3:3");
        arvore.add(raiz);
    }

    public String[] solver() {
        String param[] = new String[2];
        int l;
        int c;        
        
        if (!arvore.isEmpty()) {
            No no = arvore.remove();
            custoTotal++;
            param = no.getEstado().split(":");
            l = Integer.parseInt(param[0]);
            c = Integer.parseInt(param[1]);

            if (no.getPai() != null) {
                System.out.print("[" + no.getPai().getEstado() + "]");
            }
            System.out.println("[" + no.getEstado() + "]");

            if (MAPA[l][c] == 0) {
                System.out.println("goal");
                No aux = no.getPai();                
                while (aux != null) {
                    System.out.println("[" + aux.getEstado() + "]");
                    aux = aux.getPai();
                }   
                arvore.clear();
                param[0] = "-1";
                param[1] = ""+custoTotal;
            } else {

                // analisa CIMA
                if ((l - 1) >= 0 && (l - 1) < M && MAPA[l - 1][c] != 2) {
                    if (!lista.contains((l - 1) + ":" + c)) {
                        No cima = new No();
                        cima.setAcao(No.MOVER_CIMA);
                        cima.setCusto(no.getCusto() + 1);
                        cima.setEstado((l - 1) + ":" + c);
                        cima.setPai(no);
                        arvore.add(cima);
                        lista.add(cima.getEstado());
                    }
                }

                // analisa ESQUERDA
                if ((c - 1) >= 0 && (c - 1) < N && MAPA[l][c - 1] != 2) {
                    if (!lista.contains(l + ":" + (c - 1))) {
                        No esquerda = new No();
                        esquerda.setAcao(No.MOVER_ESQUERDA);
                        esquerda.setCusto(no.getCusto() + 1);
                        esquerda.setEstado(l + ":" + (c - 1));
                        esquerda.setPai(no);
                        arvore.add(esquerda);
                        lista.add(esquerda.getEstado());
                    }
                }

                // analisa DIREITA
                if ((c + 1) < N && MAPA[l][c + 1] != 2) {
                    if (!lista.contains(l + ":" + (c + 1))) {
                        No direita = new No();
                        direita.setAcao(No.MOVER_DIREITA);
                        direita.setCusto(no.getCusto() + 1);
                        direita.setEstado(l + ":" + (c + 1));
                        direita.setPai(no);
                        arvore.add(direita);
                        lista.add(direita.getEstado());
                    }
                }

                // analisa BAIXO
                if ((l + 1) < M && MAPA[l + 1][c] != 2) {
                    if (!lista.contains((l + 1) + ":" + c)) {
                        No baixo = new No();
                        baixo.setAcao(No.MOVER_BAIXO);
                        baixo.setCusto(no.getCusto() + 1);
                        baixo.setEstado((l + 1) + ":" + c);
                        baixo.setPai(no);
                        arvore.add(baixo);
                        lista.add(baixo.getEstado());
                    }
                }
            }
        }
        
        return param;
    }        

}
