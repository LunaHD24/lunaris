package dev.lunaa.lunaris;

/**
 * May be implemented for defining a new custom effect and it's functionality.
 * Can be registered through the {@link EffectRegistry}.
 */
public interface CustomEffectType {

    /**
     * Gets the id defined by this CustomEffectType.
     * @return ID of this CustomEffectType.
     */
    String getId();

    /**
     * Gets the namespace defined by this CustomEffectType.
     * @return Namespace of this CustomEffectType.
     */
    String getNamespace();

    /**
     * Gets the key of this CustomEffectType. Takes the return values
     * of {@link #getNamespace()} and {@link #getId()} and returns it in the format of namespace:id.
     * @return Key of this CustomEffectType.
     */
    default String getKey() {
        return getNamespace() + ":" + getId();
    }

    /**
     * Executed every tick while a {@link CustomEffect} with this effect type is applied to a player.
     */
    void tick();

}
