package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.web.converters.parameter.ParameterName;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * The owl nothing.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
@ParameterName("owlnothing")
public class OwlNothingFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlNothing = factory.getOWLNothing();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlNothing);

    addAxiomToOntology(axiom);
  }
}