import Impl.Aviao;
import Impl.EmbarqueImpl;
import Impl.GerenciarAviaoImpl;
import Impl.Passageiro;
import Interface.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

            Passageiro p = new Passageiro();
        System.out.println(p);

//        Scanner leitor = new Scanner(System.in);
//        GerenciarAviao gestorAviao = new GerenciarAviaoImpl();
//        Embarque gestorEmbarque = new EmbarqueImpl();
//
//        int opcaoPrincipal = -1;
//
//        while (opcaoPrincipal != 0) {
//            System.out.println("\n=======================================");
//            System.out.println("   SISTEMA DE GESTÃO DE EMPRESA AÉREA   ");
//            System.out.println("========================================");
//            System.out.println("1 - Gerenciamento de Aviões");
//            System.out.println("2 - Gestão de Passageiros e Embarque");
//            System.out.println("3 - Histórico de Operações");
//            System.out.println("0 - Encerrar Sistema");
//            System.out.print("Escolha uma opção: ");
//
//            opcaoPrincipal = leitor.nextInt();
//            leitor.nextLine();
//
//            switch (opcaoPrincipal) {
//                case 1:
//                    menuAvioes(leitor, gestorAviao);
//                    break;
//                case 2:
//                    menuPassageiros(leitor, gestorEmbarque);
//                    break;
//                case 3:
//                    System.out.println("\n--- HISTÓRICO DE OPERAÇÕES ---");
//                    gestorEmbarque.exibirFilaEmbarque();
//                    break;
//                case 0:
//                    System.out.println("Encerrando o sistema... Até logo!");
//                    break;
//                default:
//                    System.out.println("Opção inválida! Tente novamente.");
//            }
//        }
//        leitor.close();
    }

    private static void menuAvioes(Scanner leitor, GerenciarAviao gestor) {
        int subOpcao;

        do {
            System.out.println("\n--- GERENCIAR AVIÕES ---");
            System.out.println("1 - Cadastrar Avião ");
            System.out.println("2 - Listar todos os Aviões");
            System.out.println("3 - Excluir Avião por Código");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            subOpcao = leitor.nextInt();
            leitor.nextLine();

            switch (subOpcao) {
                case 1:
                    gestor.cadastraAviao(new Aviao());
                    System.out.println("Avião cadastrado com sucesso!");
                    break;
                case 2:
                    gestor.listarAviaos();
                    break;
                case 3:
                    System.out.print("Digite o código do avião: ");
                    String codigo = leitor.nextLine();
                    if (gestor.excluirAviao(codigo)) {
                        System.out.println("Avião removido!");
                    } else {
                        System.out.println("Erro: Avião não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (subOpcao != 0);
    }

    private static void menuPassageiros(Scanner leitor, Embarque gestor) {
        System.out.println("\n--- SUBMENU: PASSAGEIROS E EMBARQUE ---");
        System.out.println("1 - Vender Passagem (Criar Passageiro)");
        System.out.println("2 - Inserir na Fila Comum (FIFO)");
        System.out.println("3 - Inserir na Fila Prioritária (Heap)");
        System.out.println("4 - Realizar Embarque (Próximo da Fila)");
        System.out.print("Escolha: ");

        int subOpcao = leitor.nextInt();
        leitor.nextLine();

        switch (subOpcao) {
            case 1:

                System.out.println("Gerando passageiro aleatório...");
                gestor.venderPassagem(new Passageiro());
                break;
            case 2:
                System.out.print("Documento do passageiro para Fila Comum: ");
                String docComum = leitor.nextLine();
                gestor.inserirFilaComum(docComum);
                break;
            case 3:
                System.out.print("Documento do passageiro para Fila Prioritária: ");
                String docPri = leitor.nextLine();
                gestor.inserirFilaPrioridade(docPri);
                break;
            case 4:

                gestor.embacarPassageiro();
                break;
        }
    }
}
