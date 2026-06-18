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

package org.openflexo.ta.alloy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

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
import org.openflexo.foundation.resource.SaveResourceException;
import org.openflexo.foundation.technologyadapter.FlexoModel;
import org.openflexo.rm.Resource;
import org.openflexo.ta.alloy.AlloyTechnologyAdapter;
import org.openflexo.ta.alloy.metamodel.AlloyMetaModel;
import org.openflexo.ta.alloy.rm.AlloyModelResource;

/**
 * Alloy Model.
 * 
 */
public class AlloyModel extends FlexoOntologyObjectImpl<AlloyTechnologyAdapter>
		implements FlexoModel<AlloyModel, AlloyMetaModel>, IFlexoOntology<AlloyTechnologyAdapter> {

	protected static final Logger logger = Logger.getLogger(AlloyModel.class.getPackage().getName());

	/** Resource. */
	protected AlloyModelResource modelResource;
	/** MetaModel. */
	protected final AlloyMetaModel metaModel;
	/** Converter. */
	//TODO
	// protected final AlloyModelConverter converter;
	/** Resource Alloy. */
	protected final Resource resource;

	/**
	 * Constructor.
	 * 
	 * @param object
	 */
	public AlloyModel(AlloyMetaModel metaModel,
		//  AlloyModelConverter converter,
		  Resource resource) {
		this.metaModel = metaModel;
		// this.converter = converter;
		this.resource = resource;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyObject#getName()
	 */
	@Override
	public String getName() {
		// return AlloyModelURIBuilder.getName(resource);
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
		System.out.println("Name can't be modified.");
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyObject#getURI()
	 */
	@Override
	public String getURI() {
		// if (getResource() != null) {
		// 	return getResource().getURI();
		// }
		// return AlloyModelURIBuilder.getUri(resource);
		return ""; //TODO
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
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyObject#getDescription()
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
	//TODO
	// public AlloyModelConverter getConverter() {
	// 	return converter;
	// }

	/**
	 * Return the resource, as a {@link AlloyModelResource}
	 */
	@Override
	public AlloyModelResource getResource() {
		return modelResource;
	}

	@Override
	public void setResource(org.openflexo.foundation.resource.FlexoResource<AlloyModel> resource) {
		modelResource = (AlloyModelResource) resource;
	}

	/**
	 * Get Alloy Resource.
	 * 
	 * @return
	 */
	public Resource getAlloyResource() {
		return this.resource;
	}

	public void save() throws SaveResourceException {
		getResource().save();
	}

	/**
	 * Getter of metaModel.
	 * 
	 * @return the metaModel value
	 */
	@Override
	public AlloyMetaModel getMetaModel() {
		return metaModel;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getRootConcept()
	 */
	@Override
	public IFlexoOntologyClass<AlloyTechnologyAdapter> getRootConcept() {
		return metaModel.getRootConcept();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getImportedOntologies()
	 */
	@Override
	public List<IFlexoOntology<AlloyTechnologyAdapter>> getImportedOntologies() {
		return Collections.singletonList((IFlexoOntology<AlloyTechnologyAdapter>) metaModel);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getSubContainers()
	 */
	@Override
	public List<IFlexoOntologyContainer<AlloyTechnologyAdapter>> getSubContainers() {
		return Collections.emptyList();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.technologyadapter.FlexoModel#getObject(java.lang.String)
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
	public IFlexoOntologyConcept<AlloyTechnologyAdapter> getOntologyObject(String objectURI) {
		IFlexoOntologyConcept<AlloyTechnologyAdapter> result = null;
		for (IFlexoOntologyConcept<AlloyTechnologyAdapter> concept : getConcepts()) {
			if (concept.getURI().equalsIgnoreCase(objectURI)) {
				result = concept;
			}
		}
		return result;
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDeclaredOntologyObject(java.lang.String)
	 */
	@Override
	public IFlexoOntologyConcept<AlloyTechnologyAdapter> getDeclaredOntologyObject(String objectURI) {
		return getOntologyObject(objectURI);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getAnnotations()
	 */
	@Override
	public List<IFlexoOntologyAnnotation> getAnnotations() {
		return Collections.emptyList();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getDataTypes()
	 */
	@Override
	public List<IFlexoOntologyDataType<AlloyTechnologyAdapter>> getDataTypes() {
		return Collections.emptyList();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getConcepts()
	 */
	@Override
	public List<IFlexoOntologyConcept<AlloyTechnologyAdapter>> getConcepts() {
		List<IFlexoOntologyConcept<AlloyTechnologyAdapter>> concepts = new ArrayList<>();
		// concepts.addAll(getIndividuals());
		return Collections.unmodifiableList(concepts);
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getClasses()
	 */
	@Override
	public List<? extends IFlexoOntologyClass<AlloyTechnologyAdapter>> getClasses() {
		return Collections.emptyList();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getClass(java.lang.String)
	 */
	@Override
	public IFlexoOntologyClass<AlloyTechnologyAdapter> getClass(String classURI) {
		return null;
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
	// @Override
	// public List<AlloyObjectIndividual> getIndividuals() {
	// 	List<AlloyObjectIndividual> result = new ArrayList<>();
	// 	result.addAll(converter.getIndividuals().values());
	// 	return Collections.unmodifiableList(result);
	// }

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getIndividual(java.lang.String)
	 */
	// @Override
	// public AlloyObjectIndividual getIndividual(String individualURI) {
	// 	AlloyObjectIndividual result = null;
	// 	for (AlloyObjectIndividual individual : getIndividuals()) {
	// 		if (individual.getURI().equalsIgnoreCase(individualURI)) {
	// 			result = individual;
	// 		}
	// 	}
	// 	return result;
	// }

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getDeclaredIndividual(java.lang.String)
	 */
	// @Override
	// public AlloyObjectIndividual getDeclaredIndividual(String individualURI) {
	// 	return getIndividual(individualURI);
	// }

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getAccessibleIndividuals()
	 */
	// @Override
	// public List<AlloyObjectIndividual> getAccessibleIndividuals() {
	// 	return getIndividuals();
	// }

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
	public List<? extends IFlexoOntologyDataProperty<AlloyTechnologyAdapter>> getDataProperties() {
		return Collections.emptyList();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getDataProperty(java.lang.String)
	 */
	@Override
	public IFlexoOntologyDataProperty<AlloyTechnologyAdapter> getDataProperty(String propertyURI) {
		return null;
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
		return Collections.emptyList();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.ontology.IFlexoOntologyConceptContainer#getObjectProperty(java.lang.String)
	 */
	@Override
	public IFlexoOntologyObjectProperty<AlloyTechnologyAdapter> getObjectProperty(String propertyURI) {
		return null;
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
	 * @see org.openflexo.foundation.ontology.IFlexoOntology#getAccessibleObjectProperties()
	 */
	@Override
	public List<? extends IFlexoOntologyObjectProperty<AlloyTechnologyAdapter>> getAccessibleObjectProperties() {
		return getObjectProperties();
	}

	/**
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.technologyadapter.FlexoModel#getTechnologyAdapter()
	 */
	@Override
	public AlloyTechnologyAdapter getTechnologyAdapter() {
		return metaModel.getTechnologyAdapter();
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
		return "AlloyModel:" + getURI();
	}

	@Override
	public IFlexoOntologyIndividual<AlloyTechnologyAdapter> getIndividual(String arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIndividual'");
	}

	@Override
	public List<? extends IFlexoOntologyIndividual<AlloyTechnologyAdapter>> getIndividuals() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIndividuals'");
	}

	@Override
	public List<? extends IFlexoOntologyIndividual<AlloyTechnologyAdapter>> getAccessibleIndividuals() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAccessibleIndividuals'");
	}

	@Override
	public IFlexoOntologyIndividual<AlloyTechnologyAdapter> getDeclaredIndividual(String arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDeclaredIndividual'");
	}

	/**
	 * Return a list of individuals of supplied type
	 * 
	 * TODO: i think this method is really sub-optimal and requires caching strategy implementation
	 * 
	 * @param type
	 * @return
	 */
	// public List<AlloyObjectIndividual> getIndividuals(IFlexoOntologyClass<?> type) {

	// 	// System.out.println(
	// 	// "Selecting AlloyObjectIndividuals in " + getModelSlotInstance(evaluationContext).getModel() + " with type=" + getType());
	// 	List<AlloyObjectIndividual> selectedIndividuals = new ArrayList<>();
	// 	Resource resource = getAlloyResource();
	// 	/*try {
	// 		resource.load(null);
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}*/
	// 	IFlexoOntologyClass<?> flexoOntologyClass = type;
	// 	List<EObject> selectedAlloyIndividuals = new ArrayList<>();
	// 	if (flexoOntologyClass instanceof AlloyClassClass) {
	// 		TreeIterator<EObject> iterator = resource.getAllContents();
	// 		while (iterator.hasNext()) {
	// 			EObject eObject = iterator.next();
	// 			// FIXME: following commented code was written by gilles
	// 			// Seems to not working
	// 			// Replaced by following
	// 			// Gilles, could you check and explain ?
	// 			/*selectedAlloyIndividuals.addAll(EcoreUtility.getAllContents(eObject, ((AlloyClassClass) flexoOntologyClass).getObject()
	// 					.getClass()));*/
	// 			AlloyClassClass AlloyObjectIndividualType = getMetaModel().getConverter().getClasses().get(eObject.eClass());

	// 			// System.out.println("*** Found " + eObject + " type=" + AlloyObjectIndividualType + " flexoOntologyClass="
	// 			// + flexoOntologyClass + " equals=" + (AlloyObjectIndividualType.equals(flexoOntologyClass)));

	// 			if (AlloyObjectIndividualType != null && AlloyObjectIndividualType.equals(flexoOntologyClass)
	// 					|| ((AlloyClassClass) flexoOntologyClass).isSuperClassOf(AlloyObjectIndividualType)) {
	// 				selectedAlloyIndividuals.add(eObject);
	// 			}
	// 		}
	// 	}
	// 	else if (flexoOntologyClass instanceof AlloyEnumClass) {
	// 		System.err.println(
	// 				"We shouldn't browse enum individuals of type " + ((AlloyEnumClass) flexoOntologyClass).getObject().getName() + ".");
	// 	}

	// 	// System.out.println("selectedAlloyIndividuals=" + selectedAlloyIndividuals);

	// 	for (EObject eObject : selectedAlloyIndividuals) {
	// 		AlloyObjectIndividual AlloyObjectIndividual = getConverter().getIndividuals().get(eObject);
	// 		if (AlloyObjectIndividual != null) {
	// 			selectedIndividuals.add(AlloyObjectIndividual);
	// 		}
	// 		else {
	// 			logger.warning("It's weird there shoud be an existing OpenFlexo wrapper existing for Alloy Object : " + eObject.toString());
	// 			selectedIndividuals.add(getConverter().convertObjectIndividual(this, eObject));
	// 		}
	// 	}

	// 	return selectedIndividuals;

	// }

}
