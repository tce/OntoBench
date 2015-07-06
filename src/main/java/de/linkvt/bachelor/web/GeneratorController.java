package de.linkvt.bachelor.web;

import de.linkvt.bachelor.features.axioms.RdfsSubClassOfFeature;
import de.linkvt.bachelor.generator.OntologyGenerator;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {

  private ApplicationContext applicationContext;

  @Autowired
  public GeneratorController(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @RequestMapping(value = "/ontology")
  public OWLOntology ontology() throws OWLOntologyCreationException {
    return ontology(null);
  }

  @RequestMapping(value = "/ontology/{id}")
  public OWLOntology ontology(@PathVariable String id) throws OWLOntologyCreationException {
    OntologyGenerator generator = createGenerator();

    generator.addFeature(new RdfsSubClassOfFeature());

    return generator.generate();
  }

  private OntologyGenerator createGenerator() {
    return applicationContext.getBean(OntologyGenerator.class);
  }

}
