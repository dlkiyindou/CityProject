package cityproject.infrastructures;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cityproject.etrevivant.EtreVivant;
import cityproject.etrevivant.Humain;
import cityproject.etrevivant.role.Proprietaire;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointM;


public class Batiment extends Infrastructure implements Propriete{
	private TypeBatimentEnum type;
	private Set<FonctionBatimentEnum> fonctions;
	private CoordonneesGeographiques<PointM> coordonnees;
	private Set<Lot> listeLot;
	private Map<Integer,Subdivision> listeDesSubdivisions;
	private Set<Proprietaire> listeProprietaires;
	private Set<EtreVivant> etresvivantsDansBatiment;
	
	
	/**
	 * constructeur avec parametre
	 * @param type
	 */
	public Batiment (TypeBatimentEnum type, Collection<FonctionBatimentEnum> fonctions){
		setType(type);	
		setFonctions(fonctions);
	}
	
	public Batiment (TypeBatimentEnum type, Collection<Lot> listeLot, Collection<Proprietaire> listeProprietaires){
		setType(type);
		
	}


	@Override
	public List<Proprietaire> listeProprietaires() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public TypeBatimentEnum getType() {
		return type;
	}

	public void setType(TypeBatimentEnum type) {
		this.type = type;
	}

	public Set<Lot> getListeLot() {
		return listeLot;
	}

	public void setListLot(Collection<Lot> listeLot) {
		this.listeLot = new HashSet<>(listeLot);
	}

	public Set<Proprietaire> getListeProprietaires() {
		return listeProprietaires;
	}

	public void setListeProprietaires(Collection<Proprietaire> listeProprietaires) {
		this.listeProprietaires = new HashSet<>(listeProprietaires);
	}

	public Set<EtreVivant> getPersonnesDansBatiment() {
		return etresvivantsDansBatiment;
	}

	public void setPersonnesDansBatiment(Collection<Humain> personnesDansBatiment) {
		this.etresvivantsDansBatiment = new HashSet<>(personnesDansBatiment);
	}

	public Map<Integer,Subdivision> getListeDesSubdivisions() {
		return listeDesSubdivisions;
	}

	public void setListeDesSubdivisions(Map<Integer,Subdivision> listeDesSubdivisions) {
		this.listeDesSubdivisions = listeDesSubdivisions;
	}




	public CoordonneesGeographiques<PointM> getCoordonnees() {
		return coordonnees;
	}




	public void setCoordonnees(CoordonneesGeographiques<PointM> coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Set<FonctionBatimentEnum> getFonctions() {
		return fonctions;
	}

	public void setFonctions(Collection<FonctionBatimentEnum> fonctions) {
		this.fonctions = new HashSet<>(fonctions);
	}
	
	
	public void entrer(EtreVivant etreVivant) {
		if (!etresvivantsDansBatiment.contains(etreVivant))
		etresvivantsDansBatiment.add(etreVivant);
	}
	
	public void fairesortir(EtreVivant etreVivant) {
		if (etresvivantsDansBatiment.contains(etreVivant))
			etresvivantsDansBatiment.remove(etreVivant);
	}
}
//just to commit
