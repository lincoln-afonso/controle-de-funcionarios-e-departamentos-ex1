package app;

import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import br.com.linctech.dominio.DadoInvalidoException;
import br.com.linctech.dominio.DadoNaoInformadoException;
import br.com.linctech.dominio.Departamento;
import br.com.linctech.dominio.Funcionario;
import br.com.linctech.dominio.MenuDeOpcoes;
import br.com.linctech.dominio.Serializador;
import br.com.linctech.dominio.SistemaDeGerenciamento;

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

public class App implements SistemaDeGerenciamento {
    private Scanner leia;
    private static final String caminhoFuncionario = "FUNCIONARIO.dat";
    private static final String caminhoDepartamento = "DEPARTAMENTO.dat";

    public App() {
        this.leia = new Scanner(System.in);
        this.inicializarArquivo();
    }

    public Scanner getLeia() {
        return leia;
    }
    
    public static String getCaminhoFuncionario() {
        return caminhoFuncionario;
    }

    public static String getCaminhoDepartamento() {
        return caminhoDepartamento;
    }

    private void inicializarArquivo() {
        File departamento;
        File funcionario;

        Set<Departamento> setDepartamentos = new HashSet<>();
        Set<Funcionario> setFuncionarios = new HashSet<>();

        departamento = new File(App.getCaminhoDepartamento());
        if (!departamento.exists()) {
            try {
                departamento.createNewFile();
                Serializador.gravar(setDepartamentos, App.getCaminhoDepartamento());
                System.out.println(setDepartamentos);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        funcionario = new File(App.getCaminhoFuncionario());
        if (!funcionario.exists()) {
            try {
                funcionario.createNewFile();
                Serializador.gravar(setFuncionarios, App.getCaminhoFuncionario());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public boolean cadastrarDepartamento(Set<Departamento> setDepartamentos) {
        String nome;
        String sigla;
        String codigo;
        boolean eValido;
        Departamento departamento = new Departamento();

        do {
            eValido = false;
            System.out.print("Código: ");
            codigo = this.getLeia().next();

            try {
                departamento.setCodigo(codigo);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        this.getLeia().nextLine();
        do {
            eValido = false;
            System.out.print("Nome: ");
            nome = this.getLeia().nextLine();

            try {
                departamento.setNome(nome);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("Sigla: ");
            sigla = this.getLeia().nextLine();

            try {
                departamento.setSigla(sigla);
                eValido = true;
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        return setDepartamentos.add(departamento);
    }

    @Override
    public boolean cadastrarFuncionario(Set<Departamento> setDepartamentos, Set<Funcionario> setFuncionarios) {
        String matricula;
        String nome;
        String dataNascimento;
        String cpf;
        double salario;
        Departamento departamento;
        Funcionario funcionario =  new Funcionario();
        boolean eValido;

        do {
            eValido = false;
            System.out.print("Matrícula: ");
            matricula = this.getLeia().nextLine();

            try {
                funcionario.setMatricula(matricula);
                eValido = true;
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("Nome: ");
            nome = this.getLeia().nextLine();

            try {
                funcionario.setNome(nome);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("Data de nascimento: ");
            dataNascimento = this.getLeia().nextLine();
            
           // try {
                funcionario.setDataNascimento(dataNascimento);
                eValido = true;
           // } catch (DateTimeParseException e) {
                System.out.println("Data inválida!\n");
           // }
        } while (eValido == false);

        return setFuncionarios.add(funcionario);
    }

    @Override
    public Funcionario pesquisaFuncionario(Set<Funcionario> setFuncionarios, Funcionario funcionario) {
        Iterator<Funcionario> func = setFuncionarios.iterator();

        while (func.hasNext()) {
            Funcionario f;
            f = func.next();
            if (f.getMatricula().equalsIgnoreCase(funcionario.getMatricula()));
                return f;
        }
        return null;
    }

    @Override
    public Departamento pesquisaDepartamento(Set<Departamento> setDepartamentos, Departamento departamento) {
        Iterator<Departamento> dep = setDepartamentos.iterator();

        while (dep.hasNext()) {
            Departamento d;
            d = dep.next();
            if (d.getCodigo() == departamento.getCodigo())
                return d;
        }
        return null;
    }

    @Override
    public boolean excluirFuncionario(Set<Funcionario> setFuncionarios) {
        return false;
    }

    @Override
    public boolean excluirDepartamento(Set<Departamento> setDepartamentos) {
        return false;
    }

    @Override
    public void listarFuncionarios(Set<Funcionario> setFuncionarios) {

    }

    @Override
    public void listarDepartamentos(Set<Departamento> setDepartamentos) {

    }

    public static void main(String[] args) {
        String opcao = "";
        Set<Departamento> setDepartamentos;
        Set<Funcionario> setFuncionarios;
        App app = new App();

        do {
            setDepartamentos = (Set<Departamento>) Serializador.recuperar(App.getCaminhoDepartamento());
            setFuncionarios = (Set<Funcionario>) Serializador.recuperar(App.getCaminhoFuncionario());

            MenuDeOpcoes.perguntarOpcaoDesejada();
            opcao = app.getLeia().nextLine();
            switch (opcao) {
                case "1":
                    if (app.cadastrarDepartamento(setDepartamentos)) {
                        Serializador.gravar(setDepartamentos, App.getCaminhoDepartamento());
                        System.out.println("Departamento cadastrado!\n");
                    }
                    else 
                        System.out.println("O departamnto informado se encontra cadastrado!");
                    break;

                case "2":
                    app.cadastrarFuncionario(setDepartamentos, setFuncionarios);
                    System.out.println(setDepartamentos);
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