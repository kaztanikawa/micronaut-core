package io.micronaut.context;

import io.micronaut.core.annotation.Internal;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

/**
 * Default message context implementation.
 *
 * @author graemerocher
 * @since 1.2
 */
@Internal
class DefaultMessageContext implements MessageSource.MessageContext {

    private final @Nullable Locale locale;
    private final @Nullable Map<String, Object> variables;

    /**
     * Default constructor.
     * @param locale The locale
     * @param variables The message variables
     */
    DefaultMessageContext(@Nullable Locale locale, @Nullable Map<String, Object> variables) {
        this.locale = locale;
        this.variables = variables;
    }

    @Nonnull
    @Override
    public Map<String, Object> getVariables() {
        if (variables != null) {
            return Collections.unmodifiableMap(variables);
        }
        return Collections.emptyMap();
    }

    @Nonnull
    @Override
    public Locale getLocale() {
        if (locale != null) {
            return locale;
        } else {
            return Locale.getDefault();
        }
    }
}
