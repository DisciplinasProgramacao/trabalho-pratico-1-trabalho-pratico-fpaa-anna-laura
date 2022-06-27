import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivo {
    public Lamina testaLeitura(boolean retorno, File file) {

        boolean isPrimeiraLamina = true;
        Scanner sc = null;
        List<Lamina> listLamina = new ArrayList<>();
        Lamina laminaRetorno = null;
        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String laminaInit = sc.nextLine().replace("  ", " ");;
                String lamina[] = laminaInit.split(" ");
                Integer largura;
                Integer custo1;
                Integer custo2;
                Integer custo3;

                // Imprimindo valores para testar se está tudo correto!
                if (!retorno) {
                    for (String item : lamina) {
                        System.out.println("L/C1/C2/C3: " + item);
                    }

                    System.out.println("------------------");
                }
                // Imprimindo valores para testar se está tudo correto!

                if (Integer.parseInt(lamina[0]) > 6) {
                    largura = Integer.parseInt(lamina[0]);
                    custo1 = Integer.parseInt(lamina[1]);
                    custo2 = Integer.parseInt(lamina[2]);
                    custo3 = Integer.parseInt(lamina[3]);

                } else if (Integer.parseInt(lamina[0]) == 6) {
                    largura = Integer.parseInt(lamina[0]);
                    custo1 = Integer.parseInt(lamina[1]);
                    custo2 = Integer.parseInt(lamina[2]);
                    custo3 = null;
                } else {
                    largura = Integer.parseInt(lamina[0]);
                    custo1 = Integer.parseInt(lamina[1]);
                    custo2 = null;
                    custo3 = null;
                }
                if (!isPrimeiraLamina) {
                    listLamina.add(new Lamina(largura, custo1, custo2, custo3));
                } else {
                    listLamina.add(new Lamina(largura, custo1, custo2, custo3));
                    laminaRetorno = new Lamina(largura, custo1, custo2, custo3);
                    isPrimeiraLamina = false;
                }

            }

            Lamina primeiraLamina = laminaRetorno;
            if (!retorno) {
                primeiraLamina.setTabela(listLamina);
                primeiraLamina.reduzirLamina(3);
                System.out.println(primeiraLamina.getEspessura());
                System.out.println(primeiraLamina.getValorReducao1());
                System.out.println(primeiraLamina.getValorReducao2());
                System.out.println(primeiraLamina.getValorReducao3());
                System.out.println("--------------------------------");
                primeiraLamina.reduzirLamina(3);
                System.out.println(primeiraLamina.getEspessura());
                System.out.println(primeiraLamina.getValorReducao1());
                System.out.println(primeiraLamina.getValorReducao2());
                System.out.println(primeiraLamina.getValorReducao3());

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao abrir o arquivo: " + ex.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }

        }
        laminaRetorno.setTabela(listLamina);
        return laminaRetorno;

    }
}
