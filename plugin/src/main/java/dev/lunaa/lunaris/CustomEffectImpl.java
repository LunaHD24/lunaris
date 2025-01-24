package dev.lunaa.lunaris;

import org.bukkit.Bukkit;

import java.util.*;

public class CustomEffectImpl implements CustomEffect {

    private static final Map<UUID, HashMap<CustomEffectType, EffectInfo>> playerEffectMap = new HashMap<>();
    private final CustomEffectType effectType;
    private final int duration;
    private final int level;


    CustomEffectImpl(CustomEffectType effectType, int duration, int level) {
        this.effectType = effectType;
        this.duration = duration;
        this.level = level;
    }


    @Override
    public Builder getBuilder() {
        return new CustomEffectBuilderImpl();
    }

    @Override
    public CustomEffectType getEffectType() {
        return effectType;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public boolean applyTo(UUID uuid) throws IllegalArgumentException, EffectException {
        boolean effectOverwritten = false;
        HashMap<CustomEffectType, EffectInfo> effectInfoMap = playerEffectMap.get(uuid);

        if (effectInfoMap.containsKey(effectType)) {
            Bukkit.getScheduler().cancelTask(effectInfoMap.get(effectType).getTaskId());
            effectOverwritten = true;
        }
        effectInfoMap.put(effectType, new EffectInfo(duration, level, Integer.MIN_VALUE));
        playerEffectMap.put(uuid, effectInfoMap);
        int taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(LunarisPlugin.instance, () -> {
            HashMap<CustomEffectType, EffectInfo> taskEffectInfoMap = playerEffectMap.get(uuid);
            if (taskEffectInfoMap.get(effectType).getDuration() < 0) {
                Bukkit.getScheduler().cancelTask(taskEffectInfoMap.get(effectType).getTaskId());
                return;
            }
            effectType.tick();
            playerEffectMap.get(uuid).get(effectType).setDuration(taskEffectInfoMap.get(effectType).getDuration()-1);
        }, 0, 1);
        if (taskId == -1) throw new EffectException("Failed to apply " + effectType.getKey() + " to " + uuid + " (effect scheduling failed)");

        return effectOverwritten;
    }

    public static class CustomEffectBuilderImpl implements CustomEffect.Builder {

        private CustomEffectType effectType;
        private int duration;
        private int level;


        @Override
        public CustomEffect.Builder setEffectType(CustomEffectType effectType) {
            this.effectType = effectType;
            return this;
        }

        @Override
        public CustomEffect.Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        @Override
        public CustomEffect.Builder setLevel(int level) {
            this.level = level;
            return this;
        }

        @Override
        public CustomEffect build() {
            return new CustomEffectImpl(effectType, duration, level);
        }

    }

}