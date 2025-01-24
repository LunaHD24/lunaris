package dev.lunaa.lunaris;

/**
 * Thrown when trying to access an effect that's not registered.
 */
public class EffectNotFoundException extends EffectException {

    /**
     * Constructs a new EffectNotFoundException with effect namespace and id.
     * @param namespace The effect's namespace
     * @param id The effect's id
     */
    EffectNotFoundException(String namespace, String id) {
        super("Effect not found: " + namespace + ":" + id);
    }

    /**
     * Constructs a new EffectNotFoundException with given message.
     * @param message The message
     */
    EffectNotFoundException(String message) {
        super(message);
    }

}
