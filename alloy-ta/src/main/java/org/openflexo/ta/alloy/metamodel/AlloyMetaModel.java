/**
 * 
 * Copyright (c) 2013-2014, Openflexo
 * Copyright (c) 2012, THALES SYSTEMES AEROPORTES - All Rights Reserved
 * Copyright (c) 2012-2012, AgileBirds
 * 
 * This file is part of Alloyconnector, a component of the software infrastructure 
 * developed at Openflexo.
 * 
 * 
 * Openflexo is dual-licensed under the European Union Public License (EUPL, either 
 * version 1.1 of the License, or any later version ), which is available at 
 * https://joinup.ec.europa.eu/software/page/eupl/licence-eupl
 * and the GNU General Public License (GPL, either version 3 of the License, or any 
 * later version), which is available at http://www.gnu.org/licenses/gpl.html .
 * 
 * You can redistribute it and/or modify under the terms of either of these licenses
 * 
 * If you choose to redistribute it and/or modify under the terms of the GNU GPL, you
 * must include the following additional permission.
 *
 *          Additional permission under GNU GPL version 3 section 7
 *
 *          If you modify this Program, or any covered work, by linking or 
 *          combining it with software containing parts covered by the terms 
 *          of EPL 1.0, the licensors of this Program grant you additional permission
 *          to convey the resulting work. * 
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE. 
 *
 * See http://www.openflexo.org/license.html for details.
 * 
 * 
 * Please contact Openflexo (openflexo-contacts@openflexo.org)
 * or visit www.openflexo.org if you need additional information.
 * 
 */

package org.openflexo.ta.alloy.metamodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openflexo.foundation.ontology.FlexoOntologyObjectImpl;
import org.openflexo.foundation.ontology.IFlexoOntology;
import org.openflexo.foundation.ontology.IFlexoOntologyAnnotation;
import org.openflexo.foundation.ontology.IFlexoOntologyClass;
import org.openflexo.foundation.ontology.IFlexoOntologyConcept;
import org.openflexo.foundation.ontology.IFlexoOntologyContainer;
import org.openflexo.foundation.ontology.IFlexoOntologyDataProperty;
import org.openflexo.foundation.ontology.IFlexoOntologyDataType;
import org.openflexo.foundation.ontology.IFlexoOntologyIndividual;
import org.openflexo.foundation.ontology.IFlexoOntologyObjectProperty;
import org.openflexo.foundation.ontology.IFlexoOntologyStructuralProperty;
import org.openflexo.foundation.technologyadapter.FlexoMetaModel;
import org.openflexo.ta.alloy.AlloyTechnologyAdapter;
import org.openflexo.ta.alloy.rm.AlloyMetaModelResource;

/**
 * Alloy MetaModel seen as a Flexo Ontology.
 * 
 * @author gbesancon
 */
