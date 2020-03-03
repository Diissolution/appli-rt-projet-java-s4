import java.util.*;

public class TestPylone {
    public void creer() { // Création d'un pylone
        Scanner sc = new Scanner(System.in);
        double coords[] = new double[2];
        int idPyl = Pylone.nbPylone+1;
        ArrayList<String> antennesConnectees = new ArrayList<String>();
        
        System.out.println("Entrez la latitude:(double)");
        double coord1 = sc.nextDouble();
        System.out.println("Entrez la longitude:(double)");
        double coord2 = sc.nextDouble();
        
        System.out.println("Entrez le nombre d'antennes connectées:(int)");
        double nbAntennes = sc.nextInt();
        
        System.out.println("Entrez les ID des antennes connectées séparés par des virgules:");
        double antennes = sc.nextLine();
        
        System.out.println("Entrez l'ID du noeud auquel le pylone est connecté:(String)");
        double idNoeud = sc.nextString();
        
        coord[] = {coord1,coord2};
        String[] antennesSeparees = antennes.split(",");
        
        for (int i = 0; i < antennesSeparees.length; i++) {
            antennesConnectees.add(antennesSeparees[i]);
        }
        
        
        Pylone x = new Pylone(idPyl.toString(),coords,nbAntennes,antennesConnectees,idNoeud) ;
        
        
    }
    
    
    public static void main (String args[]){
        
        
       
    }
}

