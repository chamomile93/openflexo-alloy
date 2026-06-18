/**
 * 
 * Copyright (c) 2013-2014, Openflexo
 * Copyright (c) 2012-2012, AgileBirds
 * 
 * This file is part of Alloy Connector, a component of the software infrastructure 
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

package org.openflexo.ta.alloy.rm;

import org.openflexo.foundation.resource.FlexoIODelegate;
import org.openflexo.foundation.resource.ResourceData;
import org.openflexo.foundation.technologyadapter.FlexoMetaModelResource;
import org.openflexo.foundation.technologyadapter.TechnologyAdapterResource;
import org.openflexo.pamela.annotations.ModelEntity;
import org.openflexo.rm.Resource;
import org.openflexo.ta.alloy.AlloyTechnologyAdapter;
import org.openflexo.ta.alloy.metamodel.AlloyMetaModel;
import org.openflexo.ta.alloy.model.AlloyModel;

/**
 * Represents an abstract Alloy metamodel resource
 *
 */
@ModelEntity(isAbstract = true)
// @Imports({ @Import(ECoreMetaModelResource.class), @Import(JarBasedMetaModelResource.class) })
public interface AlloyMetaModelResource extends FlexoMetaModelResource<AlloyModel, AlloyMetaModel, AlloyTechnologyAdapter>,
		TechnologyAdapterResource<AlloyMetaModel, AlloyTechnologyAdapter> {

	public static final String PACKAGE = "package";

	/**
	 * Return the effective metamodel addressed by this resource, its {@link ResourceData}
	 * 
	 * @return
	 */
	public AlloyMetaModel getMetaModel();

	/**
	 * Return the effective metamodel addressed by this resource, its {@link ResourceData}
	 * 
	 * @return
	 */
	@Override
	public AlloyMetaModel getMetaModelData();

	/**
	 * Creates a new ModelResource, for Alloy, MetaModel decides wich type of serialization you should use!
	 * 
	 * @param flexoIODelegate
	 * @return
	 */
	Resource createAlloyModelResource(FlexoIODelegate<?> flexoIODelegate);

	/**
	 * Getter of Package MetaModel.
	 * 
	 * @return
	 */
	// @Getter(value = PACKAGE, ignoreType = true)
	// EPackage getPackage();

	/**
	 * Setter of Package MetaModel.
	 * 
	 * @param ePackage
	 */
	// @Setter(value = PACKAGE)
	// void setPackage(EPackage ePackage);
	
	// String getModelFileExtension();
	// Resource.Factory getAlloyResourceFactory();

}
