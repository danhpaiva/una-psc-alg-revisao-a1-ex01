import java.util.Scanner;

class RevisaoExUm {
  public static void main(String[] args) {
    // Declaração de Todas as Variáveis que Vamos utilizar no Algoritmo
    String nome = "", cartaoVacinaEmDia = "", teveSintomasRecentemente = "", teveContatoComPessoasSintomaticas = "",
        estaRetornandoViagem = "", orientacaoFinal = "";
    int idade, contador = 0, porcentagemInfeccao = 0;
    boolean erroTentativas = false;
    // Conforme alinhado em aula, a biblioteca Scanner é para coletarmos dados pelo
    // console
    Scanner scanner = new Scanner(System.in);

    System.out.println("\tRelatório Auxiliar de Controle de Infecções");

    System.out.println("\nInforme o seu nome: ");
    nome = scanner.nextLine();

    System.out.println("\nInforme a sua idade: ");
    idade = scanner.nextInt();

    // Começo as perguntas de sim e nao, que serão importantes na lógica de
    // porcentagem
    do {
      System.out.println("\nSeu cartão de vacina está em dia? Digite SIM ou NAO ?");
      cartaoVacinaEmDia = scanner.next().toUpperCase();
      if (cartaoVacinaEmDia.equals("SIM") || cartaoVacinaEmDia.equals("NAO")) {
        break;
      } else {
        contador++;
        System.out.println("\nDigito inválido! Digite 'SIM' ou 'NAO'.");
        if (contador == 3) {
          erroTentativas = true;
          break;
        }
      }
    } while (true);

    // Reseto o contador porque vamos utilizá-lo novamente
    contador = 0;

    // Valido se continuo perguntando ou se vou direto para a mensagem final
    if (erroTentativas == false) {
      do {
        System.out
            .println("\nTeve algum dos sintomas recentemente? (dor de cabeça, febre, náusea, dor articular, gripe)" +
                "Digite SIM ou NAO");
        teveSintomasRecentemente = scanner.next().toUpperCase();
        if (teveSintomasRecentemente.equals("SIM") || teveSintomasRecentemente.equals("NAO")) {
          break;
        } else {
          contador++;
          System.out.println("\nDigito inválido! Digite SIM ou NAO.");
          if (contador == 3) {
            erroTentativas = true;
            break;
          }
        }
      } while (true);
    }

    // Reseto o contador porque vamos utilizá-lo novamente
    contador = 0;

    if (erroTentativas == false) {

      do {
        System.out
            .println("\nTeve contato com pessoas com sintomas gripais nos últimos dias?" +
                "Digite SIM ou NAO");
        teveContatoComPessoasSintomaticas = scanner.next().toUpperCase();
        if (teveContatoComPessoasSintomaticas.equals("SIM") || teveContatoComPessoasSintomaticas.equals("NAO")) {
          break;
        } else {
          contador++;
          System.out.println("\nDigito inválido! Digite SIM ou NAO.");
          if (contador == 3) {
            erroTentativas = true;
            break;
          }
        }
      } while (true);
    }

    // Reseto o contador porque vamos utilizá-lo novamente
    contador = 0;

    if (erroTentativas == false) {
      do {
        System.out
            .println("\nEstá retornando de viagem realizada no exterior?" +
                "Digite SIM ou NAO");
        estaRetornandoViagem = scanner.next().toUpperCase();
        if (estaRetornandoViagem.equals("SIM") || estaRetornandoViagem.equals("NAO")) {
          break;
        } else {
          contador++;
          System.out.println("\nDigito inválido! Digite SIM ou NAO.");
          if (contador == 3) {
            erroTentativas = true;
            break;
          }
        }
      } while (true);
    }

    scanner.close();

    // Valido se imprimo a mensagem de erro baseado se a pessoa erro em suas
    // tentativas
    if (erroTentativas == true) {
      System.out.println("Não foi possível realizar o diagnóstico." +
          "Gentileza procurar ajuda médica caso apareça algum sintoma.");
    } else {

      // Começo a incrementar a probabilidade/porcentagem de acordo com as perguntas
      if (estaRetornandoViagem.equals("SIM")) {
        porcentagemInfeccao += 30;
        orientacaoFinal = "Você ficará sob observação por 05 dias.";
      }

      if (cartaoVacinaEmDia.equals("NAO")) {
        porcentagemInfeccao += 10;
      }

      if (teveSintomasRecentemente.equals("SIM")) {
        porcentagemInfeccao += 30;
      }

      if (teveContatoComPessoasSintomaticas.equals("SIM")) {
        porcentagemInfeccao += 30;
      }

      // Verifico se a pessoa está retornando de viagem
      if (estaRetornandoViagem.equals("SIM")) {
        System.out.println("\nNome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Cartão Vacinal em Dia: " + cartaoVacinaEmDia);
        System.out.println("Teve sintomas recentemente: " + teveSintomasRecentemente);
        System.out.println("Teve contato com pessoas infectadas: " + teveContatoComPessoasSintomaticas);
        System.out.println("Esta retornando de viagem: " + estaRetornandoViagem);
        System.out.println("Porcentagem infecção: " + porcentagemInfeccao);
        System.out.println("Orientação Final: " + orientacaoFinal);
      } else {

        // Verifico a porcentagem de infecção para imprimir a orientação final de acordo
        // com a porcentagem
        if (porcentagemInfeccao >= 90) {
          orientacaoFinal = "Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado.";
          System.out.println("\nNome: " + nome);
          System.out.println("Idade: " + idade + " anos");
          System.out.println("Cartão Vacinal em Dia: " + cartaoVacinaEmDia);
          System.out.println("Teve sintomas recentemente: " + teveSintomasRecentemente);
          System.out.println("Teve contato com pessoas infectadas: " + teveContatoComPessoasSintomaticas);
          System.out.println("Esta retornando de viagem: " + estaRetornandoViagem);
          System.out.println("Porcentagem infecção: " + porcentagemInfeccao);
          System.out.println("Orientação Final: " + orientacaoFinal);
        } else if (porcentagemInfeccao <= 30) {
          orientacaoFinal = "Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica.";
          System.out.println("\nNome: " + nome);
          System.out.println("Idade: " + idade + " anos");
          System.out.println("Cartão Vacinal em Dia: " + cartaoVacinaEmDia);
          System.out.println("Teve sintomas recentemente: " + teveSintomasRecentemente);
          System.out.println("Teve contato com pessoas infectadas: " + teveContatoComPessoasSintomaticas);
          System.out.println("Esta retornando de viagem: " + estaRetornandoViagem);
          System.out.println("Porcentagem infecção: " + porcentagemInfeccao);
          System.out.println("Orientação Final: " + orientacaoFinal);
        } else if (porcentagemInfeccao <= 60) {
          orientacaoFinal = "Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.";
          System.out.println("\nNome: " + nome);
          System.out.println("Idade: " + idade + " anos");
          System.out.println("Cartão Vacinal em Dia: " + cartaoVacinaEmDia);
          System.out.println("Teve sintomas recentemente: " + teveSintomasRecentemente);
          System.out.println("Teve contato com pessoas infectadas: " + teveContatoComPessoasSintomaticas);
          System.out.println("Esta retornando de viagem: " + estaRetornandoViagem);
          System.out.println("Porcentagem infecção: " + porcentagemInfeccao);
          System.out.println("Orientação Final: " + orientacaoFinal);
        }
        // Agora é o cenário entre 70% e 90%, diagnosticado na prática feita em aula
        else {
          orientacaoFinal = "Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.";
          System.out.println("\nNome: " + nome);
          System.out.println("Idade: " + idade + " anos");
          System.out.println("Cartão Vacinal em Dia: " + cartaoVacinaEmDia);
          System.out.println("Teve sintomas recentemente: " + teveSintomasRecentemente);
          System.out.println("Teve contato com pessoas infectadas: " + teveContatoComPessoasSintomaticas);
          System.out.println("Esta retornando de viagem: " + estaRetornandoViagem);
          System.out.println("Porcentagem infecção: " + porcentagemInfeccao);
          System.out.println("Orientação Final: " + orientacaoFinal);
        }
      }
    }
  }
}