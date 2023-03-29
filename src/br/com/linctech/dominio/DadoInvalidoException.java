package br.com.linctech.dominio;

public class DadoInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;

    public DadoInvalidoException() {
        super("O dado informado é inválido!");
    }

    public DadoInvalidoException(String str) {
        super(str);
    }
    
    
}