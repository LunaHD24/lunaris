package de.lunaa.lunaris;

public class EffectNotFoundException extends EffectException {

    EffectNotFoundException(String namespace, String id) {
        super("Effect not found: " + namespace + ":" + id);
    }

    EffectNotFoundException(String message) {
        super(message);
    }

}
