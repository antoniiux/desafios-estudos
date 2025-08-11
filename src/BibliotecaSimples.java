import java.util.Scanner;

public class BibliotecaSimples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Catálogo com capacidade fixa (procedural, sem listas/POO)
        String[] titulos = new String[100];
        int[] quantidades = new int[100];
        int totalLivros = 0;

        // Estado inicial
        titulos[totalLivros] = "Clean Code";      quantidades[totalLivros++] = 3;
        titulos[totalLivros] = "Java Efetivo";    quantidades[totalLivros++] = 2;
        titulos[totalLivros] = "Algoritimos";      quantidades[totalLivros++] = 1;

        int opcao = 0;
        String menu = "\n*** BIBLIOTECA (SEM POO) ***\n"
                + "1 - Listar catálogo\n"
                + "2 - Adicionar livros\n"
                + "3 - Emprestar livro\n"
                + "4 - Devolver livro\n"
                + "5 - Sair\n";

        while (opcao != 5) {
            System.out.println(menu);

            if (!sc.hasNextInt()) { // protege contra lixo
                System.out.println("Opção inválida!\n");
                sc.nextLine();
                continue;
            }
            opcao = sc.nextInt();
            sc.nextLine(); // consome \n

            if (opcao == 1) {
                System.out.println("\n--- CATÁLOGO ---");
                if (totalLivros == 0) {
                    System.out.println("Nenhum livro cadastrado.\n");
                } else {
                    for (int i = 0; i < totalLivros; i++) {
                        System.out.println((i + 1) + " - " + titulos[i] + " | Exemplares: " + quantidades[i]);
                    }
                    System.out.println();
                }

            } else if (opcao == 2) {
                if (totalLivros >= titulos.length) {
                    System.out.println("Capacidade máxima atingida.\n");
                    continue;
                }
                System.out.print("Título do livro: ");
                String tituloAdd = sc.nextLine().trim();
                System.out.print("Quantidade a adicionar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Quantidade inválida.\n");
                    sc.nextLine();
                    continue;
                }
                int qtdAdd = sc.nextInt(); sc.nextLine();

                if (tituloAdd.isEmpty() || qtdAdd <= 0) {
                    System.out.println("Dados inválidos.\n");
                    continue;
                }

                // procura se já existe
                int idx = -1;
                for (int i = 0; i < totalLivros; i++) {
                    if (titulos[i].equalsIgnoreCase(tituloAdd)) {
                        idx = i; break;
                    }
                }
                if (idx >= 0) {
                    quantidades[idx] += qtdAdd;
                } else {
                    titulos[totalLivros] = tituloAdd;
                    quantidades[totalLivros] = qtdAdd;
                    totalLivros++;
                }
                System.out.println("Livro(s) adicionado(s) com sucesso!\n");

            } else if (opcao == 3) {
                System.out.print("Título para empréstimo: ");
                String tituloEmp = sc.nextLine().trim();
                int idx = -1;
                for (int i = 0; i < totalLivros; i++) {
                    if (titulos[i].equalsIgnoreCase(tituloEmp)) { idx = i; break; }
                }
                if (idx == -1) {
                    System.out.println("Livro não encontrado.\n");
                } else if (quantidades[idx] <= 0) {
                    System.out.println("Sem exemplares disponíveis!\n");
                } else {
                    quantidades[idx]--;
                    System.out.println("Empréstimo realizado. Restantes: " + quantidades[idx] + "\n");
                }

            } else if (opcao == 4) {
                System.out.print("Título para devolução: ");
                String tituloDev = sc.nextLine().trim();
                int idx = -1;
                for (int i = 0; i < totalLivros; i++) {
                    if (titulos[i].equalsIgnoreCase(tituloDev)) { idx = i; break; }
                }
                if (idx == -1) {
                    if (totalLivros >= titulos.length) {
                        System.out.println("Catálogo cheio. Devolução não registrada.\n");
                        continue;
                    }
                    System.out.print("Livro não existe no catálogo. Deseja adicioná-lo com 1 exemplar? (s/n): ");
                    String r = sc.nextLine().trim().toLowerCase();
                    if (r.equals("s")) {
                        titulos[totalLivros] = tituloDev.isEmpty() ? "Sem Título" : tituloDev;
                        quantidades[totalLivros] = 1;
                        totalLivros++;
                        System.out.println("Livro incluído com 1 exemplar.\n");
                    } else {
                        System.out.println("Devolução cancelada.\n");
                    }
                } else {
                    quantidades[idx]++;
                    System.out.println("Devolução registrada. Total: " + quantidades[idx] + "\n");
                }

            } else if (opcao == 5) {
                System.out.println("Encerrando o sistema.");
            } else {
                System.out.println("Opção inválida!\n");
            }
        }

        sc.close();
    }
}

