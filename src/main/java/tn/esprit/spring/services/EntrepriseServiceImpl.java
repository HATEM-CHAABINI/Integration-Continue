package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		try {
			l.info("In ajouterEntreprise() : ");
			l.debug("Je vais lancer l ajout.");
		
				entrepriseRepoistory.save(entreprise);
				l.debug("Je viens de lancer la l'ajout de " + entreprise.getId());
				l.debug("Je viens de finir l'ajout .");
				l.info("Out ajouterEntreprise() without errors.");
}
		catch (Exception e) {
				l.error("erreur dans ajouterEntreprise() :"+e);
		}
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		try {
			l.info("In ajouterDepartement() : ");
			l.debug("Je vais lancer l ajout.");
		
		deptRepoistory.save(dep);
		l.debug("Je viens de lancer la l'ajout de " + dep.getId());
		l.debug("Je viens de finir l'ajout .");
		l.info("Out ajouterDepartement() without errors.");
}
catch (Exception e) {
		l.error("erreur dans ajouterDepartement() :"+e);
}
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		
		
		try {
			l.info("In affecterDepartementAEntreprise() : ");
			l.debug("je vais récupérer l'entreprise.");
		
				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				l.debug("je viens récupérer l'entreprise." + entrepriseManagedEntity.getName());
				l.debug("je vais récupérer le departement.");
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				l.debug("je viens récupérer le departement." + depManagedEntity.getName());
				l.debug("Je vais lancer l affectation.");
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
				l.debug("Je viens de finir l'affectation .");
				l.info("Out affecterDepartementAEntreprise() without errors.");
		}
		catch (Exception e) {
				l.error("erreur dans affecterDepartementAEntreprise() :"+e);
		}
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		
		List<String> depNames = new ArrayList<>();

		try {
			l.info("In getAllDepartementsNamesByEntreprise() : ");
			l.debug("je vais récupérer les departement.");
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		l.debug("Je viens de lancer la recuperation des departement de l'entreprise " + entrepriseManagedEntity.getName());
		l.debug("Je viens de finir la recuperation .");
		l.info("Out getAllDepartementsNamesByEntreprise() without errors.");
}
catch (Exception e) {
		l.error("erreur dans getAllDepartementsNamesByEntreprise() :"+e);
}
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		deptRepoistory.delete(deptRepoistory.findById(depId).get());	
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		Entreprise entrepriseManagedEntity = new Entreprise();	
		try {
			l.info("In getEntrepriseById() : ");
			l.debug("je vais récupérer l'entreprise.");
		 entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		l.debug("Je viens de lancer la recuperation de l'entreprise " + entrepriseManagedEntity.getName());
		l.debug("Je viens de finir la recuperation .");
		l.info("Out deleteDepartementById() without errors.");
}
catch (Exception e) {
		l.error("erreur dans deleteDepartementById() :"+e);
}
		return 	entrepriseManagedEntity;
	}

}
