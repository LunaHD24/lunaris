package de.lunaa.lunaris;

public class EffectBuildProviderImpl implements EffectBuildProvider {
    @Override
    public CustomEffect.Builder getNewBuilder() {
        return new CustomEffectImpl.CustomEffectBuilderImpl();
    }
}
