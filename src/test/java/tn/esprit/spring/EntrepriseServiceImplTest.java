package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEntrepriseService;



@SpringBootTest

public class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService es;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	IDepartementService id;
	
	@Test
	public void ajouterEntrepriseTest() {
	Entreprise ent = new Entreprise("eeprise1", "raient1");
	ent.setId(2);
	//es.ajouterEntreprise(ent);
	assertEquals(2,es.ajouterEntreprise(ent) );
		
	}
	@Test
	public void ajouterDepartementTest() {
		Departement dep = new Departement("Dep1");
		dep.setId(1);
	//	es.ajouterDepartement(dep);
		assertEquals(1,es.ajouterDepartement(dep) );

	}
	
	
	@Test
	public void affecterDepartementAEntrepriseTest() {
		
		Departement dep = new Departement();
		es.affecterDepartementAEntreprise(6,6);
		List<Departement> ldep = new ArrayList<>();
		ldep = id.getAllDepartements();
		for (Departement temp : ldep) {
			if (temp.getId()==6)
				dep= temp;
        }

		assertEquals(6,dep.getEntreprise().getId());
	}	
	
	@Test
	public void getAllDepartementsNamesByEntrepriseTest() {
		List <String> ls = new ArrayList<>();
		ls.add("Dep4");
		ls.add("Dep5");
		ls.add("Dep6");
		List <String> lss = new ArrayList<>();
		lss= es.getAllDepartementsNamesByEntreprise(5);

		assertEquals(lss, ls);
	}

	
	@Test
	public void getEntrepriseByIdTest() {
		Entreprise tesent = new Entreprise();
		tesent = es.getEntrepriseById(7);
		assertEquals(7, tesent.getId());
	}
}
