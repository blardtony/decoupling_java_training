package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new ContextualLogger(new FileLogger("logger.txt"), name);
    }
}
