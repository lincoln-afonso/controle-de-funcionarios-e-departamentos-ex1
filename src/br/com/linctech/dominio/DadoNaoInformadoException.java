package br.com.linctech.dominio;

public class DadoNaoInformadoException extends Exception {
    private static final long serialVersionUID = 1L;

    public DadoNaoInformadoException() {
        super("O dado solicitado não foi informado!");
    }

    public DadoNaoInformadoException(String str) {
        super(str);
    }
}