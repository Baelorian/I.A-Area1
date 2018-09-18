/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ia.view;

import br.com.ia.search.BuscaEmLargura;
import br.com.ia.search.BuscaEmProfundidade;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author oberdan.pinheiro
 */
public class MainViewProfundidade extends JFrame {

    public static void setCellsAlignment(JTable table, int alignment) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    public static void main(String[] args) {

        BuscaEmProfundidade busca = new BuscaEmProfundidade();        

        JFrame frame = new JFrame("Busca em Profundidade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTable table = new JTable(busca.M, busca.N) {
            public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {
                Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
                switch (busca.MAPA[rowIndex][vColIndex]) {
                    case 2:
                        c.setBackground(Color.RED);
                        break;
                    case 0:
                        c.setBackground(Color.GREEN);
                        break;
                    case 3:
                        c.setBackground(Color.BLACK);
                        break;
                    default:
                        c.setBackground(getBackground());
                        break;
                }
                return c;
            }
        };

        JButton btn = new JButton("OK");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String param[] = busca.solver();
                if(param[0].equals("-1")){
                     JOptionPane.showMessageDialog(null,"Custo total: "+param[1]);
                     btn.setEnabled(false);
                }else{
                    int l = Integer.parseInt(param[0]);
                    int c = Integer.parseInt(param[1]);
                    table.setValueAt(l + ":" + c, l, c);
                }
                table.repaint();
            }
        });

        int c;

        for (c = 0; c < busca.M; c++) {
            table.getColumnModel().getColumn(c).setHeaderValue("");
        }

        setCellsAlignment(table, SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.add(btn, BorderLayout.SOUTH);

        frame.setSize(300, 150);
        frame.setVisible(true);

    }

}
