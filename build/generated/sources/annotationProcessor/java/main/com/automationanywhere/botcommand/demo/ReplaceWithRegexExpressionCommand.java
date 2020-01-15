package com.automationanywhere.botcommand.demo;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ReplaceWithRegexExpressionCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(ReplaceWithRegexExpressionCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    ReplaceWithRegexExpression command = new ReplaceWithRegexExpression();
    if(parameters.get("TheText") == null || parameters.get("TheText").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","TheText"));
    }

    if(parameters.get("RegexExp") == null || parameters.get("RegexExp").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","RegexExp"));
    }

    if(parameters.get("ToReplaceWith") == null || parameters.get("ToReplaceWith").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","ToReplaceWith"));
    }

    if(parameters.get("TheText") != null && parameters.get("TheText").get() != null && !(parameters.get("TheText").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","TheText", "String", parameters.get("TheText").get().getClass().getSimpleName()));
    }
    if(parameters.get("RegexExp") != null && parameters.get("RegexExp").get() != null && !(parameters.get("RegexExp").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","RegexExp", "String", parameters.get("RegexExp").get().getClass().getSimpleName()));
    }
    if(parameters.get("ToReplaceWith") != null && parameters.get("ToReplaceWith").get() != null && !(parameters.get("ToReplaceWith").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","ToReplaceWith", "String", parameters.get("ToReplaceWith").get().getClass().getSimpleName()));
    }
    try {
      Optional<Value> result =  Optional.ofNullable(command.action(parameters.get("TheText") != null ? (String)parameters.get("TheText").get() : (String)null ,parameters.get("RegexExp") != null ? (String)parameters.get("RegexExp").get() : (String)null ,parameters.get("ToReplaceWith") != null ? (String)parameters.get("ToReplaceWith").get() : (String)null ));
      logger.traceExit(result);
      return result;
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","action"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
