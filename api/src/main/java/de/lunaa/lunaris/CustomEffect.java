package de.lunaa.lunaris;

import java.util.UUID;

public interface CustomEffect {

    CustomEffect.Builder getBuilder();

    CustomEffectType getEffectType();

    int getDuration();

    int getLevel();

    boolean applyTo(UUID uuid) throws IllegalArgumentException, EffectException;

    interface Builder {

        Builder setEffectType(CustomEffectType effectType);

        Builder setDuration(int duration);

        Builder setLevel(int level);

        CustomEffect build();

    }

}