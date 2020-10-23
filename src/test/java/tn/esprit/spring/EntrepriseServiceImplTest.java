package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEntrepriseService;



@SpringBootTest

public class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService es;
	@Autowired
	DepartementRepository deptRepoistory;

	@Test
	public void ajouterEntrepriseTest() {
		

Entreprise ent = new Entreprise("eeprise1", "raient1");
	 ent.setId(2);
	 es.ajouterEntreprise(ent);
		assertEquals(2,ent.getId() );
		
	/*	Entreprise e = new Entreprise("ent1","rai");
		EntrepriseServiceImpl eS = new EntrepriseServiceImpl();
		e.setId(1);
		eS.ajouterEntreprise(e);
		assertEquals(1,e.getId() );*/
	}
}
