package de.lunaa.lunaris;

public class EffectBuilderAccessImpl implements EffectBuilderAccess {
    @Override
    public CustomEffect.Builder getNewBuilder() {
        return new CustomEffectImpl.CustomEffectBuilderImpl();
    }
}
