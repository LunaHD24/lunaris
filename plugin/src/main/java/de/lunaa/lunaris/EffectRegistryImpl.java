package de.lunaa.lunaris;

import java.util.HashMap;
import java.util.Map;

public class EffectRegistryImpl implements EffectRegistry {

    private final Map<String, CustomEffectType> registeredEffects = new HashMap<>();

    @Override
    public void register(CustomEffectType effectType) {
        registeredEffects.put(effectType.getNamespace() + ":" + effectType.getId(), effectType);
    }

    @Override
    public CustomEffectType getByKey(String namespace, String id) throws EffectNotFoundException {
        CustomEffectType effectType = registeredEffects.get(namespace + ":" + id);
        if (effectType == null) throw new EffectNotFoundException(namespace, id);
        return effectType;
    }

    @Override
    public CustomEffectType getByKey(String key) throws EffectNotFoundException {
        CustomEffectType effectType = registeredEffects.get(key);
        if (effectType == null) throw new EffectNotFoundException("Effect not found: " + key);
        return effectType;
    }

    @Override
    public CustomEffectType[] getRegisteredEffects() {
        return registeredEffects.values().toArray(new CustomEffectType[0]);
    }

}