import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Gramatica {

    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        Scanner s = new Scanner(System.in);

        int valorDigitado = 0;
        boolean sucesso = false;
        String numero;

        System.out.println("---Selecione a setenca--- \n1-(S -> Asd|AsD)\n2-(S -> Asd|ASd|aSD)\n3-(S -> aaDs|aSdA|ADSds|aDsDs)\n-------------------------");

        do {
            numero = s.next();
            try {
                valorDigitado = Integer.parseInt(numero);
                sucesso = true;
            } catch (NumberFormatException e) {
                System.out.println("Isso não é um número!");
            }
        } while (!sucesso);

        System.out.println("-------------------------");

        System.out.println("****Resultado da sentenca****\n");

        Random randomic = new Random();

        switch (valorDigitado) {
            case 1: {
                String prod1 = "Asd|AsD";
                String[] producao1 = prod1.split("\\|");
                int indexVetor = randomic.nextInt(producao1.length);

                producao1 = alteraCaractare(producao1, indexVetor);
                System.out.println("-" + producao1[indexVetor]);
                break;
            }

            case 2: {
                String prod2 = "Asd|ASd|aSD";
                String[] producao2 = prod2.split("\\|");
                int tam2 = producao2.length;
                int indexVetor = randomic.nextInt(tam2);
                System.out.println("-" + producao2[indexVetor]);
                break;
            }
            case 3: {
                String prod3 = "aaDs|aSdA|ADSds|aDsDs";
                String[] producao3 = prod3.split("\\|");
                int tam3 = producao3.length;
                int indexVetor = randomic.nextInt(tam3);
                System.out.println("-" + producao3[indexVetor]);
                break;
            }
            default:
                System.out.println("Não existe essa opção!");
                break;
        }
    }

    public static String[] alteraCaractare(String[] producao, int indexVetor) {

        final String gramaticaA = "aaD|aEs";
        final String gramaticaD = "Sae|FaD|ADd";
        final String gramaticaE = "asE|wWa|wAw";
        final String gramaticaW = "aaA|DaE|awA";
        Random randomic = new Random();

        for (int i = 0; i < producao[indexVetor].length(); i++) {
            char caractere = producao[indexVetor].charAt(i);
            if (Character.getType(caractere) == Character.UPPERCASE_LETTER) {
                // TERMINAL
                switch (caractere) {
                    case 'A': {
                        String[] gramatica = gramaticaA.split("\\|");
                        int indexGramatica = randomic.nextInt(gramatica.length);

                        String recorteComeco = producao[indexVetor].substring(0, indexVetor);
                        String recorteFim = producao[indexVetor].substring(indexVetor);

                        if (indexVetor == 1) {
                            producao[indexVetor] = gramatica[indexGramatica] + recorteFim;
                        } else {
                            producao[indexVetor] = recorteComeco + gramatica[indexGramatica] + recorteFim;
                        }

                        break;
                    }
                    case 'D': {
                        break;
                    }
                    case 'E': {
                        break;
                    }
                    case 'W': {
                        break;
                    }
                }
            }
        }
        return producao;
    }
}
