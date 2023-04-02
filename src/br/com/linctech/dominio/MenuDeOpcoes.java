package br.com.linctech.dominio;

public abstract class MenuDeOpcoes {
    private static void exibirOpcoes() {
        System.out.println("\nMENU");
        System.out.println("1 - CADASTRAR DEPARTAMENTO");
        System.out.println("2 - CADASTRAR FUNCIONARIO");
        System.out.println("3 - LISTAR DETERMINADO FUNCIONARIO");
        System.out.println("4 - LISTAR FUNCIONARIOS DE UM DEPARTAMENTO");
        System.out.println("5 - EXCLUIR FUNCIONARIO");
        System.out.println("6 - EXCLUIR DEPARTAMENTO");
        System.out.println("7 - FINALIZAR\n");
    }

    public static void perguntarOpcaoDesejada() {
        MenuDeOpcoes.exibirOpcoes();
        System.out.print("Informe o número da opção desejada: ");
    }
}