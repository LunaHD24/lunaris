package dev.lunaa.lunaris;

/**
 * Used for registering and getting {@link CustomEffectType}'s
 */
public interface EffectRegistry {

    /**
     * Registers the CustomEffectType to be usable in a {@link CustomEffect} instance.
     * @param effect The effect type
     */
    void register(CustomEffectType effect);

    /**
     * @param namespace The effect's namespace
     * @param id The effect's id
     * @return The {@link CustomEffectType} associated with given namespace and id.
     * @throws EffectNotFoundException If there's no registered effect associated with given namespace and id.
     */
    CustomEffectType getByKey(String namespace, String id) throws EffectNotFoundException;

    /**
     * @param key The effect's key in the format namespace:id
     * @return The {@link CustomEffectType} associated with given key.
     * @throws EffectNotFoundException If there's no registered effect associated with given key.
     */
    CustomEffectType getByKey(String key) throws EffectNotFoundException;

    /**
     * @return An array of all currently registered effects.
     */
    CustomEffectType[] getRegisteredEffects();

}