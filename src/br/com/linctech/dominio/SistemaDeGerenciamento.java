package br.com.linctech.dominio;

import java.util.Set;

public interface SistemaDeGerenciamento {
    
    public abstract boolean cadastrarDepartamento(Set<Departamento> setDepartamentos);

    public abstract boolean cadastrarFuncionario(Set<Departamento> setDepartamentos, Set<Funcionario> setFuncionarios);    
   
    public abstract Funcionario pesquisaFuncionario(Set<Funcionario> setFuncionarios, Funcionario funcionario);

    public abstract Departamento pesquisaDepartamento(Set<Departamento> setDepartamentos, Departamento departamento);

    public abstract boolean excluirFuncionario(Set<Funcionario> setFuncionarios);

    public abstract boolean excluirDepartamento(Set<Departamento> setDepartamentos, Set<Funcionario> setFuncionarios);

    public abstract boolean listarFuncionario(Set<Funcionario> setFuncionarios);

    public abstract boolean listarDepartamentos(Set<Departamento> setDepartamentos);
}