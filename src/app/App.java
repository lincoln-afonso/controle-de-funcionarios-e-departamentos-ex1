package app;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

import br.com.linctech.dominio.Departamento;
import br.com.linctech.dominio.Funcionario;
import br.com.linctech.dominio.MenuDeOpcoes;
import br.com.linctech.dominio.Serializador;

/*
 * Projeto simples que gerencia um sistema de controle de funcionários e departamentos. 
 * Faça um programa que mostre o menu:
 * 1 – Cadastro de Departamento
 * 2 - Cadastro de Funcionários
 * 3 – Consulta de Funcionários
 * 4 – Funcionários de um Departamento
 * 5 – Excluir Funcionário
 * 6 – Excluir Departamento
 * 7 –	Listar Departamentos
 * 8 – Listar Funcionários
 * 9 – Fim

 * Cadastro de Departamento; cadastrar o código, nome e sigla de no máximo 20 departamentos. O
 * código é único e o nome não pode ser vazio.

 * Cadastro de Funcionários; cadastrar a matrícula, nome, data de nascimento, cpf, salário e código de
 * departammento de no máximo 1000 funcionários.
 * Obs.;

 * a) A matrícula é única;
 * b) O nome não pode ser vazio;
 * c) Validar a data de nascimento e cpf;
 * d) O salário deve ser maior que zero;
 * e) Aceitar para o campo código do departamento apenas departamentos já cadastrados.
 * Consulta de Funcionários: mostrar a matrícula, nome e nome do departamentos dos funcionários
 * que tenham o nome com um determinado prefixo.

 * Funcionários de um Departamento: mostrar os dados dos funcionários pertencentes a um
 * determinado departamento.

 * Excluir Funcionário: excluir um funcionário a partir de sua matrícula.

 * Excluir Departamento: excluir um departamento a partir de seu código bem como todos os
 * funcionários pertencentes ao departamento excluído. */

public class App {
    private Scanner leia;

    public App() {
        this.leia = new Scanner(System.in);
    }

    public Scanner getLeia() {
        return leia;
    }

    public static void inicializarArquivo() {
        File funcionario;
        File departamento;
        String caminhoFuncionario = "funcionario.dat";
        String caminhoDepartamento = "departamento.dat";

        Set<Departamento> setDepartamentos = new TreeSet<>();
        Set<Funcionario> setFuncionarios = new TreeSet<>();

        departamento = new File(caminhoDepartamento);
        if (!departamento.exists()) {
            try {
                departamento.createNewFile();
                Serializador.gravar(setDepartamentos, caminhoDepartamento);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        funcionario = new File(caminhoFuncionario);
        if (!funcionario.exists()) {
            try {
                funcionario.createNewFile();
                Serializador.gravar(setFuncionarios, caminhoFuncionario);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String opcao = "";
        Set<Departamento> setDepartamentos;
        Set<Funcionario> setFuncionarios;
        App app = new App();

        do {
            MenuDeOpcoes.perguntarOpcaoDesejada();
            opcao = app.getLeia().nextLine();
            switch (opcao) {
                case "1":

                    break;

                case "2":

                    break;

                case "3":

                    break;
                
                case "4":

                    break;
                
                case "5":

                    break;

                 case "6":

                    break;

                case "7":

                    break;

                case "8":

                    break;
                
                case "9":
                    System.out.println("Programa Encerrado!\n");
                    break;
                
                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        } while (!opcao.equals("9"));
        app.getLeia().close();
    }
}