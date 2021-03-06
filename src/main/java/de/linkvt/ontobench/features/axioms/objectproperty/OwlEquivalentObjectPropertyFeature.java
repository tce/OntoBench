package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlEquivalentObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty p1 = featurePool.getExclusiveProperty(":equivalentObjectProperty_1");
    OWLObjectProperty p2 = featurePool.getExclusiveProperty(":equivalentObjectProperty_2");
    OWLObjectProperty p3 = featurePool.getExclusiveProperty(":equivalentObjectProperty_3");

    addAxiomToOntology(factory.getOWLEquivalentObjectPropertiesAxiom(p1, p2, p3));

    addToGenericDomainAndNewRange(p1, featurePool.getExclusiveClass(":EquivalentObjectProperty_Range1"));
    addToGenericDomainAndNewRange(p2, featurePool.getExclusiveClass(":EquivalentObjectProperty_Range2"));
    addToGenericDomainAndNewRange(p3, featurePool.getExclusiveClass(":EquivalentObjectProperty_Range3"));
  }

  @Override
  public String getName() {
    return "owl:equivalentProperty";
  }

  @Override
  public String getToken() {
    return "equivalentprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
