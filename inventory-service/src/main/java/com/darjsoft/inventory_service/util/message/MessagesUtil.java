package com.darjsoft.inventory_service.util.message;

import java.util.Locale;

import org.springframework.context.MessageSource;

import com.darjsoft.inventory_service.exceptions.InventoryHttpException;

public class MessagesUtil {

	private static final Locale DEFAULT_LOCALE = Locale.getDefault();

    private static MessageSource messageSource;

    private MessagesUtil() {
    }
    
    public static InventoryHttpException buildException(MessagesEnum message) {
        return new InventoryHttpException(message.getCode(), message.name(),
                buildMessage(message.getMessage()));
    }
    
    public static InventoryHttpException buildException(MessagesEnum message, Throwable ex) {
        return new InventoryHttpException(message.getCode(), message.name(),
                buildMessage(message.getMessage()), ex);
    }

    public static InventoryHttpException buildException(MessagesEnum message, Object[] args) {
        return new InventoryHttpException(message.getCode(), message.name(),
                buildMessage(message.getMessage(), args));
    }

    public static InventoryHttpException buildException(MessagesEnum message, Object args) {
        return new InventoryHttpException(message.getCode(), message.name(),
                buildMessage(message.getMessage(), args));
    }
    
    public static String buildMessage(MessagesEnum messagesEnum) {
        return messageSource.getMessage(messagesEnum.getMessage(), null, DEFAULT_LOCALE);
    }
    
    public static String buildMessage(String message) {
        return messageSource.getMessage(message, null, DEFAULT_LOCALE);
    }

    public static String buildMessage(String message, Object arg) {
        return messageSource.getMessage(message, new Object[]{arg}, DEFAULT_LOCALE);
    }

    public static String buildMessage(String message, Object[] args) {
        return messageSource.getMessage(message, args, DEFAULT_LOCALE);
    }

    public static synchronized void init(MessageSource messageSource) {
        MessagesUtil.messageSource = messageSource;
    }
	
}
