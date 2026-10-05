import java.util.Scanner;

public class SistemaEscolaEAD {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos cursos deseja cadastrar? ");
        int totalCursos = scanner.nextInt();
        scanner.nextLine();

        Curso[] cursos = new Curso[totalCursos];

        for (int i = 0; i < totalCursos; i++) {
            System.out.println("\nCadastro do Curso " + (i + 1));

            System.out.print("Código do curso: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nome do curso: ");
            String nome = scanner.nextLine();

            System.out.print("Duração: ");
            int duracao = scanner.nextInt();
            scanner.nextLine();

            cursos[i] = new Curso(codigo, nome, duracao);
        }

        int maxAlunosPorCurso = 50;
        Aluno[][] alunosPorCurso = new Aluno[totalCursos][maxAlunosPorCurso];
        int[] qtdPorCurso = new int[totalCursos];

        System.out.print("\nInforme a capacidade máxima de alunos: ");
        int capacidadeGeral = scanner.nextInt();
        scanner.nextLine();

        ListadeAlunos listaGeral = new ListadeAlunos(capacidadeGeral);
        int opcao = 0;

        do {
            // MENU CORRIGIDO
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Visualizar Lista de Alunos");
            System.out.println("2 - Adicionar Aluno");
            System.out.println("3 - Lançar Notas do Aluno");
            System.out.println("4 - Verificar Notas do Aluno");
            System.out.println("5 - Verificar Financeiro do Aluno");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n       RELATÓRIO DE CURSOS E ALUNOS         ");

                    for (int i = 0; i < cursos.length; i++) {
                        System.out.println("\nCurso: " + cursos[i].getNome() + " | Duração: " + cursos[i].getDuracao() + "h");
                        System.out.println("Alunos matriculados:");

                        boolean possuiAlunos = false;
                        for (int j = 0; j < alunosPorCurso[i].length; j++) {
                            if (alunosPorCurso[i][j] != null) {
                                System.out.println("- " + alunosPorCurso[i][j].getNome() + " (código " + alunosPorCurso[i][j].getCodigo() + ")");
                                possuiAlunos = true;
                            }
                        }

                        if (!possuiAlunos) {
                            System.out.println("- Nenhum aluno matriculado.");
                        }
                    }

                    listaGeral.exibirLista();
                    break;

                case 2:
                    System.out.println("\n--- Adicionar Aluno ---");

                    System.out.println("Selecione o curso para matricular o aluno:");
                    for (int i = 0; i < cursos.length; i++) {
                        System.out.println((i + 1) + " - " + cursos[i].getNome());
                    }
                    System.out.print("Opção de curso: ");
                    int indiceCurso = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (indiceCurso < 0 || indiceCurso >= totalCursos) {
                        System.out.println("-> Erro: Opção de curso inválida!");
                        break;
                    }

                    System.out.println("\nTipo de aluno:");
                    System.out.println("1 - Aluno Regular");
                    System.out.println("2 - Aluno Bolsista");
                    System.out.print("Escolha o tipo: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Código: ");
                    int codAluno = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nomeAluno = scanner.nextLine();

                    System.out.print("Data de Nascimento: ");
                    String dataNasc = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    Aluno novoAluno;

                    if (tipo == 2) {
                        System.out.print("Tipo de Bolsa (ex: Integral, 50%): ");
                        String tipoBolsa = scanner.nextLine();
                        novoAluno = new AlunoBolsista(codAluno, nomeAluno, dataNasc, email, senha, tipoBolsa);
                    } else {
                        novoAluno = new Aluno(codAluno, nomeAluno, dataNasc, email, senha);
                    }

                    if (listaGeral.adicionarAluno(novoAluno)) {
                        int pos = qtdPorCurso[indiceCurso];
                        alunosPorCurso[indiceCurso][pos] = novoAluno;
                        qtdPorCurso[indiceCurso]++;

                        System.out.println("-> Aluno matriculado com sucesso no curso " + cursos[indiceCurso].getNome() + "!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Lançar Notas ---");
                    System.out.print("Informe o código do aluno: ");
                    int codBuscarLancar = scanner.nextInt();
                    scanner.nextLine();

                    Aluno alunoLancar = listaGeral.buscarPorCodigo(codBuscarLancar);

                    if (alunoLancar == null) {
                        System.out.println("-> Erro: Aluno com código " + codBuscarLancar + " não encontrado!");
                    } else {
                        System.out.print("Digite a 1ª nota: ");
                        double n1 = scanner.nextDouble();

                        System.out.print("Digite a 2ª nota: ");
                        double n2 = scanner.nextDouble();

                        System.out.print("Digite a 3ª nota: ");
                        double n3 = scanner.nextDouble();
                        scanner.nextLine();

                        alunoLancar.lancarNotas(n1, n2, n3);
                        System.out.println("-> Notas lançadas com sucesso para o aluno " + alunoLancar.getNome() + "!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Verificar Notas do Aluno ---");
                    System.out.print("Informe o código do aluno: ");
                    int codBuscaVerificar = scanner.nextInt();
                    scanner.nextLine();

                    Aluno alunoVerificar = listaGeral.buscarPorCodigo(codBuscaVerificar);

                    if (alunoVerificar == null) {
                        System.out.println("-> Erro: Aluno com código " + codBuscaVerificar + " não encontrado!");
                    } else {
                        alunoVerificar.exibirNotas();
                    }
                    break;

                case 5:
                    System.out.println("\n--- Controle Financeiro do Aluno ---");
                    System.out.print("Informe o código do aluno: ");
                    int codBuscaFinanceiro = scanner.nextInt();
                    scanner.nextLine();

                    Aluno alunoFin = listaGeral.buscarPorCodigo(codBuscaFinanceiro);

                    if (alunoFin == null) {
                        System.out.println("-> Erro: Aluno com código " + codBuscaFinanceiro + " não encontrado!");
                    } else {
                        if (alunoFin.getMensalidades() == null) {
                            System.out.println("\nO aluno ainda não possui mensalidades cadastradas.");
                            System.out.print("Informe a quantidade de parcelas (ex: 12): ");
                            int numP = scanner.nextInt();

                            System.out.print("Informe o valor de cada parcela (R$): ");
                            double valP = scanner.nextDouble();
                            scanner.nextLine();

                            double[] vals = new double[numP];
                            for (int i = 0; i < numP; i++) {
                                vals[i] = valP;
                            }

                            alunoFin.adicionarMensalidades(vals);
                            System.out.println("-> Carnê de mensalidades gerado com sucesso!");
                        }

                        alunoFin.exibirMensalidades();

                        System.out.print("\nDeseja dar baixa em alguma parcela? (1 - Sim | 2 - Não): ");
                        int respPag = scanner.nextInt();
                        scanner.nextLine();

                        if (respPag == 1) {
                            System.out.print("Digite o número da parcela a ser paga: ");
                            int numParcela = scanner.nextInt();
                            scanner.nextLine();

                            alunoFin.pagarMensalidade(numParcela - 1);
                        }
                    }
                    break;

                case 6:
                    System.out.println("\nEncerrando o sistema...");
                    break;

                default:
                    System.out.println("-> Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 6);

        scanner.close();
    }
}