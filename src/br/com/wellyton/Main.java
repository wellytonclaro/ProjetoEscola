
      
                   
            
        
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wellyton;

import br.com.wellyton.objetos.Disciplina;
import br.com.wellyton.objetos.Professor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriela.154717
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        List<Disciplina> materias = new ArrayList<>();
        List<Professor> prof = new ArrayList<>();
        int esc = 0;
        do {
            esc = Integer.parseInt(JOptionPane.showInputDialog("Escolha"
                    + "\n 1. Cadastro de Disciplina"
                    + "\n 2. Cadastro de Professor"
                    + "\n 3. Cadastro de Aluno"
                    + "\n 4. Consulta de Disciplina"
                    + "\n 5. Consulta de Professor"
                    + "\n 6. Consulta de Aluno"
                    + "\n 7. Sair"));
            switch (esc) {
                case 1: {

                    do {
                        String nome;
                        String departamento;
                        char status;

                        nome = JOptionPane.showInputDialog("Informe o Nome da Disciplina: ");
                        departamento = JOptionPane.showInputDialog("Qual o Departamento? ");
                        status = JOptionPane.showInputDialog("Status [A]tivo ou [I]nativo").charAt(0);
                        materias.add(new Disciplina(nome, departamento, status));

                    } while ((JOptionPane.showConfirmDialog(null, "Deseja Continuar?")) == 0);
                    break;
                }
                case 2: {
                    do {
                        int cargaHoraria;
                        float valorHora;
                        float salario = 0;
                        String nome;
                        String rg;
                        String cpf;
                        int idade = 0;
                        Date dataNascimento;
                        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy");

                        nome = JOptionPane.showInputDialog("Informe seu Nome: ");
                        rg = JOptionPane.showInputDialog("Informe seu RG: ");
                        cpf = JOptionPane.showInputDialog("Informe seu CPF: ");
                        dataNascimento = conversor.parse(JOptionPane.showInputDialog("informe a Data de Nascimento: "));
                        cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Informe sua carga Horaria"));
                        valorHora = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da hora: "));

                        prof.add(new Professor(cargaHoraria, valorHora, salario, nome, rg, cpf, idade, dataNascimento));

                        if (JOptionPane.showConfirmDialog(null, "Professor já trabalha em alguma disciplina") == 0);
                        do {
                            String disciplinaExistente = "";
                            for (Disciplina materia : materias) {
                                disciplinaExistente += "\n" + materias.indexOf(materias) + " " + materia.getNome();
                            }
                            int escolhaDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Informe qual disciplina: \n" + disciplinaExistente));
                            prof.get(prof.size() - 1).getDisciplinas().add(materias.get(escolhaDisciplina));
                        } while ((JOptionPane.showConfirmDialog(null, "Professor possui outra disciplina?")) == 0);

                    } while ((JOptionPane.showConfirmDialog(null, "Deseja Continuar?")) == 0);
                    break;
                }
            }

        } while (esc != 7);
    }
}

