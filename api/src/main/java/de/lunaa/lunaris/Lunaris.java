package de.lunaa.lunaris;

public class Lunaris {

    private static EffectRegistry effectRegistry;
    private static EffectBuildProvider effectBuildProvider;


    protected static void setEffectRegistry(EffectRegistry registry) {
        effectRegistry = registry;
    }

    protected static void setEffectBuilderProvider(EffectBuildProvider provider) {
        effectBuildProvider = provider;
    }


    public static EffectRegistry getEffectRegistry() {
        return effectRegistry;
    }

    public static CustomEffect.Builder getEffectBuilder() {
        return effectBuildProvider.getNewBuilder();
    }

}