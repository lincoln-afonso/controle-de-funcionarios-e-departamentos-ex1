package br.com.linctech.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int TAM_MAT = 8;
    private static final int TAM_CPF = 11;
    private String matricula;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private double salario;
    private Departamento departamento;
    
    public Funcionario() {};

    public Funcionario(String matricula, String nome, String dataNascimento, String cpf, String salario,
            Departamento departamento) throws DadoInvalidoException, DadoNaoInformadoException {
        this.setMatricula(matricula);
        this.setCpf(cpf);
        this.setDataNascimento(dataNascimento);
        this.setDepartamento(departamento);
        this.setNome(nome);
        this.setSalario(salario);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws DadoInvalidoException {
        if (matricula.length() != Funcionario.TAM_MAT)
            throw new DadoInvalidoException("A maricula deve possuir ao menos " + Funcionario.TAM_MAT + " caracteres!");
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws DadoNaoInformadoException {
        if (nome.isEmpty())
            throw new DadoNaoInformadoException("O nome não foi informado!");
        this.nome = nome.toUpperCase();
    }

    public String getDataNascimento() {
        return dataNascimento.toString();
    }

    public void setDataNascimento(String dataNascimento) throws DadoNaoInformadoException {
        LocalDate data;
        
        data = this.converterData(dataNascimento);
        this.dataNascimento = data;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws DadoInvalidoException {
        if (cpf.length() != TAM_CPF)
            throw new DadoInvalidoException("O cpf deve ser informado sem pontos e sem traços e deve possuir 11 DÍGITOS!");
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(String salario) throws DadoNaoInformadoException, DadoInvalidoException{
        double valorSalario;

        if (salario.isEmpty())
            throw new DadoNaoInformadoException("O salário não foi informado!");

        valorSalario = Double.parseDouble(salario);
        if (valorSalario <= 0)
            throw new DadoInvalidoException("Salário inválido!");

        this.salario = valorSalario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    private LocalDate converterData(String data) throws DadoNaoInformadoException {
        if (data.isEmpty())
            throw new DadoNaoInformadoException("A data de nascimento não foi informada!\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        return dataFormatada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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

        Funcionario other = (Funcionario) obj;

        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;

        if (matricula == null) {
            if (other.matricula != null)
                return false;

        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario [cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", departamento=" + departamento
                + ", matricula=" + matricula + ", nome=" + nome + ", salario=" + salario + "]\n";
    }
    
    
}