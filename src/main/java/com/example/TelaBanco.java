package com.example;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaBanco {

    private JFrame frame;
    private JTable table;
    private JTextField textFieldNome;
    private JTextField textFieldSaldo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaBanco window = new TelaBanco();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaBanco() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnSacar = new JButton("Sacar");
        btnSacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Sacar: ");

                float valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Sacar: "));

                Pessoa pessoa = new Pessoa();
                PessoaFisica pessoaFisica = new PessoaFisica();
                PessoaJuridica pessoaJuridica = new PessoaJuridica();

                if (pessoa.tipoPessoa.equals("Fisica")) {
                    pessoaFisica.sacar(valor);
                } else if (pessoa.tipoPessoa.equals("Juridica")) {
                    pessoaJuridica.sacar(valor);
                } else if (!pessoa.tipoPessoa.equals("Fisica") || !pessoa.tipoPessoa.equals("Juridica")) {
                    System.out.println("Nenhum usuário selecionado");
                }
            }
        });
        btnSacar.setBounds(590, 226, 100, 25);
        frame.getContentPane().add(btnSacar);

        JButton btnDepositar = new JButton("Depositar");
        btnDepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Depositar: ");

                float valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite algo"));

                Pessoa pessoa = new Pessoa();
                PessoaFisica pessoaFisica = new PessoaFisica();
                PessoaJuridica pessoaJuridica = new PessoaJuridica();

                if (pessoa.tipoPessoa.equals("Fisica")) {
                    pessoaFisica.depositar(valor);
                } else if (pessoa.tipoPessoa.equals("Juridica")) {
                    pessoaJuridica.depositar(valor);
                }
            }
        });
        btnDepositar.setBounds(476, 226, 100, 25);
        frame.getContentPane().add(btnDepositar);

        JLabel lblNewLabel = new JLabel("Banco");
        lblNewLabel.setBounds(450, 11, 123, 14);
        frame.getContentPane().add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(245, 300, 450, 100);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "AGENCIA", "NUMERO", "NOME", "TIPO CONTA", "SALDO" }));
        scrollPane.setViewportView(table);

        JLabel lblNewLabel_1 = new JLabel("Tipo Pessoa: ");
        lblNewLabel_1.setBounds(252, 128, 100, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Nome:");
        lblNewLabel_2.setBounds(300, 99, 46, 14);
        frame.getContentPane().add(lblNewLabel_2);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(350, 96, 220, 20);
        frame.getContentPane().add(textFieldNome);
        textFieldNome.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Saldo: ");
        lblNewLabel_3.setBounds(290, 171, 200, 14);
        frame.getContentPane().add(lblNewLabel_3);

        textFieldSaldo = new JTextField();
        textFieldSaldo.setBounds(340, 171, 125, 20);
        frame.getContentPane().add(textFieldSaldo);
        textFieldSaldo.setColumns(10);

        JRadioButton rdbtnJuridica = new JRadioButton("Juridica");
        rdbtnJuridica.setBounds(350, 124, 109, 23);
        frame.getContentPane().add(rdbtnJuridica);

        JRadioButton rdbtnFisica = new JRadioButton("Fisica");
        rdbtnFisica.setBounds(460, 124, 77, 23);
        frame.getContentPane().add(rdbtnFisica);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Pessoa pessoaJuridica = new PessoaJuridica();
                Pessoa pessoaFisica = new PessoaFisica();
                Pessoa pessoa = new Pessoa();

                String nome = textFieldNome.getText();
                pessoa.setNome(nome);
                String valor = textFieldSaldo.getText();

                if (rdbtnJuridica.isSelected()) {
                    pessoa.setTipoPessoa("Juridica");
                }

                if (rdbtnFisica.isSelected()) {
                    pessoa.setTipoPessoa("Fisica");
                }

                String tipoPessoa = pessoa.getTipoPessoa();
                pessoa.setTipoPessoa(tipoPessoa);

                DefaultTableModel tabela = (DefaultTableModel) table.getModel();
                tabela.addRow(new String[] { "90091", "765", pessoa.getNome(), pessoa.getTipoPessoa(), valor });

            }
        });
        btnCadastrar.setBounds(248, 226, 100, 25);
        frame.getContentPane().add(btnCadastrar);

        JButton btnExcluir = new JButton("Deletar");
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnExcluir.setBounds(360, 226, 100, 25);
        frame.getContentPane().add(btnExcluir);
    }
}
