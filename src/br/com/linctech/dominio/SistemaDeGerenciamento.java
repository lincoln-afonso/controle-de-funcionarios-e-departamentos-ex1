package br.com.linctech.dominio;

import java.util.Set;

public interface SistemaDeGerenciamento {
    
    public abstract boolean cadastrarDepartamento(Set<Departamento> setDepartamentos);

    public abstract boolean cadastrarFuncionario(Set<Departamento> setDepartamentos, Set<Funcionario> setFuncionarios);    
   
    public abstract Funcionario pesquisaFuncionario(Set<Funcionario> setFuncionarios);

    public abstract Departamento pesquisaDepartamento(Set<Departamento> setDepartamentos);

    public abstract boolean excluirFuncionario(Set<Funcionario> setFuncionarios);

    public abstract boolean excluirDepartamento(Set<Departamento> setDepartamentos);

    public abstract void listarFuncionarios(Set<Funcionario> setFuncionarios);

    public abstract void listarDepartamentos(Set<Departamento> setDepartamentos);
}