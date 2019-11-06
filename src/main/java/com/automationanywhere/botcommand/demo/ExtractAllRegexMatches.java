/*
 * Copyright (c) 2019 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */
/**
 *
 */
package com.automationanywhere.botcommand.demo;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static com.automationanywhere.commandsdk.model.DataType.STRING;

/**
 * @author Bren Sapience
 *
 */
@BotCommand
@CommandPkg(label="Extract All Regex Matches", name="Extract All Regex Matches", description="Extract All Regex Matches", icon="pkg.svg",
		node_label="Extract All Regex Matches",
		return_type= DataType.LIST, return_label="Assign the output to variable", return_required=true)

public class ExtractAllRegexMatches {

	private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

	@Execute
	public com.automationanywhere.botcommand.data.impl.ListValue<String> action(
			@Idx(index = "1", type = AttributeType.TEXT) @Pkg(label = "Regex Pattern with Matches", default_value_type = STRING) @NotEmpty String RegexExp,
			@Idx(index = "2", type = AttributeType.TEXT) @Pkg(label = "Input Text", default_value_type = STRING) @NotEmpty String TheText
			)
	{

		List<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile(RegexExp).matcher(TheText);
		while (m.find()) {
			allMatches.add(m.group());
		}

		//System.out.println("DEBUG:"+allMatches.size());
		ListValue<String> FinalList = new ListValue<String>();
		List<Value> ContainerList = new ArrayList<Value>();

		for(int i = 0;i < allMatches.size();i++){
			Value v = new StringValue(allMatches.get(i));
			ContainerList.add(v);
		}

		FinalList.set(ContainerList);

		return FinalList;
		//return new StringValue(v);

	}


}
