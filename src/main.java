import Impl.Aviao;

import Enum.*;
import Impl.*;
import Interface.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        GerenciarAviao gestorAviao = new GerenciarAviaoImpl();
        Embarque gestorEmbarque = new EmbarqueImpl();
        GerenciarVoo gestorVoo = new GerenciarVooImpl();
        int opcaoPrincipal = -1;

        while (opcaoPrincipal != 0) {
            System.out.println("\n=======================================");
            System.out.println("   SISTEMA DE GESTÃO DE EMPRESA AÉREA   ");
            System.out.println("========================================");
            System.out.println("1 - Gerenciamento de Aviões");
            System.out.println("2 - Gerenciar voo");
            System.out.println("3 - Gestão de Passageiros e Embarque");
            System.out.println("4 - Histórico de Operações");
            System.out.println("0 - Encerrar Sistema");
            System.out.print("Escolha uma opção: ");

            opcaoPrincipal = leitor.nextInt();
            leitor.nextLine();

            switch (opcaoPrincipal) {
                case 1:
                    menuAvioes(leitor, gestorAviao);
                    break;
                case 2:

                    menuVoo(leitor,gestorVoo,gestorAviao );
                    break;
                case 3:
                    menuPassageiros(leitor, gestorEmbarque, gestorVoo);

                    break;
                case 4:
                    menuHistorico(leitor, gestorEmbarque);
                    break;
                case 0:

                    System.out.println("Encerrando o sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        leitor.close();
    }

    private static void menuAvioes(Scanner leitor, GerenciarAviao gestor) {
        int subOpcao;

        do {
            System.out.println("\n--- GERENCIAR AVIÕES ---");
            System.out.println("1 - Cadastrar Avião ");
            System.out.println("2 - Listar todos os Aviões");
            System.out.println("3 - Buscar Avião por Código");
            System.out.println("4 - Excluir Avião por Código");
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
                    String codigoBusca = leitor.nextLine();
                    Aviao aviaoEncontrado = gestor.buscarAviao(codigoBusca);
                    if (aviaoEncontrado != null) {
                        System.out.println("Avião encontrado: " + aviaoEncontrado);
                    } else {
                        System.out.println("Avião não encontrado.");
                    }
                    break;
                case 4:
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

    private static void menuPassageiros(Scanner leitor, Embarque gestor, GerenciarVoo gestorVoo) {
        int subOpcao;

        do {
            System.out.println("\n--- SUBMENU: PASSAGEIROS E EMBARQUE ---");
            System.out.println("1 - Vender Passagem ");
            System.out.println("2 - Listar Passageiros que compraram passagem");
            System.out.println("3 - Inserir na Fila Comum ");
            System.out.println("4 - Inserir na Fila Prioritária ");
            System.out.println("5 - VISUALIZAR FILAS DE EMBARQUE (Painel)");
            System.out.println("6 - Realizar Embarque ");
            System.out.println("7 - Exibir Passageiros Já Embarcados");
            System.out.println("8 - Desfazer Última Operação");
            System.out.println("9 - Ver historico de operação");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            subOpcao = leitor.nextInt();
            leitor.nextLine();

            switch (subOpcao) {
                case 1:
                    gestorVoo.listarVoos();
                    System.out.print("Escolha o Código do Voo: ");
                    String pVoo = leitor.nextLine();

                    if (gestorVoo.verificarDisponibilidade(pVoo)) {
                        Voo vooEscolhido = gestorVoo.procuraVoo(pVoo);
                        System.out.println("\n--- ESCOLHA A PRIORIDADE ---");
                        System.out.println("1 - Idoso | 2 - Gestante | 3 - Deficiente | 4 - Comum");
                        System.out.print("Opção: ");

                        int pOpcao = leitor.nextInt();
                        leitor.nextLine();

                        Prioridade pEscolhida;
                        switch (pOpcao) {
                            case 1: pEscolhida = Prioridade.IDOSO; break;
                            case 2: pEscolhida = Prioridade.GESTANTE; break;
                            case 3: pEscolhida = Prioridade.DEFICIENTE; break;
                            default: pEscolhida = Prioridade.COMUM; break;
                        }

                        Passageiro novoPassageiro = new Passageiro(pEscolhida, vooEscolhido);
                        gestor.venderPassagem(novoPassageiro);
                        vooEscolhido.incrementarPassageiro();
                    }
                    break;

                case 2:
                    gestor.listarPassageiroCadastrado();
                    break;

                case 3:
                    gestor.listarPassageiroCadastrado();
                    System.out.print("Documento para Fila Comum: ");
                    gestor.inserirFilaComum(leitor.nextLine());
                    break;

                case 4:
                    gestor.listarPassageiroCadastrado();
                    System.out.print("Documento para Fila Prioritária: ");
                    gestor.inserirFilaPrioridade(leitor.nextLine());
                    break;

                case 5:

                    gestor.imprimirFilas();
                    break;

                case 6:
                    gestor.embacarPassageiro();
                    break;

                case 7:
                    gestor.exibirFilaEmbarque();
                    break;

                case 8:
                    gestor.desfazerUltimaOperacao();
                    break;

                case 9:
                    gestor.exibirHistoricoOperacoes();
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (subOpcao != 0);
    }
    private static void menuHistorico(Scanner leitor, Embarque gestor) {
        int subOpcao;

        do {
            System.out.println("\n--- HISTÓRICO DE OPERAÇÕES ---");
            System.out.println("1 - Exibir histórico completo");
            System.out.println("2 - Desfazer última operação");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            subOpcao = leitor.nextInt();
            leitor.nextLine();

            switch (subOpcao) {
                case 1:
                    gestor.exibirHistoricoOperacoes();
                    break;
                case 2:
                    gestor.desfazerUltimaOperacao();
                    break;
                case 0:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (subOpcao != 0);
    }

    private static void menuVoo(Scanner leitor, GerenciarVoo gestorVoo, GerenciarAviao gestorAviao) {
        int subOpcao;
        String codigoAviao;
        do {
            System.out.println("\n--- GERENCIAR Voo ---");
            System.out.println("1 - Cadastrar Voo ");
            System.out.println("2 - Listar Voos");
            System.out.println("3 - Buscar Voo por Código");
            System.out.println("4 - Excluir Voo por Código");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            subOpcao = leitor.nextInt();
            leitor.nextLine();

            switch (subOpcao) {
                case 1:
                    gestorAviao.listarAviaos();
                    System.out.println(" Digite o código do Avião para cadastra o Voo:");
                    codigoAviao = leitor.nextLine();
                    Aviao aviao = gestorAviao.buscarAviao(codigoAviao);
                    if (aviao != null) {
                        Voo voo = new Voo(aviao);
                        gestorVoo.CadastrarVoo(voo);
                    } else {
                        System.out.println("Erro!! avião nao encontrado!");
                    }
                    break;
                case 2:
                    gestorVoo.listarVoos();
                    break;
                case 3:
                    System.out.print("Digite o código do Voo: ");
                    String codigoBusca = leitor.nextLine();
                    Voo vooEncontrado = gestorVoo.procuraVoo(codigoBusca);
                    if (vooEncontrado != null) {
                        System.out.println("Voo encontrado: " + vooEncontrado);
                    } else {
                        System.out.println("Voo não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o código do Voo: ");
                    String codigo = leitor.nextLine();
                    if (gestorVoo.cancelarVoo(codigo)) {
                        System.out.println("Voo removido!");
                    } else {
                        System.out.println("Erro: Voo não encontrado.");
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
}

