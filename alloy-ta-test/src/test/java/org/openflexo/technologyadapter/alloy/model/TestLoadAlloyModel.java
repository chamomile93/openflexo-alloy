package org.openflexo.technologyadapter.alloy.model;

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

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openflexo.foundation.resource.FlexoResource;
import org.openflexo.foundation.resource.FlexoResourceCenter;
import org.openflexo.ta.alloy.AbstractAlloyTest;
import org.openflexo.ta.alloy.AlloyTechnologyAdapter;
import org.openflexo.test.OrderedRunner;
import org.openflexo.test.TestOrder;

@RunWith(OrderedRunner.class)
public class TestLoadAlloyModel extends AbstractAlloyTest {
	protected static final Logger logger = Logger.getLogger(TestLoadAlloyModel.class.getPackage().getName());

	@Test
	@TestOrder(1)
	public void testInitializeServiceManager() throws Exception {
		log("testInitializeServiceManager(AlloyTechnologyAdapter)");
//		System.out.println("2testInitializeServiceManager(AlloyTechnologyAdapter)");
		instanciateTestServiceManager(AlloyTechnologyAdapter.class);

		for (FlexoResource<?> r : serviceManager.getResourceManager().getRegisteredResources()) {
			log("FlexoResource registered > " + r.getURI());
		}

	}

	@Test
	@TestOrder(3)
	public void testAlloyLoading() {
		AlloyTechnologyAdapter technologicalAdapter = serviceManager.getTechnologyAdapterService()
				.getTechnologyAdapter(AlloyTechnologyAdapter.class);

		assertNotNull(technologicalAdapter);
		for (FlexoResourceCenter<?> resourceCenter : serviceManager.getResourceCenterService().getResourceCenters()) {
			assertNotNull(resourceCenter.getAllResources());
			assertNotEquals(Collections.EMPTY_LIST, resourceCenter.getAllResources());
		}
	}

	@Test
	@TestOrder(4)
	public void testAlloyContents() {
		fail();
	}
}
