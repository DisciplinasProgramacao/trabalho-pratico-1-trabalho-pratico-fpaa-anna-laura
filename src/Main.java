import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import entities.Lamina;
public class Main {
        public static void main(String args[]) {
            int escolha = 0;
            Scanner ler = new Scanner( System.in );
            do{
                System.out.println("---------MENU---------");
                System.out.println("Selecione de qual arquivo você deseja fazer a laminação:");
                System.out.println("1- Arquivo 1: ");
                System.out.println("2- Arquivo 2: ");
                System.out.println("3- Arquivo 3: ");
                System.out.println("4- Arquivo 4: ");
                System.out.println("5- Sair");
                escolha = ler.nextInt();
                if(escolha != 5) Menu(escolha);
            }while(escolha != 5);
        }
        public static void Menu(int escolha){
            File file = new File("src\\LaminacaoTeste"+escolha+".txt");
            int alogritmo = Algoritmo();
            if(alogritmo == 1){
                ChamaGuloso(file);
            }else if(alogritmo == 2){
                ChamaDinamica(file);
            }

        }
        public static int Algoritmo(){
            Scanner in = new Scanner( System.in );
            System.out.println("Selecione qual o algoritmo desejado:");
            System.out.println("1- Guloso: ");
            System.out.println("2- Programação Dinâmica: ");
            return in.nextInt();
        }
        public static void ChamaGuloso(File file){
            Arquivo arquivo = new Arquivo();
            Guloso guloso = new Guloso();

            Lamina lamina = arquivo.testaLeitura(true, file);
            System.out.println("Custo total: " + guloso.buscaMelhorCaso(lamina));
        }
    public static void ChamaDinamica(File file){
        Arquivo arquivo = new Arquivo();
        ProgDinamica dinamica = new ProgDinamica();
        Lamina lamina = arquivo.testaLeitura(true, file);
        System.out.println("Custo Total:" + dinamica.calculaTabela(lamina));
    }
}
