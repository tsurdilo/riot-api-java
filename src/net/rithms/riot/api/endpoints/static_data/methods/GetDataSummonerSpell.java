/*
 * Copyright 2016 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.rithms.riot.api.endpoints.static_data.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.static_data.constant.SpellData;
import net.rithms.riot.api.endpoints.static_data.dto.SummonerSpell;
import net.rithms.riot.constant.Region;

public class GetDataSummonerSpell extends ApiMethod {

	public GetDataSummonerSpell(ApiConfig config, Region region, int id, String locale, String version, SpellData... spellData) {
		super(config);
		setDtoType(SummonerSpell.class);
		setUrlBase("https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/summoner-spell/" + id);
		if (locale != null) {
			add(new UrlParameter("locale", locale));
		}
		if (version != null) {
			add(new UrlParameter("version", version));
		}
		if (spellData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (SpellData data : spellData) {
				dataBuilder.append(',').append(data.getName());
			}
			add(new UrlParameter("spellData", dataBuilder.substring(1)));
		}
		addApiKeyParameter();
	}
}