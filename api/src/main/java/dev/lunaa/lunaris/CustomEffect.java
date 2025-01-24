package dev.lunaa.lunaris;

import java.util.UUID;

/**
 * Represents a CustomEffect instance.
 */
public interface CustomEffect {

    /**
     * Builder for creating a new {@link CustomEffect} instance.
     * @return A new instance of {@link CustomEffect.Builder}.
     */
    CustomEffect.Builder getBuilder();

    /**
     * Gets the {@link CustomEffectType} of this effect.
     * @return {@link CustomEffectType} set for this {@link CustomEffect} instance
     * or null if not set.
     */
    CustomEffectType getEffectType();

    /**
     * Gets the effect duration in ticks.
     * @return The duration set for this {@link CustomEffect} instance
     * or null if not set.
     */
    int getDuration();

    /**
     * Gets the effect level.
     * @return The effect level set for this {@link CustomEffect} instance
     * or null if not set.
     */
    int getLevel();

    /**
     * Applies the {@link CustomEffect} to specified player and overwrites any
     * previous effect of the same {@link CustomEffectType} if present.
     * @param uuid UUID of player to apply effect to
     * @return Whether a previous {@link CustomEffect} of the same {@link CustomEffectType} already applied to the player has been overwritten.
     * @throws IllegalArgumentException If uuid is not linked to a player.
     * @throws EffectException If the BukkitTask failed to be scheduled thus not applying the effect.
     */
    boolean applyTo(UUID uuid) throws IllegalArgumentException, EffectException;

    /**
     * Builder for creating a new {@link CustomEffect} instance.
     */
    interface Builder {

        /**
         * Sets the effect type.
         * @param effectType The effect type
         * @return The builder for chaining.
         */
        Builder setEffectType(CustomEffectType effectType);

        /**
         * Sets the effect duration in ticks.
         * @param duration How long the effect should last in ticks.
         * @return The builder for chaining.
         */
        Builder setDuration(int duration);

        /**
         * Sets the effect level.
         * @param level The effect level (can be used for custom logic)
         * @return The builder for chaining.
         */
        Builder setLevel(int level);

        /**
         * Builds the {@link CustomEffect} instance.
         * @return The configured {@link CustomEffect} instance.
         */
        CustomEffect build();

    }

}