package hu.papai.grana.db;

import hu.papai.grana.model.*;
import hu.papai.grana.model.security.AuthorityConstants;
import hu.papai.grana.model.security.GranaAuthority;
import hu.papai.grana.model.security.GranaUser;
import hu.papai.grana.repository.DictionaryCodomainRepository;
import hu.papai.grana.repository.ManufactureRepository;
import hu.papai.grana.repository.GranaUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DBInit implements CommandLineRunner {

    private final ManufactureRepository manufactureRepository;

    private final DictionaryCodomainRepository dictionaryCodomainRepository;

    private final GranaUserRepository granaUserRepository;

    private final PasswordEncoder passwordEncoder;

    public DBInit(ManufactureRepository manufactureRepository, DictionaryCodomainRepository dictionaryCodomainRepository, GranaUserRepository granaUserRepository, PasswordEncoder passwordEncoder) {
        this.manufactureRepository = manufactureRepository;
        this.dictionaryCodomainRepository = dictionaryCodomainRepository;
        this.granaUserRepository = granaUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        addUsers();
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

    private void addUsers() {

        String password = passwordEncoder.encode("password");

        GranaUser admin = new GranaUser();
        admin.setUsername("admin");
        admin.setPassword(password);

        GranaUser manager = new GranaUser();
        manager.setUsername("manager");
        manager.setPassword(password);

        GranaUser user = new GranaUser();
        user.setUsername("operator");
        user.setPassword(password);

        GranaAuthority adminAuth = new GranaAuthority();
        adminAuth.setName(AuthorityConstants.ROLE_ADMIN);

        GranaAuthority managerAuth = new GranaAuthority();
        managerAuth.setName(AuthorityConstants.ROLE_MANAGER);

        GranaAuthority operatorAuth = new GranaAuthority();
        operatorAuth.setName(AuthorityConstants.ROLE_OPERATOR);

        admin.getAuthorities().addAll(Arrays.asList(adminAuth, managerAuth, operatorAuth));
        manager.getAuthorities().addAll(Arrays.asList(managerAuth, operatorAuth));
        user.getAuthorities().add(operatorAuth);

        granaUserRepository.save(Arrays.asList(admin, manager, user));
    }

    private void addDictionaryValues() {

        DictionaryCodomain diameter = new DictionaryCodomain();
        diameter.setKey(DictionaryKey.RATED_DIAMETER);
        diameter.setValues(new HashSet<>(Arrays.asList("115", "125", "180", "230", "320", "450")));

        DictionaryCodomain manufacturer = new DictionaryCodomain();
        manufacturer.setKey(DictionaryKey.MANUFACTURER);
        manufacturer.setValues(new HashSet<>(Arrays.asList("Tevesa", "Virtex", "La Nouva", "Runbao")));

        DictionaryCodomain size = new DictionaryCodomain();
        size.setKey(DictionaryKey.SIZE);
        size.setValues(new HashSet<>(Arrays.asList("114", "124", "178", "228", "299", "445")));

        DictionaryCodomain position = new DictionaryCodomain();
        position.setKey(DictionaryKey.POSITION);
        position.setValues(new HashSet<>(Arrays.asList("alsó", "felső", "belső1", "belső2", "belső3")));

        dictionaryCodomainRepository.save(Arrays.asList(diameter, manufacturer, size, position));
    }
}
