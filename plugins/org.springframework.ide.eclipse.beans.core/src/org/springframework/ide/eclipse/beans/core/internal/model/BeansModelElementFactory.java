/*******************************************************************************
 * Copyright (c) 2007 Spring IDE Developers
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Spring IDE Developers - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.beans.core.internal.model;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.springframework.ide.eclipse.beans.core.BeansCorePlugin;
import org.springframework.ide.eclipse.core.model.IModelElement;

/**
 * {@link IElementFactory} implementation that is capable of re-creating
 * {@link IModelElement} for given elementIds.
 * @author Christian Dupuis
 * @since 2.0
 * @see BeansModelElementToPersistableElementAdapter
 */
public class BeansModelElementFactory implements IElementFactory {

	public static final String FACTORY_ID = "org.springframework.ide.eclipse.beans.core.factoryId";

	public static final String ELEMENT_ID = "elementID";

	public IAdaptable createElement(IMemento memento) {
		String elementID = memento.getString(ELEMENT_ID);
		return BeansCorePlugin.getModel().getElement(elementID);
	}
}
