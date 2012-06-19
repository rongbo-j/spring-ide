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
package org.springframework.ide.eclipse.maven.internal.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.springframework.ide.eclipse.maven.internal.legacyconversion.LegacyProjectsJob;


/**
 * Convert all legacy maven projects in the workspace
 * 
 * @author Andrew Eisenberg
 * @since 2.8.0
 */
public class ConvertLegacyProjectAction implements IObjectActionDelegate {

    public void run(IAction action) {
        LegacyProjectsJob job = new LegacyProjectsJob(true, false);
        job.schedule();
    }

    public void selectionChanged(IAction action, ISelection selection) {
        // we don't care about the actual selection
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    }

}
