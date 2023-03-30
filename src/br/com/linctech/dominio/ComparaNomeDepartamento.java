package br.com.linctech.dominio;

import java.util.Comparator;

import br.com.linctech.dominio.Departamento;;

public class ComparaNomeDepartamento implements Comparator<Departamento> {

    @Override
    public int compare(Departamento dp1, Departamento dp2) {
        int nome =  dp1.getNome().compareToIgnoreCase(dp2.getNome());
        
        if (nome == 0) {
            if (dp1.getCodigo() > dp2.getCodigo())
                return -1;
            else if (dp1.getCodigo() < dp2.getCodigo())
                return 1;
            
            return 0;
        }
        return nome;
    }

}