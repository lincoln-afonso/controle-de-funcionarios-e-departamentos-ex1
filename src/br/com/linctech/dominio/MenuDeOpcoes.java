package br.com.linctech.dominio;

public abstract class MenuDeOpcoes {
    private static void exibirOpcoes() {
        System.out.println("\nMENU");
        System.out.println("1 - CADASTRAR DEPARTAMENTO");
        System.out.println("2 - CADASTRAR FUNCIONARIO");
        System.out.println("3 - CONSULTAR FUNCIONARIO");
        System.out.println("4 - LISTAR FUNCIONARIOS DE UM DEPARTAMENTO");
        System.out.println("5 - EXCLUIR FUNCIONARIO");
        System.out.println("6 - EXCLUIR DEPARTAMENTO");
        System.out.println("7 - LISTAR DEPARTAMENTOS");
        System.out.println("8 - LISTAR FUNCIONARIOS");
        System.out.println("9 - FINALIZAR\n");
    }

    public static void perguntarOpcaoDesejada() {
        MenuDeOpcoes.exibirOpcoes();
        System.out.print("Informe o número da opção desejada: ");
    }
}