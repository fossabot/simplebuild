package fr.snapgames.simplebuild;

import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.geom.Rectangle2D;

/**
 * The Application class is the entry point for this application.
 * 
 * @author Frédéric Delorme
 * @since 1.0
 */
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    private Locale locale;
    private ResourceBundle rb;
    private String[] args;
    private String title;
    private String version;

    private Rectangle2D viewport;

    /**
     * Constructor for the Application, Initialize the default messages values.
     */
    public Application() {
        initialize();
        initViewportFromProperties();
    }

    /**
     * Constructor for the Application, Initialize the default messages values.
     */
    public Application(int width, int height) {
        initialize();
        initViewportFromValues(width, height);
    }

    /**
     * Initialize application - Load Messages in the english language.
     */
    public void initialize() {
        locale = new Locale("en", "US");
        rb = ResourceBundle.getBundle("messages", locale);
    }

    /**
     * Start the program.
     * 
     * @param args the list of arguments to be parsed and used by the main program.
     */
    public void run(String[] args) {
        this.args = args;
        this.title = rb.getString("application.title");
        this.version = rb.getString("application.version");
        logger.info("Normal application start ...");

        int i = 0;
        logger.info("{}: nb args={}", title, args.length);
        for (String s : args) {
            logger.info("arg[{}]: {}", i++, s);
        }
        if (parseArguments(args) != 0) {
            logger.info("Application not correctly initialized: Something Bad happened ! See log.");
        }
    }

    public int parseArguments(String[] args) {
        int status = 0;
        for (String a : args) {
            if (a.contains("=")) {
                String[] arg = a.split("=");
                switch (arg[0].toLowerCase()) {
                case "viewport":
                    status = initViewportFromString(arg[1]);
                    break;
                default:
                    break;
                }
            }
        }
        return status;
    }

    /**
     * Initialize the viewport from a string like "320x200"
     * 
     * @param argValue the string to be parsed to set the viewport size.
     * @return 0 if ok, else -1.
     */
    public int initViewportFromString(String argValue) {
        if (!argValue.contains("x"))
            return -1;
        String[] widthHeight = argValue.split("x");
        try {
            int width = Integer.parseInt(widthHeight[0]);
            int height = Integer.parseInt(widthHeight[1]);
            initViewportFromValues(width, height);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Create the Viewport with width x height
     * 
     * @param width  Width of the viewport to initialize
     * @param height Height of the viewport to initialize
     */
    public void initViewportFromValues(int width, int height) {
        this.viewport = new Rectangle2D.Float(0, 0, width, height);
        logger.info("Create Viewport set to [{}x{}]", width, height);
    }

    private void initViewportFromProperties() {
        String defaultViewportSize = this.rb.getString("application.viewport.default");
        initViewportFromString(defaultViewportSize);
    }

    /**
     * return the argument number `i`
     * 
     * @param i the index of the argument to be returned.
     * @return the value of the argument with index `i`.
     */
    public String getArgs(int i) {
        return args[i];
    }

    /**
     * return the number of arguments
     * 
     * @return the number of argument in the args list.
     */
    public int getNbArgs() {
        return args.length;
    }

    /**
     * Return the title of the application.
     * 
     * @return the title intialiazed by the `messages.properties` file.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Return the version of the application.
     * 
     * @return the version intialiazed by the `messages.properties` file.
     */
    public String getVersion() {
        return this.version;
    }

    public Rectangle2D getViewport() {
        return this.viewport;
    }

    /**
     * This is the main method for the Application class.
     * 
     * @param args THe list of arguments for this java application
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run(args);
    }

}
