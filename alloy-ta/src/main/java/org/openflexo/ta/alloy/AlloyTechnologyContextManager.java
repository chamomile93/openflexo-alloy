/**
 * 
 * Copyright (c) 2013-2015, Openflexo
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

package org.openflexo.ta.alloy;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.openflexo.foundation.ontology.IFlexoOntologyClass;
import org.openflexo.foundation.ontology.IndividualOfClass;
import org.openflexo.foundation.ontology.technologyadapter.FlexoOntologyTechnologyContextManager;
import org.openflexo.foundation.resource.FlexoResourceCenterService;
import org.openflexo.foundation.technologyadapter.TechnologyContextManager;
import org.openflexo.ta.alloy.rm.AlloyMetaModelResource;
import org.openflexo.ta.alloy.rm.AlloyModelResource;

public class AlloyTechnologyContextManager extends FlexoOntologyTechnologyContextManager<AlloyTechnologyAdapter> {

	
	protected static final Logger logger = Logger.getLogger(AlloyTechnologyContextManager.class.getPackage().getName());
	
	/** Stores all known metamodels where key is the URI of metamodel */
	protected Map<String, AlloyMetaModelResource> metamodels = new HashMap<>();
	/** Stores all known metamodels where key is the URI of profiles (UML) */
	// protected Map<String, JarBasedMetaModelResource> profiles = new HashMap<>();
	/** Stores all known models where key is the URI of model */
	protected Map<String, AlloyModelResource> models = new HashMap<>();
	
	/** Stores a reference to Alloy Registry instance in order to register every MM available */
	
	// protected Resource.Factory.Registry AlloyRscFactoryRegistry = Resource.Factory.Registry.INSTANCE;
	// protected EPackage.Registry AlloyPackageRegistry = EPackage.Registry.INSTANCE;
	// protected Map<String, Object> AlloyExtensionToFactoryMap;
	
	// private final ResourceSet resourceSet;
	// public final Factory ECORE_RESOURCE_FACTORY = new EcoreResourceFactoryImpl();
	// public final Factory XMI_RESOURCE_FACTORY = new XMIResourceFactoryImpl();
	
	// public AlloyTechnologyContextManager(AlloyTechnologyAdapter adapter, FlexoResourceCenterService resourceCenterService) {
		// 	super(adapter, resourceCenterService);
	// 	AlloyExtensionToFactoryMap = AlloyRscFactoryRegistry.getExtensionToFactoryMap();
	// 	// This enables working with UML Models
	// 	UMLResourcesUtil.initGlobalRegistries();
	
	// 	resourceSet = new ResourceSetImpl();
	// 	resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", ECORE_RESOURCE_FACTORY);
	// 	resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI_RESOURCE_FACTORY);
	// }
	
	public AlloyTechnologyContextManager(AlloyTechnologyAdapter adapter,
			FlexoResourceCenterService resourceCenterService) {
		super(adapter, resourceCenterService);
		//TODO Auto-generated constructor stub
	}
	
	// public ResourceSet getResourceSet() {
		// 	return resourceSet;
		// }
		
		public AlloyModelResource getModel(File modelFile) {
			return models.get(modelFile);
		}
		
		/**
		 * Called when a new meta model was registered, notify the {@link TechnologyContextManager}
		 * 
		 * @param newModel
		*/
		// public void registerMetaModel(AlloyMetaModelResource newMetaModelResource) {
			// 	String mmURI = newMetaModelResource.getURI();
			// 	AlloyMetaModelResource existingMM = metamodels.get(mmURI);
			// 	if (existingMM == null) {
				// 		registerResource(newMetaModelResource);
				// 		metamodels.put(mmURI, newMetaModelResource);
				// 		AlloyExtensionToFactoryMap.put(newMetaModelResource.getModelFileExtension(), newMetaModelResource.getAlloyResourceFactory());

	// 		if (!newMetaModelResource.getModelFileExtension().equals("ecore")) {
	// 			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(newMetaModelResource.getModelFileExtension(),
	// 					newMetaModelResource.getAlloyResourceFactory());
	// 		}

	// 		EPackage ePackage = newMetaModelResource.getPackage();
	// 		// System.out.println("******* Register " + newMetaModelResource + " rc=" + newMetaModelResource.getResourceCenter());
	// 		if (!AlloyPackageRegistry.containsKey(mmURI) && ePackage != null) {
	// 			AlloyPackageRegistry.put(mmURI, ePackage);
	// 		}
	// 		else {
	// 			logger.warning("Alloy Metamodel already exists in registry URI: " + newMetaModelResource.getURI() + " resource from: "
	// 					+ newMetaModelResource.getIODelegate().getSerializationArtefact());
	// 		}
	// 	}
	// 	else {
	// 		// TODO : xtof, manage duplicate URIs
	// 		logger.warning(" There already exists a MM with that URI => I will not register this one!");
	// 	}
	// }

	/**
	 * Called when a new profile was registered, notify the {@link TechnologyContextManager}
	 * 
	 * @param newModel
	 */
	// public void registerProfile(JarBasedMetaModelResource newMetaModelResource) {
	// 	String mmURI = newMetaModelResource.getURI();
	// 	AlloyMetaModelResource existingMM = profiles.get(mmURI);
	// 	if (existingMM == null) {
	// 		registerResource(newMetaModelResource);
	// 		profiles.put(mmURI, newMetaModelResource);
	// 		EPackage ePackage = newMetaModelResource.getPackage();
	// 		if (!AlloyPackageRegistry.containsKey(mmURI) && ePackage != null) {
	// 			AlloyPackageRegistry.put(newMetaModelResource.getURI(), ePackage);
	// 			AlloyPackageRegistry.put(ePackage.getNsPrefix(), ePackage);
	// 		}
	// 		else {
	// 			logger.warning("UML Profile already exists in registry : " + newMetaModelResource.getURI());
	// 		}
	// 	}
	// 	else {
	// 		// TODO : xtof, manage duplicate URIs
	// 		logger.warning(" There already exists a MM with that URI => I will not register this one!");
	// 	}
	// }

	/** Accessors for Profile Collection */

	// public Set<String> getAllProfileURIs() {
	// 	return profiles.keySet();
	// }

	// public Collection<AlloyMetaModelResource> getAllProfileResources() {
	// 	return Collections.unmodifiableCollection(profiles.values());
	// }

	// public AlloyMetaModelResource geProfileResourceByURI(String uri) {
	// 	return profiles.get(uri);
	// }

	/** Accessors for MetaModel Collection */

	public Set<String> getAllMetaModelURIs() {
		return metamodels.keySet();
	}

	public Collection<AlloyMetaModelResource> getAllMetaModelResources() {
		return Collections.unmodifiableCollection(metamodels.values());
	}

	public AlloyMetaModelResource getMetaModelResourceByURI(String uri) {
		return metamodels.get(uri);
	}

	// // TODO: maybe it does not need/have to be a AlloyMetaModelResource
	// public AlloyMetaModelResource getProfileResourceByURI(String uri) {
	// 	return profiles.get(uri);
	// }

	/**
	 * Called when a new model is registered, notify the {@link TechnologyContextManager}
	 * 
	 * @param newModel
	 */
	public void registerModel(AlloyModelResource newModelResource) {
		registerResource(newModelResource);
		models.put(newModelResource.getURI(), newModelResource);
	}

	@Override
	public IndividualOfClass<AlloyTechnologyAdapter, ?, ?> makeIndividualOfClass(
			IFlexoOntologyClass<AlloyTechnologyAdapter> arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'makeIndividualOfClass'");
	}

	// @Override
	// public AlloyObjectIndividualType makeIndividualOfClass(IFlexoOntologyClass<AlloyTechnologyAdapter> anOntologyClass) {
	// 	return new AlloyObjectIndividualType((AlloyClassClass) anOntologyClass);
	// }

	// public void newMetaModelWasRegistered(AlloyMetaModelResource mmResource, FlexoResourceCenter<?> resourceCenter) {
	// 	// We iterate on all AlloyModelResource which does not declare any metamodel
	// 	for (AlloyModelResource AlloyModelResource : models.values()) {
	// 		if (AlloyModelResource.getMetaModelResource() == null) {
	// 			if (AlloyModelResource.getMetaModelResourceURI() != null
	// 					&& AlloyModelResource.getMetaModelResourceURI().equals(mmResource.getURI())) {
	// 				AlloyModelResource.setMetaModelResource(mmResource);
	// 			}
	// 		}
	// 	}
	// }

}
