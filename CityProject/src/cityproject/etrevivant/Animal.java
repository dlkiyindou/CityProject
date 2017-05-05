package cityproject.etrevivant;

import cityproject.infrastructures.Quartier;

public abstract class Animal extends EtreVivant {
		private String nom;
		private Boolean aunfoyer;
		
		public Animal() {
			// TODO Auto-generated constructor stub
		}
		
		public Animal(String _nom) {
			setNom(_nom);
		}

		@Override
		public Quartier getQuartier() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Quartier getQuartierCourant() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Quartier getQuartierOrigine() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public Boolean aunfoyer() {
			return aunfoyer;
		}

		public void aunfoyer (Boolean aunfoyer) {
			this.aunfoyer = aunfoyer;
		}


	}
	