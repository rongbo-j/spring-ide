/*******************************************************************************
 *  Copyright (c) 2012 VMware, Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      VMware, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.config.core.contentassist.providers;

import org.eclipse.wst.xml.core.internal.provisional.document.IDOMElement;
import org.springframework.ide.eclipse.beans.ui.editor.contentassist.IContentAssistCalculator;
import org.springframework.ide.eclipse.config.core.contentassist.XmlBackedContentProposalProvider;
import org.springframework.ide.eclipse.osgi.ui.editor.contentassist.osgi.ReferenceIdContentAssistCalculator;


/**
 * An {@link XmlBackedContentProposalProvider} that uses
 * {@link ReferenceIdContentAssistCalculator} as its content assist calculator.
 * @author Leo Dos Santos
 * @since 2.3.1
 */
@SuppressWarnings("restriction")
public class ReferenceIdContentProposalProvider extends XmlBackedContentProposalProvider {

	/**
	 * Constructs a content proposal provider for an XML attribute.
	 * 
	 * @param input the XML element to serve as the model of this proposal
	 * provider
	 * @param attrName the name of the attribute to compute proposals for
	 */
	public ReferenceIdContentProposalProvider(IDOMElement input, String attrName) {
		super(input, attrName);
	}

	@Override
	protected IContentAssistCalculator createContentAssistCalculator() {
		return new ReferenceIdContentAssistCalculator();
	}

}
