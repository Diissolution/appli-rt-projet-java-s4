public class Pylone {

    public Pylone(String idPylone, double[] coordGps, int nbAntennes, String[] antenneConnect, String noeudConnect){
        this.coordGps=coordGps;
        this.nbAntennes=nbAntennes;
        this.antenneConnect=antenneConnect;
        this.noeudConnect=noeudConnect;
        this.idPylone=idPylone;
    }

    //Méthodes de créations ( par cmd / interface graphique ? )
    public void creer() {
        // Création d'un pylone
    }

    public void modifier(){
        //Modification d'un pylone
    }

    public void supprimer(String idPylone){
        //Supprimer un pylone (et les antennes attachées)
    }

}