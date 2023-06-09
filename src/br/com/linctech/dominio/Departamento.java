package br.com.linctech.dominio;

import java.io.Serializable;

public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int TAM_NOME = 5;
    private static final int TAM_SIGLA = 3;
    private int codigo;
    private String nome;
    private String sigla;

    public Departamento() {
    }

    public Departamento(String codigo, String nome, String sigla) throws DadoNaoInformadoException, DadoInvalidoException {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setSigla(sigla);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws DadoNaoInformadoException, DadoInvalidoException {
        int valorCodigo;

        if (codigo.isEmpty())
            throw new DadoNaoInformadoException();
        
        valorCodigo = Integer.parseInt(codigo);
        if (valorCodigo <= 0)
            throw new DadoInvalidoException("O código informado não é válido!");

        this.codigo = valorCodigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws DadoNaoInformadoException, DadoInvalidoException {
        if (nome.isEmpty())
            throw new DadoNaoInformadoException();
        
        if (nome.length() < Departamento.TAM_NOME)
            throw new DadoInvalidoException("O nome deve possuir ao menos " +  Departamento.TAM_NOME + " caracteres!");
        this.nome = nome.toUpperCase();
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) throws DadoInvalidoException {

        if (sigla.length() < Departamento.TAM_SIGLA)
            throw new DadoInvalidoException("A sigla deve possuir ao menos " + Departamento.TAM_SIGLA + " caracteres!");
        this.sigla = sigla.toUpperCase();
    }

    @Override
    public String toString() {
        return "Departamento [codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Departamento other = (Departamento) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    } 
}