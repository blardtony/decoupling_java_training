package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new CompositeLogger(
            new FilteredLogger(
                new ContextualLogger(new FileLogger("logger.txt"), name),
                message -> message.contains("simulation")
            ),
            new ContextualLogger(new ConsoleLogger() , name)
        );
    }
}
