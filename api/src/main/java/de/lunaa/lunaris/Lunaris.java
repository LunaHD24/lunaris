package de.lunaa.lunaris;

/**
 * Represents the Lunaris core.
 */
public class Lunaris {

    private static EffectRegistry effectRegistry;
    private static EffectBuilderAccess effectBuilderAccess;


    protected static void setEffectRegistry(EffectRegistry registry) {
        effectRegistry = registry;
    }

    protected static void setEffectBuilderAccess(EffectBuilderAccess provider) {
        effectBuilderAccess = provider;
    }

    /**
     * @return The effect registry of the server.
     */
    public static EffectRegistry getEffectRegistry() {
        return effectRegistry;
    }

    /**
     * @return A new instance of {@link CustomEffect.Builder}
     */
    public static CustomEffect.Builder getEffectBuilder() {
        return effectBuilderAccess.getNewBuilder();
    }

}