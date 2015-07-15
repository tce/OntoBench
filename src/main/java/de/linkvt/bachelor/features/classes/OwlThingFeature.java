package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.web.converters.parameter.ParameterName;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * The owl thing.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
@ParameterName("owlthing")
public class OwlThingFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlThing = factory.getOWLThing();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlThing);

    addAxiomToOntology(axiom);
  }
}