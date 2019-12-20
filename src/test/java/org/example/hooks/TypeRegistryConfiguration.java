package org.example.hooks;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.Transformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>("stringDate", "\\d{4}\\-\\d{2}\\-\\d{2}",
                LocalDate.class, (Transformer<LocalDate>) s -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(s, formatter);
        }));
    }
}
