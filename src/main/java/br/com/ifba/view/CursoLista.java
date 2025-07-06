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

    /**
     * Creates new form Tela
     */
    public CursoLista() {
        initComponents();
        
        popularTabelaComDados();
        adicionarIconesNasColunas();
        adicionarListenerTabela();
        configurarRenderizadoresDeIcones();

    }
    
    // metados com tabelas reais
    private void popularTabelaComDados() {
        DefaultTableModel modelo = (DefaultTableModel) tabCurso.getModel();
        modelo.setRowCount(0); // limpa a tabela antes de adicionar
        
        // exemplo de dados reais
        Object[][] dados = {
    {"Java Básico", 30, "Curso introdutório de Java", "IFBA"},
    {"Python Avançado", 25, "Curso avançado de Python", "Udemy"},
    {"Banco de Dados", 20, "Curso de SQL e modelagem", "Coursera"},
    {"Desenvolvimento Web", 40, "HTML, CSS e JavaScript", "Alura"},
    {"Estrutura de Dados", 35, "Listas, pilhas, filas e árvores", "IFBA"},
    {"Java com Spring", 45, "Desenvolvimento de APIs com Spring Boot", "Digital Innovation One"},
    {"JavaScript Moderno", 30, "ES6+ e boas práticas", "Rocketseat"},
    {"React para Iniciantes", 25, "Componentes, Props e Hooks", "Origamid"},
    {"C++ Intermediário", 28, "Programação orientada a objetos", "Udemy"},
    {"Algoritmos", 32, "Lógica de programação e resolução de problemas", "IFBA"},
    {"Linux Básico", 15, "Comandos e uso do terminal", "Curso em Vídeo"},
    {"Engenharia de Software", 38, "Requisitos, modelagem e testes", "IFBA"},
    {"Git e GitHub", 10, "Controle de versão com Git", "Digital Innovation One"},
    {"Redes de Computadores", 30, "Fundamentos de redes", "Cisco Networking Academy"},
    {"Segurança da Informação", 22, "Princípios básicos de segurança", "Coursera"}
};

        
        for (Object[] linha : dados) {
            modelo.addRow(linha);
        }
    }
    
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Cursos");

        painelSuperior.setBackground(new java.awt.Color(255, 102, 102));

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));

        txtButao.setForeground(new java.awt.Color(0, 0, 0));
        txtButao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/imagens/pesquisa-de-lupa (1).png"))); // NOI18N
        txtButao.setText("Buscar...");
        txtButao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtButaoActionPerformed(evt);
            }
        });

        lblHomemCrem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/imagens/perfil-de-usuario.png"))); // NOI18N

        tabelaCurso.setBackground(new java.awt.Color(255, 204, 204));
        tabelaCurso.setBorder(new javax.swing.border.MatteBorder(null));
        tabelaCurso.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelaCurso.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N

        tabCurso.setBackground(new java.awt.Color(255, 204, 204));
        tabCurso.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
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

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tabelaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblHomemCrem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtButao)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSuperiorLayout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtButao)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHomemCrem, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabelaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(195, 195, 195))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    {"Banco de Dados", 20, "Curso de SQL e modelagem", "Coursera"},
    {"Desenvolvimento Web", 40, "HTML, CSS e JavaScript", "Alura"},
    {"Estrutura de Dados", 35, "Listas, pilhas, filas e árvores", "IFBA"},
    {"Java com Spring", 45, "Desenvolvimento de APIs com Spring Boot", "Digital Innovation One"},
    {"JavaScript Moderno", 30, "ES6+ e boas práticas", "Rocketseat"},
    {"React para Iniciantes", 25, "Componentes, Props e Hooks", "Origamid"},
    {"C++ Intermediário", 28, "Programação orientada a objetos", "Udemy"},
    {"Algoritmos", 32, "Lógica de programação e resolução de problemas", "IFBA"},
    {"Linux Básico", 15, "Comandos e uso do terminal", "Curso em Vídeo"},
    {"Engenharia de Software", 38, "Requisitos, modelagem e testes", "IFBA"},
    {"Git e GitHub", 10, "Controle de versão com Git", "Digital Innovation One"},
    {"Redes de Computadores", 30, "Fundamentos de redes", "Cisco Networking Academy"},
    {"Segurança da Informação", 22, "Princípios básicos de segurança", "Coursera"}
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
    private javax.swing.JLabel lblHomemCrem;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JTable tabCurso;
    private javax.swing.JScrollPane tabelaCurso;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JButton txtButao;
    // End of variables declaration//GEN-END:variables
}
