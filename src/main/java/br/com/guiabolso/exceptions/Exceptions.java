package br.com.guiabolso.exceptions;

import org.springframework.stereotype.Component;

@Component
public class Exceptions {

    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public static class DuplicateEntityException extends RuntimeException {
        public DuplicateEntityException(String message) {
            super(message);
        }
    }

    public static class ForbiddenEntityException extends RuntimeException {
        public ForbiddenEntityException(String message) {
            super(message);
        }
    }

    private static RuntimeException throwException(ExceptionType exceptionType, String messageTemplate, String... args) {
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
            return new EntityNotFoundException(format(messageTemplate, args));
        } else if (ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)) {
            return new DuplicateEntityException(format(messageTemplate, args));
        } else if(ExceptionType.FORBIDDEN_EXCEPTION.equals(exceptionType))
            return new ForbiddenEntityException(format(messageTemplate, args));
        return new RuntimeException(format(messageTemplate, args));
    }

    private static String format(String template, String... args) {
        return String.format(template, args);
    }
}
