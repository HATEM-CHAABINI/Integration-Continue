package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEntrepriseService;



@SpringBootTest

 class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService es;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	IDepartementService id;
	
	@Test
	 void ajouterEntrepriseTest() {
	Entreprise ent = new Entreprise("eeprise1", "raient1");
	ent.setId(2);
	//es.ajouterEntreprise(ent);
	assertEquals(2,es.ajouterEntreprise(ent) );
		
	}
	@Test
	 void ajouterDepartementTest() {
		Departement dep = new Departement("Dep1");
		dep.setId(1);
	//	es.ajouterDepartement(dep);
		assertEquals(1,es.ajouterDepartement(dep) );

	}
	
	
	@Test
	 void affecterDepartementAEntrepriseTest() {
		
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
	 void getAllDepartementsNamesByEntrepriseTest() {
		List <String> ls = new ArrayList<>();
		ls.add("Dep4");
		ls.add("Dep5");
		ls.add("Dep6");
		List <String> lss = new ArrayList<>();
		lss= es.getAllDepartementsNamesByEntreprise(5);

		assertEquals(lss, ls);
	}

	
	@Test
	 void getEntrepriseByIdTest() {
		Entreprise tesent = new Entreprise();
		tesent = es.getEntrepriseById(7);
		assertEquals(7, tesent.getId());
	}
}
