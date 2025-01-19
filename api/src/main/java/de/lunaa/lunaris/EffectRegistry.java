package de.lunaa.lunaris;

public interface EffectRegistry {

    void register(CustomEffectType effect);

    CustomEffectType getByKey(String namespace, String id) throws EffectNotFoundException;

    CustomEffectType getByKey(String key) throws EffectNotFoundException;

    CustomEffectType[] getRegisteredEffects();

}