import java.util.Scanner;

public class ControleDeEstoque {
    public static void main(String[] args) {
        int estoque = 100;
        int opcao = 0;
        Scanner sc = new Scanner(System.in);

        String menu = """
                \n*** CONTROLE DE ESTOQUE - CERVEJAS ***
                Escolha uma opção:

                1 - Consultar estoque
                2 - Adicionar cervejas
                3 - Vender cervejas
                4 - Sair
                """;

        while (opcao != 4) {
            System.out.println(menu);
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Estoque atual: " + estoque + " cervejas.\n");
                    break;

                case 2:
                    System.out.print("Digite a quantidade de cervejas para adicionar: ");
                    int adicionar = sc.nextInt();
                    if (adicionar > 0) {
                        estoque += adicionar;
                        System.out.println("Cervejas adicionadas. Estoque agora: " + estoque + "\n");
                    } else {
                        System.out.println("Quantidade inválida!\n");
                    }
                    break;

                case 3:
                    System.out.print("Digite a quantidade de cervejas para vender: ");
                    int vender = sc.nextInt();
                    if (vender > 0 && vender <= estoque) {
                        estoque -= vender;
                        System.out.println("Venda realizada. Estoque agora: " + estoque + "\n");
                    } else if (vender > estoque) {
                        System.out.println("Estoque insuficiente!\n");
                    } else {
                        System.out.println("Quantidade inválida!\n");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o sistema de controle de estoque.");
                    break;

                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        }

        sc.close();
    }
}