public class AlloyMetaModel extends FlexoOntologyObjectImpl<AlloyTechnologyAdapter>
		implements FlexoMetaModel<AlloyMetaModel>, IFlexoOntology<AlloyTechnologyAdapter> {
	/** MetaModel Resource. */
	protected AlloyMetaModelResource metaModelResource;
	/** Adapter. */
	protected final AlloyTechnologyAdapter adapter;
	/** Package. */
	// protected final EPackage ePackage;
	/** Converter. */
	// protected final AlloyMetaModelConverter converter;
	
	private Map<String, IFlexoOntologyClass<AlloyTechnologyAdapter>> classMap = null;

	/**
	 * Constructor.
	 */
	public AlloyMetaModel(
		// AlloyMetaModelConverter converter, EPackage ePackage,
		 AlloyTechnologyAdapter adapter) {
		this.adapter = adapter;
		// this.ePackage = ePackage;
		// this.converter = converter;

	}
	
	private void ensureclassMap() {
	    if (classMap == null) {
	        classMap = new HashMap<>();
	        for (IFlexoOntologyClass<AlloyTechnologyAdapter> aClass : getClasses()) {
	            if (aClass.getURI() != null) {
	                classMap.put(aClass.getURI().toLowerCase(), aClass);
	            }
	            if (aClass.getName() != null) {
	                classMap.put(aClass.getName().toLowerCase(), aClass);
	            }
	        }
	    }
	}


	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getName()
	 */
	@Override
	public String getName() {
		// return ePackage.getName();
		//TODO
		return "";
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyObject#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) throws Exception {
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getURI()
	 */
	@Override
	public String getURI() {
		//TODO
		return "";
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getVersion()
	 */
	@Override
	public String getVersion() {
		return null;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDescription()
	 */
	@Override
	public String getDescription() {
		return null;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.FlexoOntologyObjectImpl#getDisplayableDescription()
	 */
	@Override
	public String getDisplayableDescription() {
		return getDescription();
	}

	/**
	 * Getter of converter.
	 * 
	 * @return the converter value
	 */
	// public AlloyMetaModelConverter getConverter() {
	// 	return converter;
	// }

	// public EPackage getRootPackage() {
	// 	return ePackage;
	// }

	@Override
	public AlloyMetaModelResource getResource() {
		return metaModelResource;
	}

	@Override
	public void setResource(org.openflexo.foundation.resource.FlexoResource<AlloyMetaModel> resource) {
		metaModelResource = (AlloyMetaModelResource) resource;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.technologyadapter.FlexoMetaModel#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() {
		return true;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.technologyadapter.FlexoMetaModel#setIsReadOnly(boolean)
	 */
	@Override
	public void setIsReadOnly(boolean b) {
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getRootConcept()
	 */
	@Override
	public IFlexoOntologyClass<AlloyTechnologyAdapter> getRootConcept() {
		return null;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getImportedOntologies()
	 */
	@Override
	public List<IFlexoOntology<AlloyTechnologyAdapter>> getImportedOntologies() {
		return Collections.emptyList();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getSubContainers()
	 */
	// @Override
	// public List<AlloyPackageContainer> getSubContainers() {
	// 	return Collections.singletonList(converter.convertPackage(this, ePackage));
	// }

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.technologyadapter.FlexoMetaModel#getObject(java.lang.String)
	 */
	@Override
	public Object getObject(String objectURI) {
		return getOntologyObject(objectURI);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getOntologyObject(java.lang.String)
	 */
	@Override
	public IFlexoOntologyConcept<AlloyTechnologyAdapter> getOntologyObject(String objectNameOrURI) {
		for (IFlexoOntologyConcept<AlloyTechnologyAdapter> concept : getConcepts()) {
			if (concept.getURI().equalsIgnoreCase(objectNameOrURI)) {
				return concept;
			}
		}
		for (IFlexoOntologyConcept<AlloyTechnologyAdapter> concept : getConcepts()) {
			if (concept.getName().equalsIgnoreCase(objectNameOrURI)) {
				return concept;
			}
		}
		return null;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDeclaredOntologyObject(java.lang.String)
	 */
	@Override
	public IFlexoOntologyConcept<AlloyTechnologyAdapter> getDeclaredOntologyObject(String objectURI) {
		return null;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getAnnotations()
	 */
	@Override
	public List<IFlexoOntologyAnnotation> getAnnotations() {
		List<IFlexoOntologyAnnotation> annotations = null;
		//TODO
		// if (ePackage.getEAnnotations() != null && ePackage.getEAnnotations().size() != 0) {
		// 	annotations = new ArrayList<>();
		// 	for (EAnnotation annotation : ePackage.getEAnnotations()) {
		// 		annotations.add(this.getConverter().convertAnnotation(this, annotation));
		// 	}
		// }
		// else {
		// 	annotations = Collections.emptyList();
		// }
		return annotations;
	}

	/**
	 * 
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getDataTypes()
	 */
	@Override
	public List<IFlexoOntologyDataType<AlloyTechnologyAdapter>> getDataTypes() {
		List<IFlexoOntologyDataType<AlloyTechnologyAdapter>> result = new ArrayList<>();
		//TODO
		// for (IFlexoOntologyDataType<AlloyTechnologyAdapter> dataType : converter.getDataTypes().values()) {
		// 	result.add(dataType);
		// }
		return Collections.unmodifiableList(result);
	}

	/**
	 * 
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getConcepts()
	 */
	@Override
	public List<IFlexoOntologyConcept<AlloyTechnologyAdapter>> getConcepts() {
		List<IFlexoOntologyConcept<AlloyTechnologyAdapter>> result = new ArrayList<>();
		result.addAll(getClasses());
		result.addAll(getIndividuals());
		result.addAll(getDataProperties());
		result.addAll(getObjectProperties());
		return Collections.unmodifiableList(result);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getClasses()
	 */
	@Override
	public List<? extends IFlexoOntologyClass<AlloyTechnologyAdapter>> getClasses() {
	    List<IFlexoOntologyClass<AlloyTechnologyAdapter>> result = new ArrayList<>();
	    //TODO
		// for (AlloyClassClass aClass : converter.getClasses().values()) {
	    //     result.add(aClass);
	    // }

	    // for (AlloyEnumClass aClass : converter.getEnums().values()) {
	    //     result.add(aClass);
	    // }

	    return Collections.unmodifiableList(result);
	}


	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getClass(java.lang.String)
	 */
	@Override
	public IFlexoOntologyClass<AlloyTechnologyAdapter> getClass(String classNameOrURI) {
	    if (classNameOrURI == null) {
	        return null;
	    }
	    ensureclassMap();
	    return classMap.get(classNameOrURI.toLowerCase());
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDeclaredClass(java.lang.String)
	 */
	@Override
	public IFlexoOntologyClass<AlloyTechnologyAdapter> getDeclaredClass(String classURI) {
		return getClass(classURI);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getAccessibleClasses()
	 */
	@Override
	public List<? extends IFlexoOntologyClass<AlloyTechnologyAdapter>> getAccessibleClasses() {
		return getClasses();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getIndividuals()
	 */
	@Override
	public List<IFlexoOntologyIndividual<AlloyTechnologyAdapter>> getIndividuals() {
		List<IFlexoOntologyIndividual<AlloyTechnologyAdapter>> result = new ArrayList<>();
		//TODO
		// for (IFlexoOntologyIndividual<AlloyTechnologyAdapter> individual : converter.getEnumLiterals().values()) {
		// 	result.add(individual);
		// }
		return Collections.unmodifiableList(result);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getIndividual(java.lang.String)
	 */
	@Override
	public IFlexoOntologyIndividual<AlloyTechnologyAdapter> getIndividual(String individualURI) {
		IFlexoOntologyIndividual<AlloyTechnologyAdapter> result = null;
		for (IFlexoOntologyIndividual<AlloyTechnologyAdapter> individual : getIndividuals()) {
			if (individual.getURI().equalsIgnoreCase(individualURI)) {
				result = individual;
			}
		}
		return result;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDeclaredIndividual(java.lang.String)
	 */
	@Override
	public IFlexoOntologyIndividual<AlloyTechnologyAdapter> getDeclaredIndividual(String individualURI) {
		return null;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getAccessibleIndividuals()
	 */
	@Override
	public List<? extends IFlexoOntologyIndividual<AlloyTechnologyAdapter>> getAccessibleIndividuals() {
		return getIndividuals();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getProperty(java.lang.String)
	 */
	@Override
	public IFlexoOntologyStructuralProperty<AlloyTechnologyAdapter> getProperty(String objectURI) {
		IFlexoOntologyStructuralProperty<AlloyTechnologyAdapter> result = getDataProperty(objectURI);
		if (result == null) {
			result = getObjectProperty(objectURI);
		}
		return result;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDeclaredProperty(java.lang.String)
	 */
	@Override
	public IFlexoOntologyStructuralProperty<AlloyTechnologyAdapter> getDeclaredProperty(String objectURI) {
		return getProperty(objectURI);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getDataProperties()
	 */
	@Override
	public List<IFlexoOntologyDataProperty<AlloyTechnologyAdapter>> getDataProperties() {
		List<IFlexoOntologyDataProperty<AlloyTechnologyAdapter>> result = new ArrayList<>();
		//TODO
		// for (IFlexoOntologyDataProperty<AlloyTechnologyAdapter> dataProperty : converter.getDataAttributes().values()) {
		// 	result.add(dataProperty);
		// }
		return Collections.unmodifiableList(result);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getDataProperty(java.lang.String)
	 */
	@Override
	public IFlexoOntologyDataProperty<AlloyTechnologyAdapter> getDataProperty(String propertyURI) {
		IFlexoOntologyDataProperty<AlloyTechnologyAdapter> result = null;
		for (IFlexoOntologyDataProperty<AlloyTechnologyAdapter> dataProperty : getDataProperties()) {
			if (dataProperty.getURI().equalsIgnoreCase(propertyURI)) {
				result = dataProperty;
				break;
			}
		}
		return result;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDeclaredDataProperty(java.lang.String)
	 */
	@Override
	public IFlexoOntologyDataProperty<AlloyTechnologyAdapter> getDeclaredDataProperty(String propertyURI) {
		return getDataProperty(propertyURI);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getAccessibleDataProperties()
	 */
	@Override
	public List<? extends IFlexoOntologyDataProperty<AlloyTechnologyAdapter>> getAccessibleDataProperties() {
		return getDataProperties();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getObjectProperties()
	 */
	@Override
	public List<? extends IFlexoOntologyObjectProperty<AlloyTechnologyAdapter>> getObjectProperties() {
		List<IFlexoOntologyObjectProperty<AlloyTechnologyAdapter>> result = new ArrayList<>();
		//TODO
		// for (IFlexoOntologyObjectProperty<AlloyTechnologyAdapter> objectProperty : converter.getObjectAttributes().values()) {
		// 	result.add(objectProperty);
		// }
		// for (IFlexoOntologyObjectProperty<AlloyTechnologyAdapter> objectProperty : converter.getReferences().values()) {
		// 	result.add(objectProperty);
		// }
		return Collections.unmodifiableList(result);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getObjectProperty(java.lang.String)
	 */
	@Override
	public IFlexoOntologyObjectProperty<AlloyTechnologyAdapter> getObjectProperty(String propertyURI) {
		IFlexoOntologyObjectProperty<AlloyTechnologyAdapter> result = null;
		for (IFlexoOntologyObjectProperty<AlloyTechnologyAdapter> objectProperty : getObjectProperties()) {
			if (objectProperty.getURI().equalsIgnoreCase(propertyURI)) {
				result = objectProperty;
			}
		}
		return result;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getAccessibleObjectProperties()
	 */
	@Override
	public List<? extends IFlexoOntologyObjectProperty<AlloyTechnologyAdapter>> getAccessibleObjectProperties() {
		return getObjectProperties();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDeclaredObjectProperty(java.lang.String)
	 */
	@Override
	public IFlexoOntologyObjectProperty<AlloyTechnologyAdapter> getDeclaredObjectProperty(String propertyURI) {
		return getObjectProperty(propertyURI);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.technologyadapter.FlexoMetaModel#getTechnologyAdapter()
	 */
	@Override
	public AlloyTechnologyAdapter getTechnologyAdapter() {
		return adapter;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.FlexoOntologyObjectImpl#getFlexoOntology()
	 */
	@Override
	public IFlexoOntology<AlloyTechnologyAdapter> getFlexoOntology() {
		return this;
	}

	@Override
	public String toString() {
		return "AlloyMetaModel:" + getURI();
	}

	@Override
	public List<? extends IFlexoOntologyContainer<AlloyTechnologyAdapter>> getSubContainers() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getSubContainers'");
	}
}
