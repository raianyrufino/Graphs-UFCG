package exercicioPratico02;

import org.jgrapht.io.CSVFormat;
import java.util.Scanner;

public class JogoDaHierarquia {

    public static void main(String[] args) {

        OurGraph graph = new OurGraph("C:\\Users\\Iago Tito\\git\\GraphTheory-JGraphT\\src\\main\\java\\exercicioPratico02\\tree.csv", CSVFormat.MATRIX);

        Boolean gotIt = false;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira o número máximo de tentativas: ");
        int maxHints = sc.nextInt();
        sc.nextLine();

        try {
        	
            int i = 1;
            while (i <= maxHints) {
            	System.out.print("\nInsira seu palpite: ");
                String hint = sc.nextLine();

                if (graph.isGraphRoot(hint)) {
                	
                	System.out.println("\nVocê acertou!");
                	System.out.println(graph.getDirectdGraph());
                	
                    gotIt = true;
                    break;
                }
                
                else {
                	System.out.println(hint + " não é raiz. O pai de " + hint + " é " +
                            graph.getPredecessor(hint) + 
                            " e os filhos de " + hint + " são " + graph.getSucessors(hint));
                }

                i++;
            }

            if (!gotIt) {
                System.out.println("\nNúmero de tentativas excedido!");
                System.out.println("A raíz do grafo era: " + graph.getGraphRoot());
                System.out.println(graph.getDirectdGraph());
            }


        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        
        sc.close();

    }
	
}
