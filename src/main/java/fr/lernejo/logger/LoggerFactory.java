package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new CompositeLogger(new ContextualLogger(new FileLogger("logger.txt"), name), new ContextualLogger(new ConsoleLogger(), name));
    }
}
