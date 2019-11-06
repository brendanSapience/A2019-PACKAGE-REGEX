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
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
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
@CommandPkg(label="Replace based on Regex", name="Replace based on Regex", description="Replace based on Regex", icon="pkg.svg",
		node_label="Replace based on Regex",
		return_type= STRING, return_label="Assign the output to variable", return_required=true)

public class ReplaceWithRegexExpression {

	private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

	@Execute
	public Value<String> action(
			@Idx(index = "1", type = AttributeType.TEXT) @Pkg(label = "Input Text", default_value_type = STRING) @NotEmpty String TheText,
			@Idx(index = "2", type = AttributeType.TEXT) @Pkg(label = "Regex Pattern", default_value_type = STRING) @NotEmpty String RegexExp,
			@Idx(index = "3", type = AttributeType.TEXT) @Pkg(label = "Replace With", default_value_type = STRING) @NotEmpty String ToReplaceWith
			)
	{

		if("".equals(RegexExp)) {throw new BotCommandException(MESSAGES.getString("emptyInputString", "RegularExpression"));}
		if("".equals(TheText)) {throw new BotCommandException(MESSAGES.getString("emptyInputString", "InputText"));}

		String tempValue = TheText.replaceAll(RegexExp, ToReplaceWith);
		return new StringValue(tempValue);

	}


}
