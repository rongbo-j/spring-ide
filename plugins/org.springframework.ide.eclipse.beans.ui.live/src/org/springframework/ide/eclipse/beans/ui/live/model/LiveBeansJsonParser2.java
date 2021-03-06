/*******************************************************************************
 * Copyright (c) 2017 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.beans.ui.live.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Live Beans json parser suitable for Boot 2.x
 * 
 * @author Alex Boyko
 *
 */
public class LiveBeansJsonParser2 extends LiveBeansJsonParser {

	public LiveBeansJsonParser2(TypeLookup typeLookup, String jsonInput) {
		super(typeLookup, jsonInput);
	}

	@Override
	protected JSONArray extractContextsJson(String json) throws JSONException {
		Object obj = new JSONTokener(json).nextValue();
		if (obj instanceof JSONArray) {
			return (JSONArray) obj;
		} else {
			return new JSONArray(Arrays.asList(obj));
		}
	}

	@Override
	protected String getContextId(JSONObject contextJson) throws JSONException {
		return contextJson.getString(LiveBeansContext.ATTR_ID);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected JSONArray extractBeans(JSONObject contextJson) {
		JSONObject obj = contextJson.optJSONObject(LiveBeansContext.ATTR_BEANS);
		Iterable<String> iterable = () -> obj.keys();
		return new JSONArray(StreamSupport.stream(iterable.spliterator(), false)
			.map(k -> {
				try {
					JSONObject jsonBean = obj.getJSONObject(k);
					jsonBean.put(LiveBean.ATTR_BEAN, k);
					return jsonBean;
				} catch (JSONException e) {
					// Shouldn't happen since key exists
					return null;
				}})
			.filter(Objects::nonNull)
			.collect(Collectors.toList())
		);
	}

}
