package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger{
    private final Logger logger;
    private final Predicate<String> predicate;

    public FilteredLogger(Logger logger, Predicate<String> condition) {
        this.logger = logger;
        this.predicate = condition;
    }

    @Override
    public void log(String message) {
        if (predicate.test(message)) {
            logger.log(message);
        }
    }
}
