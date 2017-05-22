package cityproject.etrevivant;

import java.util.Date;
import cityproject.etrevivant.role.Locataire;
import cityproject.etrevivant.role.Proprietaire;
import cityproject.infrastructures.Quartier;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.BienImmobilier;

public class Humain extends EtreVivant implements Locataire, Proprietaire {
	
	private Boolean aunBienImmobilier;
	private Boolean aunFoyer;
	
	
	public Humain() {
		// TODO Auto-generated constructor stub
	}
	
	public Boolean getAunBienImmobilier() {
		return aunBienImmobilier;
	}

	public void setAunBienImmobilier(Boolean aunBienImmobilier) {
		this.aunBienImmobilier = aunBienImmobilier;
	}

	public Boolean getAunFoyer() {
		return aunFoyer;
	}

	public void setAunFoyer(Boolean aunFoyer) {
		this.aunFoyer = aunFoyer;
	}

	@Override
	public void PossederLogement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PossederBiens() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OccuperLogement() {
		// TODO Auto-generated method stub
		
	}


}
