/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crisl
 */
public class CursoLista extends javax.swing.JFrame {

  
    
    public CursoLista() {
        initComponents();
        
       // popularTabelaComDados();
       atualizarTabelaComBanco();
        adicionarIconesNasColunas();
        adicionarListenerTabela();
        configurarRenderizadoresDeIcones();

    }
    
    public void atualizarTabelaComBanco() {
    DefaultTableModel modelo = (DefaultTableModel) tabCurso.getModel();
    modelo.setRowCount(0); // limpa a tabela

    br.com.ifba.dao.CursoDao dao = new br.com.ifba.dao.CursoDao();
    java.util.List<br.com.ifba.entity.Curso> cursos = dao.listarTodos();

    for (br.com.ifba.entity.Curso curso : cursos) {
        modelo.addRow(new Object[]{
            curso.getNome(),
            curso.getDuracao(),
            curso.getDescricao(),
            curso.getPlataforma(),
            new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/imagens/remover.png.png")),
            new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/imagens/editar.png.png"))
        });
    }
}

    /**
    // metados com tabelas reais
    private void popularTabelaComDados() {
        DefaultTableModel modelo = (DefaultTableModel) tabCurso.getModel();
        modelo.setRowCount(0); // limpa a tabela antes de adicionar
        
        // exemplo de dados reais
        Object[][] dados = {
            {"Java Básico", 30, "Curso introdutório de Java", "IFBA", null, null},
            {"Python Avançado", 25, "Curso avançado de Python", "Udemy", null, null},
            {"Banco de Dados", 20, "Curso de SQL e modelagem", "Coursera", null, null}
        };
        
        for (Object[] linha : dados) {
            modelo.addRow(linha);
        }
    }
    */
    
    
    // metados adicinado ns colunas remover e editar
    private void adicionarIconesNasColunas() {
        DefaultTableModel modelo = (DefaultTableModel) tabCurso.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(new ImageIcon(getClass().getResource("/br/com/ifba/imagens/remover.png.png")), i, 4);
            modelo.setValueAt(new ImageIcon(getClass().getResource("/br/com/ifba/imagens/editar.png.png")), i, 5);
        }
    }
    
    // metodo para adicionar listener que detecta clique nas colunas
    private void adicionarListenerTabela() {
        tabCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linha = tabCurso.rowAtPoint(evt.getPoint());
                int coluna = tabCurso.columnAtPoint(evt.getPoint());

                if (coluna == 4) { // REMOVER
                    int confirmacao = JOptionPane.showConfirmDialog(null, "deseja excluir esse curso?", "confirmacao", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        ((DefaultTableModel) tabCurso.getModel()).removeRow(linha);
                    }
                } else if (coluna == 5) { // EDITAR
                    
                    String nome = tabCurso.getValueAt(linha, 0).toString();
                    int  duracao = Integer.parseInt(tabCurso.getValueAt(linha, 1).toString());
                    String descricao = tabCurso.getValueAt(linha, 2).toString();
                    String plataforma = tabCurso.getValueAt(linha, 3).toString();
                    
                   EditarCurso telaEdicao = new EditarCurso(CursoLista.this, linha, nome, duracao, descricao, plataforma);
                   telaEdicao.setVisible(true);
                }
            }
        });
    
    }
    
    // metodo para configurar os icones nas coluna da tabela
    private void configurarRenderizadoresDeIcones() {
        
    // configurando a coluna de remover
    tabCurso.getColumnModel().getColumn(4).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public void setValue(Object value) {
            if (value instanceof ImageIcon imageIcon) {
                setIcon(imageIcon);
                setText("");
            } else {
                setIcon(null);
                setText("");
            }
        }
    });

    // configurando a coluna de editar
    tabCurso.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public void setValue(Object value) {
            if (value instanceof ImageIcon imageIcon) {
                setIcon(imageIcon);
                setText("");
            } else {
                setIcon(null);
                setText("");
            }
        }
    });
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelSuperior = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        txtButao = new javax.swing.JButton();
        lblHomemCrem = new javax.swing.JLabel();
        tabelaCurso = new javax.swing.JScrollPane();
        tabCurso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarCurso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Cursos");

        painelSuperior.setBackground(new java.awt.Color(153, 153, 255));

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        txtButao.setForeground(new java.awt.Color(0, 0, 0));
        txtButao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/imagens/pesquisa-de-lupa (1).png"))); // NOI18N
        txtButao.setText("PESQUISAR");
        txtButao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtButaoActionPerformed(evt);
            }
        });

        lblHomemCrem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/imagens/lista-de-controle (1).png"))); // NOI18N

        tabelaCurso.setBorder(new javax.swing.border.MatteBorder(null));

        tabCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CURSO", "DURACAO", "DESCRICAO", "PLATAFORMA", "REMOVER", "EDITAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCurso.setViewportView(tabCurso);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("LISTA DE CURSOS");

        btnAdicionarCurso.setText("Adicionar curso");
        btnAdicionarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(lblHomemCrem)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelSuperiorLayout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(btnAdicionarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtButao))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelSuperiorLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(tabelaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHomemCrem)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarCurso)
                    .addComponent(txtBuscar)
                    .addComponent(txtButao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabelaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // botao com os seus comandos
    private void txtButaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtButaoActionPerformed
        
    String textoBusca = txtBuscar.getText().toLowerCase(); // texto digitado na busca
    DefaultTableModel modelo = (DefaultTableModel) tabCurso.getModel();
    modelo.setRowCount(0); // limpa a tabela antes de filtrar

    // dados
    Object[][] dados = {
        {"Java Básico", 30, "Curso introdutório de Java", "IFBA"},
        {"Python Avançado", 25, "Curso avançado de Python", "Udemy"},
        {"Banco de Dados", 20, "Curso de SQL e modelagem", "Coursera"}
    };

    for (Object[] curso : dados) {
        String nomeCurso = curso[0].toString().toLowerCase();
        if (nomeCurso.contains(textoBusca)) {
            // adiciona novamente as colunas de remover e editar com null
            Object[] linhaComIcones = {
                curso[0], curso[1], curso[2], curso[3], null, null
            };
            modelo.addRow(linhaComIcones);
        }
    }

    // aecoloca os icones nas colunas
    adicionarIconesNasColunas();
    }//GEN-LAST:event_txtButaoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnAdicionarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCursoActionPerformed
       
          AddCurso addCurso = new AddCurso(this); // passa a tela atual como referência
    addCurso.setVisible(true);
    addCurso.setLocationRelativeTo(this); // centraliza
    }//GEN-LAST:event_btnAdicionarCursoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CursoLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CursoLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CursoLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CursoLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CursoLista().setVisible(true);
        });
    }
    
    
    // esse metado atualizara a tabela com as novas informacao
    public void atualizarCurso(int linha, String nome, int duracao, String descricao, String plataforma) {
    DefaultTableModel modelo = (DefaultTableModel) tabCurso.getModel();
    modelo.setValueAt(nome, linha, 0);
    modelo.setValueAt(duracao, linha, 1);
    modelo.setValueAt(descricao, linha, 2);
    modelo.setValueAt(plataforma, linha, 3);
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblHomemCrem;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JTable tabCurso;
    private javax.swing.JScrollPane tabelaCurso;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JButton txtButao;
    // End of variables declaration//GEN-END:variables

}
