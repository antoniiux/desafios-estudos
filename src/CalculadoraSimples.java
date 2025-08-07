import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        String menu = """
                \n*** CALCULADORA SIMPLES ***
                Escolha uma operação:

                1 - Adição
                2 - Subtração
                3 - Multiplicação
                4 - Divisão
                5 - Sair

                Digite sua opção:
                """;

        while (opcao != 5) {
            System.out.print(menu);
            opcao = sc.nextInt();

            if (opcao >= 1 && opcao <= 4) {
                System.out.print("Digite o primeiro número: ");
                double num1 = sc.nextDouble();

                System.out.print("Digite o segundo número: ");
                double num2 = sc.nextDouble();

                double resultado = 0;

                switch (opcao) {
                    case 1:
                        resultado = num1 + num2;
                        System.out.println("Resultado da soma: " + resultado);
                        break;
                    case 2:
                        resultado = num1 - num2;
                        System.out.println("Resultado da subtração: " + resultado);
                        break;
                    case 3:
                        resultado = num1 * num2;
                        System.out.println("Resultado da multiplicação: " + resultado);
                        break;
                    case 4:
                        if (num2 != 0) {
                            resultado = num1 / num2;
                            System.out.println("Resultado da divisão: " + resultado);
                        } else {
                            System.out.println("Erro: divisão por zero!");
                        }
                        break;
                }
            } else if (opcao == 5) {
                System.out.println("Encerrando a calculadora.");
            } else {
                System.out.println("Ops... Opção inválida!\n");
            }
        }
        sc.close();
    }
}
