package tai.springmvcrecipeapp.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tai.springmvcrecipeapp.commands.UnitOfMeasureCommand;
import tai.springmvcrecipeapp.domain.UnitOfMeasure;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        if(unitOfMeasure == null) return null;

        final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(unitOfMeasure.getId());
        unitOfMeasureCommand.setDescription(unitOfMeasure.getDescription());

        return unitOfMeasureCommand;
    }
}
