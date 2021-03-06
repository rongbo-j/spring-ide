/*******************************************************************************
 * Copyright (c) 2015-2017 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.editor.support.util;

/**
 * A ValueParser provides the means to Strings into some kind of
 * value.
 *
 * @author Kris De Volder
 */
public interface ValueParser {
	/**
	 * Parse the string and return its parsed representation.
	 * May either return null, or throw an {@link IllegalArgumentException} to indicate
	 * that the String is not the format this parser expects.
	 */
	Object parse(String str) throws Exception;

	static ValueParser of(ValueParser x) {
		return x;
	}
}