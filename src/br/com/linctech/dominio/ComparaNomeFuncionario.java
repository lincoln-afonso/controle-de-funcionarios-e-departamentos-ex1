package br.com.linctech.dominio;

import java.util.Comparator;

import br.com.linctech.dominio.Funcionario;

public class ComparaNomeFuncionario implements Comparator<Funcionario> {

    @Override
    public int compare(Funcionario f1, Funcionario f2) {
        int nome;

        nome = f1.getNome().compareToIgnoreCase(f2.getNome());
        if (nome == 0) {
            return f1.getMatricula().compareToIgnoreCase(f2.getMatricula());
        }
        return nome;
    }
}