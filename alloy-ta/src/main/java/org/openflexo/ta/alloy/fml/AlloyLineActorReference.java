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

package org.openflexo.ta.alloy.fml;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.openflexo.foundation.FlexoException;
import org.openflexo.foundation.fml.annotations.FML;
import org.openflexo.foundation.fml.rt.ActorReference;
import org.openflexo.foundation.fml.rt.FreeModelSlotInstance;
import org.openflexo.foundation.resource.ResourceLoadingCancelledException;
import org.openflexo.logging.FlexoLogger;
import org.openflexo.pamela.annotations.Getter;
import org.openflexo.pamela.annotations.ImplementationClass;
import org.openflexo.pamela.annotations.ModelEntity;
import org.openflexo.pamela.annotations.PropertyIdentifier;
import org.openflexo.pamela.annotations.Setter;
import org.openflexo.pamela.annotations.XMLAttribute;
import org.openflexo.pamela.annotations.XMLElement;
import org.openflexo.ta.alloy.model.AlloyLine;
import org.openflexo.ta.alloy.model.AlloyText;
import org.openflexo.ta.alloy.rm.AlloyTextResource;

/**
 * Implements {@link ActorReference} for {@link AlloyLine} object
 * 
 * @author sylvain
 * 
 */
@ModelEntity
@ImplementationClass(AlloyLineActorReference.AlloyLineActorReferenceImpl.class)
@XMLElement
@FML("AlloyLineActorReference")
public interface AlloyLineActorReference extends ActorReference<AlloyLine> {

	@PropertyIdentifier(type = String.class)
	public static final String OBJECT_URI_KEY = "objectURI";

	@Getter(value = OBJECT_URI_KEY)
	@XMLAttribute
	public String getObjectURI();

	@Setter(OBJECT_URI_KEY)
	public void setObjectURI(String objectURI);

	public abstract static class AlloyLineActorReferenceImpl extends ActorReferenceImpl<AlloyLine> implements AlloyLineActorReference {

		private static final Logger logger = FlexoLogger.getLogger(AlloyLineActorReference.class.getPackage().toString());

		private AlloyLine object;
		private String objectURI;

		public AlloyText getAlloyText() {
			if (getAlloyTextResource() != null) {
				try {
					return getAlloyTextResource().getResourceData();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (ResourceLoadingCancelledException e) {
					e.printStackTrace();
				} catch (FlexoException e) {
					e.printStackTrace();
				}
			}
			return null;
		}

		public AlloyTextResource getAlloyTextResource() {
			FreeModelSlotInstance<?, ?, ?> msInstance = (FreeModelSlotInstance<?, ?, ?>) getModelSlotInstance();
			if (msInstance != null && msInstance.getResource() instanceof AlloyTextResource) {
				return (AlloyTextResource) msInstance.getResource();
			}
			return null;
		}

		@Override
		public AlloyLine getModellingElement(boolean forceLoading) {
			if (object == null && objectURI != null) {
				int index = Integer.parseInt(objectURI);
				return getAlloyText().getLines().get(index);
			}
			if (object == null) {
				logger.warning("Could not retrieve object " + objectURI);
			}
			return object;

		}

		@Override
		public void setModellingElement(AlloyLine object) {
			this.object = object;
			if (object != null) {
				objectURI = "" + object.getIndex();
			}
		}

		@Override
		public String getObjectURI() {
			if (object != null) {
				return "" + object.getIndex();
			}
			return objectURI;
		}

		@Override
		public void setObjectURI(String objectURI) {
			this.objectURI = objectURI;
		}

	}

}
