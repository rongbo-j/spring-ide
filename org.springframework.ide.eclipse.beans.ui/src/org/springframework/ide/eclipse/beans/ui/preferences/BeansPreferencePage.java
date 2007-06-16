/*******************************************************************************
 * Copyright (c) 2005, 2007 Spring IDE Developers
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Spring IDE Developers - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.beans.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.springframework.ide.eclipse.beans.core.model.IBeansModel;
import org.springframework.ide.eclipse.beans.ui.BeansUIPlugin;

/**
 * {@link IWorkbenchPreferencePage} that allows to change the persistence
 * property for the {@link IBeansModel}.
 * @author Christian Dupuis
 * @since 2.0
 */
public class BeansPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private BooleanFieldEditor booleanEditor;

	protected Control createContents(Composite parent) {

		Composite entryTable = new Composite(parent, SWT.NULL);

		// Create a data that takes up the extra space in the dialog .
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		entryTable.setLayoutData(data);

		GridLayout layout = new GridLayout();
		entryTable.setLayout(layout);

		Label label = new Label(entryTable, SWT.NONE);
		label
				.setText("Use this preference page to specify the default Double Click Action\n"
						+ "on the Spring Explorer.");

		Composite colorComposite = new Composite(entryTable, SWT.NONE);

		colorComposite.setLayout(new GridLayout());

		// Create a data that takes up the extra space in the dialog.
		colorComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Group group = new Group(colorComposite, SWT.NONE);
		layout.marginWidth = 3;
		layout.marginHeight = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText("Default Double Click Action");

		Composite colorComposite2 = new Composite(group, SWT.NONE);
		layout.marginLeft = 2;
		colorComposite2.setLayout(layout);
		colorComposite2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		booleanEditor = new BooleanFieldEditor(
				BeansUIPlugin.DEFAULT_DOUBLE_CLICK_ACTION_PREFERENCE_ID,
				"checked = open Configuration File, unchecked = open Java Element",
				colorComposite2);
		booleanEditor.setPage(this);
		booleanEditor.setPreferenceStore(getPreferenceStore());
		booleanEditor.load();

		return entryTable;
	}

	public void init(IWorkbench workbench) {
		// Initialize the preference store we wish to use
		setPreferenceStore(BeansUIPlugin.getDefault().getPreferenceStore());
	}

	protected void performDefaults() {
		booleanEditor.loadDefault();
	}

	public boolean performOk() {
		booleanEditor.store();
		return super.performOk();
	}

}