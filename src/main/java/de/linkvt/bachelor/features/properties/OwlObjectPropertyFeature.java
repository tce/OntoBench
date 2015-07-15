package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.web.converters.parameter.ParameterName;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * An owl object property.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
@ParameterName("objectprop")
public class OwlObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("ObjectProperty");
    OWLClass range = featurePool.getExclusiveClass("ObjectPropertyRange");

    addToGenericDomainAndNewRange(objectProperty, range);
  }
}