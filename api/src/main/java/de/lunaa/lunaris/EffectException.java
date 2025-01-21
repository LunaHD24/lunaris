package de.lunaa.lunaris;

/**
 * Wrapper exception for all exceptions associated to an error in effect handling.
 */
public class EffectException extends Exception {

    /**
     * Constructs a new EffectException with given message.
     * @param message - The message
     */
    EffectException(String message) {
        super(message);
    }

}
