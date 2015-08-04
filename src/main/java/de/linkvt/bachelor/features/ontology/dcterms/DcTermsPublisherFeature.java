package de.linkvt.bachelor.features.ontology.dcterms;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.features.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.vocab.Namespaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DcTermsPublisherFeature extends Feature {

  @Autowired
  private OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(IRI.create(Namespaces.DCTERMS + "publisher"));
    OWLAnnotation dcPublisher = factory.getOWLAnnotation(annotationProperty, factory.getOWLLiteral(ontologyConstants.getCreator()));

    addChangeToOntology(new AddOntologyAnnotation(ontology, dcPublisher));
  }

  @Override
  public String getName() {
    return "dcterms:publisher";
  }

  @Override
  public String getToken() {
    return "dctermspublisher";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ONTOLOGY;
  }
}
