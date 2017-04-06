package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Croisement extends Infrastructure {
	private List<Rue> rues;
	
	public Croisement() {
		super();
		rues = new ArrayList<Rue>();
	}
	
	public Croisement(Rue ... _rues) {
		this();
		setRues(_rues);
	}
	
	public Croisement(String _nom, Rue ... _rues) {
		this(_rues);
		setNom(_nom);
	}

	public List<Rue> getRues() {
		return rues;
	}

	public void setRues(Rue ... _rues) {
		rues.addAll(Arrays.asList(_rues));
	}

	public void setRues(List<Rue> rues) {
		this.rues = rues;
	}
	
	public boolean addRue(Rue _rue) {
		return rues.add(_rue);
	}
	
	public boolean asRue(Rue _rue) {
		return rues.contains(_rue);
	}
}
