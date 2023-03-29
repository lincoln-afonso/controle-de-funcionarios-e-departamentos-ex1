package app;

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
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}