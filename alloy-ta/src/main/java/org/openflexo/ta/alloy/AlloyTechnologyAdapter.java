/**
 * 
 * Copyright (c) 2018, Openflexo
 * 
 * This file is part of OpenflexoTechnologyAdapter, a component of the software infrastructure 
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

import java.util.logging.Logger;

import org.openflexo.foundation.fml.annotations.DeclareModelSlots;
import org.openflexo.foundation.fml.annotations.DeclareResourceFactories;
import org.openflexo.foundation.resource.FlexoResourceCenter;
import org.openflexo.foundation.technologyadapter.TechnologyAdapter;
import org.openflexo.ta.Alloy.fml.binding.AlloyBindingFactory;
import org.openflexo.ta.Alloy.rm.AlloyTextResourceFactory;
import org.openflexo.ta.Alloy.rm.AlloyTextResourceRepository;

/**
 * This class defines and implements the Alloy technology adapter
 */
@DeclareModelSlots({ AlloyModelSlot.class })
@DeclareTechnologySpecificTypes({ AlloyObjectSignatureType.class })
@DeclareResourceFactories({ AlloyMetaModelResourceFactory.class, AlloyModelResourceFactory.class })
public class AlloyTechnologyAdapter extends TechnologyAdapter<AlloyTechnologyAdapter> {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(AlloyTechnologyAdapter.class.getPackage().getName());

	private static final AlloyBindingFactory BINDING_FACTORY = new AlloyBindingFactory();

	// TODO the following is inspired from EMF TA, is it needed ?
	// public static String Alloy_MM_NAME = "Alloy Metamodel";
	// public static String Alloy_MM_URI = "http://www.alloytools.org/2026/alloy"/;
	// private static String Alloy_MM_EXT = "als";
	// private static String Alloy_MM_PKGCLSNAME = AlloyPackageImpl.class.getName();
	// private static String Alloy_MM_FACTORYCLSNAME = AlloyResourceFactoryImpl.class.getName();
	// private AlloyMetaModelResource AlloyMetaModelResource = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @throws TechnologyAdapterInitializationException
	 */
	public AlloyTechnologyAdapter() throws TechnologyAdapterInitializationException {
	}


	/**
	 * 
	 * Follow the link.
	 * 
	 * @see org.openflexo.foundation.technologyadapter.TechnologyAdapter#getName()
	 */
	@Override
	public String getName() {
		return "Alloy technology adapter";
	}

	@Override
	protected String getLocalizationDirectory() {
		return "FlexoLocalization/AlloyTechnologyAdapter";
	}

	//TODO is this needed ?
	@Override
	public void activate() {
		super.activate();
		//TODO is this needed ?
		registerClasspathMetaModels();
	}

	@Override
	public void ensureAllRepositoriesAreCreated(FlexoResourceCenter<?> rc) {
		super.ensureAllRepositoriesAreCreated(rc);
		getAlloyResourceRepository(rc);

	}

	@Override
	public <I> boolean isIgnorable(FlexoResourceCenter<I> resourceCenter, I contents) {
		System.out.println("AlloyTA.isIgnorable: " + contents);
		return false;
	}
	
	//TODO is it relevant in this case ?
	@Override
	protected <I> boolean isFolderIgnorable(FlexoResourceCenter<I> resourceCenter, I contents) {
		if (resourceCenter.isDirectory(contents)) {
			for (I c : resourceCenter.getContents(contents)) {
				// if (resourceCenter.retrieveName(c).endsWith(JarBasedMetaModelResource.PROPERTIES_SUFFIX)) {
					// return true;
				// }
			}
		}
		return false;
	}

	//TODO do I need this ?
	public <I> AlloyMetaModelRepository<I> getAlloyMetaModelRepository(FlexoResourceCenter<I> resourceCenter) {
		AlloyMetaModelRepository<I> returned = resourceCenter.retrieveRepository(AlloyMetaModelRepository.class, this);
		if (returned == null) {
			returned = AlloyMetaModelRepository.instanciateNewRepository(this, resourceCenter);
			resourceCenter.registerRepository(returned, AlloyMetaModelRepository.class, this);
		}
		return returned;
	}

	@Override
	public AlloyBindingFactory getTechnologyAdapterBindingFactory() {
		return BINDING_FACTORY;
	}

	@Override
	public String getIdentifier() {
		return "Alloy";
	}

	public AlloyTextResourceFactory getAlloyResourceFactory() {
		return getResourceFactory(AlloyTextResourceFactory.class);
	}

	@SuppressWarnings("unchecked")
	public <I> AlloyTextResourceRepository<I> getAlloyResourceRepository(FlexoResourceCenter<I> resourceCenter) {
		AlloyTextResourceRepository<I> returned = resourceCenter.retrieveRepository(AlloyTextResourceRepository.class, this);
		if (returned == null) {
			returned = AlloyTextResourceRepository.instanciateNewRepository(this, resourceCenter);
			resourceCenter.registerRepository(returned, AlloyTextResourceRepository.class, this);
		}
		return returned;
	}

}
