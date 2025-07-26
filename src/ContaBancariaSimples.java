import java.util.Scanner;

public class ContaBancariaSimples {
    public static void main(String[] args) {
        String nome = "Antonio";
        String tipoConta = "Corrente";
        double saldo = 1599.99;
        int opcao = 0;

        System.out.print("******************************");
        System.out.println("\n -- Nome do cliente: " + nome);
        System.out.println(" -- Tipo conta: " + tipoConta);
        System.out.println(" -- Saldo atual: R$ " + saldo);
        System.out.println("******************************\n");

        String menu = """
                \n** Digite sua opção **\n
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor
                4 - Sair

                """;
        Scanner sc = new Scanner(System.in);

        while (opcao != 4) {
            System.out.println(menu);
            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println(" -- O saldo atualizado é : R$ " + saldo + "\n");
            } else if (opcao == 2) {
                System.out.println(" -- Qual o saldo que deseja transferir");
                double valor = sc.nextDouble();
                if (valor > saldo) {
                    System.out.println(" -- Não a saldo para realizar transferencia");
                } else {
                    saldo -= valor;
                    System.out.println("Novo saldo: R$ " + saldo+ "\n");
                }
            } else if (opcao == 3) {
                System.out.println("\nValor recebido: ");
                double valor = sc.nextDouble();
                saldo += valor;
                System.out.println("Novo saldo: R$ " + saldo + "\n");
            } else if (opcao != 4) {
                System.out.println("Opção invalida\n");
            }
        }
    }
}
