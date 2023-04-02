package br.com.linctech.dominio;

public class ColecaoVaziaException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = 1L;

    public ColecaoVaziaException() {
        super("Coleção não possui elementos!");
    }

    public ColecaoVaziaException(String str) {
        super(str);
    }    
}