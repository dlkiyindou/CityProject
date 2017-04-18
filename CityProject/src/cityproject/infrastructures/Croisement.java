package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cityproject.infrastructures.geographie.Coordonnees4Points;

public class Croisement extends Infrastructure {
	private List<Rue> rues;
	
	public Croisement() {
		super();
		rues = new ArrayList<Rue>();
	}
	
	public Croisement(Rue ... _rues) throws Exception {
		this();
		setRues(_rues);
	}
	
	public Croisement(String _nom, Rue ... _rues) throws Exception {
		this(_rues);
		setNom(_nom);
	}

	public List<Rue> getRues() {
		return rues;
	}
	

	public void setRues(Rue ... _rues) throws Exception {
		if (rues.size() != 2) {
			throw new Exception("Un croisement ne peut etre qu'entre deux rues");
		}
		rues.addAll(Arrays.asList(_rues));
	}

	public void setRues(List<Rue> rues) throws Exception {
		if (rues.size() != 2) {
			throw new Exception("Un croisement ne peut etre qu'entre deux rues");
		}
		
		this.rues = rues;
	}
	
	
	public boolean asRue(Rue _rue) {
		return rues.contains(_rue);
	}

//	public Coordonnees4Points getCoordonneesCroisement() {
//		
//		return coord;
//		// TODO Auto-generated method stub
//		
//	}
	
//	public void setCroisement(){
//		
//		
//	
//	}
}
