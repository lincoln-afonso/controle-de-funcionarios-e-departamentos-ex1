package br.com.linctech.dominio;

public class ColecaoVaziaException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = 1L;

    public ColecaoVaziaException() {
    }

    public ColecaoVaziaException(String str) {
        super(str);
    }    
}