import java.util.*;

public class TestPylone {
    public static Pylone creerPylone() { // Création d'un pylône
        Scanner sc = new Scanner(System.in);
        int idPyl = Pylone.nbPylone+1;
        String idPylStr = Integer.toString(idPyl);
        ArrayList<String> antennesConnectees = new ArrayList<String>();
        
        System.out.println("Entrez la latitude:(double avec virgule)");
        double coord1 = sc.nextDouble();
        System.out.println("Entrez la longitude:(double avec virgule)");
        double coord2 = sc.nextDouble();
        
        System.out.println("Entrez le nombre d'antennes connectées:(int)");
        int nbAntennes = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Entrez les ID des antennes connectées séparés par des virgules:");
        String antennes = sc.nextLine();
        
        System.out.println("Entrez l'ID du noeud auquel le pylône est connecté:(String)");
        String idNoeud = sc.nextLine();
        
        double coords[] = {coord1,coord2};
        
        String[] antennesSeparees = antennes.split(",");
        for (int i = 0; i < antennesSeparees.length; i++) {
            antennesConnectees.add(antennesSeparees[i]);
        }
        
        
      
        Pylone x = new Pylone(idPylStr,coords,nbAntennes,antennesConnectees,idNoeud) ;
        
        sc.close(); 
        System.out.println("------ Récapitulatif du pylône créé ------");
        x.affiche();
        
        return x;
       
    }
    
    
    public static void main (String args[]){
        
    	Pylone z;
    	z = creerPylone();
    	z.modifier();
       
    }
}

