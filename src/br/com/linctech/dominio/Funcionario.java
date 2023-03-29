package br.com.linctech.dominio;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private String matricula;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private double salario;
    private Departamento departamento;

}