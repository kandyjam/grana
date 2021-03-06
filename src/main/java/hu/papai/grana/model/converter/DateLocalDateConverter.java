package hu.papai.grana.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;

/**
 * This converter is responsible for mapping {@link LocalDate} to {@link Date}. This is needed, because the default
 * serialization for {@link LocalDate} is not human-readable.
 */
@Converter(autoApply = true)
public class DateLocalDateConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return attribute == null ? null : Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        return dbData == null ? null : dbData.toLocalDate();
    }
}
