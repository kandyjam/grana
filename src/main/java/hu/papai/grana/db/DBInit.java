package hu.papai.grana.db;

import hu.papai.grana.model.*;
import hu.papai.grana.repository.DictionaryCodomainRepository;
import hu.papai.grana.repository.ManufactureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DBInit implements CommandLineRunner {

    private final ManufactureRepository manufactureRepository;

    private final DictionaryCodomainRepository dictionaryCodomainRepository;

    public DBInit(ManufactureRepository manufactureRepository, DictionaryCodomainRepository dictionaryCodomainRepository) {
        this.manufactureRepository = manufactureRepository;
        this.dictionaryCodomainRepository = dictionaryCodomainRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        addDictionaryValues();

        Disc disc1 = new Disc();
        disc1.setUniqueNumber(1234);
        disc1.setMeasurementDate(LocalDate.now());
        disc1.setProductionNumber("1234-567890");
        disc1.setRatedDiameter("450");
        disc1.setComment("This is a special disc.");

        Disc disc2 = new Disc();
        disc2.setUniqueNumber(1235);
        disc2.setMeasurementDate(LocalDate.of(2017, 8, 22));
        disc2.setProductionNumber("8347-029373");
        disc2.setRatedDiameter("320");

        Disc disc3 = new Disc();
        disc3.setUniqueNumber(1236);
        disc3.setMeasurementDate(LocalDate.of(2017, 7, 18));
        disc3.setProductionNumber("0029-837465");
        disc3.setRatedDiameter("280");
        disc3.setComment("This disc has a strange curve.");

        Disc disc4 = new Disc();
        disc4.setUniqueNumber(1237);
        disc4.setMeasurementDate(LocalDate.of(2017, 6, 27));
        disc4.setProductionNumber("0293-982637");
        disc4.setRatedDiameter("500");

        Fabric fabric1 = new Fabric();
        fabric1.setItemNumber(123);
        fabric1.setManufacturer("Granit");
        fabric1.setPosition("UPPER");
        fabric1.setSize("10");
        disc1.getFabrics().add(fabric1);

        Manufacture manufacture1 = new Manufacture();
        manufacture1.setPlannedManufacturedPiece(10);
        manufacture1.setPurpose("Experimenting with a new technique.");
        manufacture1.setPlannedManufactureDate(LocalDate.now());
        manufacture1.getDiscs().addAll(Arrays.asList(disc1, disc2));

        Manufacture manufacture2 = new Manufacture();
        manufacture2.setPlannedManufacturedPiece(250);
        manufacture2.setPurpose("Standard quarter-year demo.");
        manufacture2.setPlannedManufactureDate(LocalDate.of(2017, 9, 1));
        manufacture2.getDiscs().addAll(Arrays.asList(disc3, disc4));

        manufactureRepository.save(manufacture1);
        manufactureRepository.save(manufacture2);
    }

    private void addDictionaryValues() {

        DictionaryCodomain diameter = new DictionaryCodomain();
        diameter.setKey(DictionaryKey.RATED_DIAMETER);
        diameter.setValues(Arrays.asList("115", "125", "180", "230", "320", "450"));

        DictionaryCodomain manufacturer = new DictionaryCodomain();
        manufacturer.setKey(DictionaryKey.MANUFACTURER);
        manufacturer.setValues(Arrays.asList("Tevesa", "Virtex", "La Nouva", "Runbao"));

        DictionaryCodomain size = new DictionaryCodomain();
        size.setKey(DictionaryKey.SIZE);
        size.setValues(Arrays.asList("114", "124", "178", "228", "299", "445"));

        DictionaryCodomain position = new DictionaryCodomain();
        position.setKey(DictionaryKey.POSITION);
        position.setValues(Arrays.asList("alsó", "felső", "belső1", "belső2", "belső3"));

        dictionaryCodomainRepository.save(Arrays.asList(diameter, manufacturer, size, position));
    }
}
