package hu.papai.grana.db;

import hu.papai.grana.model.*;
import hu.papai.grana.model.security.AuthorityConstants;
import hu.papai.grana.model.security.GranaAuthority;
import hu.papai.grana.model.security.GranaUser;
import hu.papai.grana.repository.DictionaryCodomainRepository;
import hu.papai.grana.repository.DiscRepository;
import hu.papai.grana.repository.GranaUserRepository;
import hu.papai.grana.repository.StandardDiscTestDataSheetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DBInit implements CommandLineRunner {

    private final DictionaryCodomainRepository dictionaryCodomainRepository;

    private final GranaUserRepository granaUserRepository;

    private final PasswordEncoder passwordEncoder;

    private final DiscRepository discRepository;

    private final StandardDiscTestDataSheetRepository sheetRepository;

    public DBInit(DictionaryCodomainRepository dictionaryCodomainRepository, GranaUserRepository granaUserRepository, PasswordEncoder passwordEncoder, DiscRepository discRepository, StandardDiscTestDataSheetRepository sheetRepository) {
        this.dictionaryCodomainRepository = dictionaryCodomainRepository;
        this.granaUserRepository = granaUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.discRepository = discRepository;
        this.sheetRepository = sheetRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addUsers();
        addDictionaryValues();
        addDiscs();
    }

    private void addDiscs() {

        Disc disc1 = new Disc();
        disc1.setUniqueNumber(1234);
        disc1.setMeasurementDate(LocalDate.now());
        disc1.setDollopProductionNumber("1234-567890");
        disc1.setRatedDiameter("450");

        StandardDiscTestResult standardDiscTestResult1 = new StandardDiscTestResult();
        standardDiscTestResult1.setNumber(4);
        standardDiscTestResult1.getAttributesBeforeTest().setDiameter(115.04);
        standardDiscTestResult1.getAttributesAfterTest().setDiameter(110.82);
        standardDiscTestResult1.getAttributesBeforeTest().setMass(40.4);
        standardDiscTestResult1.getAttributesAfterTest().setMass(37.3);
        standardDiscTestResult1.setMinThickness(1.65);
        standardDiscTestResult1.setMaxThickness(1.75);
        standardDiscTestResult1.setCuttingTimes(Arrays.asList(4.73, 4.54, 4.56, 4.02, 4.38, 4.12, 4.61, 4.2, 4.73));

        StandardDiscTestResult standardDiscTestResult2 = new StandardDiscTestResult();
        standardDiscTestResult2.setNumber(5);
        standardDiscTestResult2.getAttributesBeforeTest().setDiameter(114.95);
        standardDiscTestResult2.getAttributesAfterTest().setDiameter(111.16);
        standardDiscTestResult2.getAttributesBeforeTest().setMass(38.8);
        standardDiscTestResult2.getAttributesAfterTest().setMass(35.8);
        standardDiscTestResult2.setMinThickness(1.66);
        standardDiscTestResult2.setMaxThickness(1.78);
        standardDiscTestResult2.setCuttingTimes(Arrays.asList(4.28, 4.51, 4.12, 4.44, 4.23, 4.11, 4.67, 4.56));

        StandardDiscTestResult standardDiscTestResult3 = new StandardDiscTestResult();
        standardDiscTestResult3.setNumber(6);
        standardDiscTestResult3.getAttributesBeforeTest().setDiameter(115.04);
        standardDiscTestResult3.getAttributesAfterTest().setDiameter(110.88);
        standardDiscTestResult3.getAttributesBeforeTest().setMass(41.9);
        standardDiscTestResult3.getAttributesAfterTest().setMass(39.1);
        standardDiscTestResult3.setMinThickness(1.72);
        standardDiscTestResult3.setMaxThickness(1.82);
        standardDiscTestResult3.setCuttingTimes(Arrays.asList(4.51, 4.82, 4.62, 5.01, 4.66, 4.82, 4.89));

        Disc disc2 = new Disc();
        disc2.setUniqueNumber(1235);
        disc2.setMeasurementDate(LocalDate.of(2017, 8, 22));
        disc2.setDollopProductionNumber("8347-029373");
        disc2.setRatedDiameter("320");

        Disc disc3 = new Disc();
        disc3.setUniqueNumber(1236);
        disc3.setMeasurementDate(LocalDate.of(2017, 7, 18));
        disc3.setDollopProductionNumber("0029-837465");
        disc3.setRatedDiameter("280");

        Disc disc4 = new Disc();
        disc4.setUniqueNumber(1237);
        disc4.setMeasurementDate(LocalDate.of(2017, 6, 27));
        disc4.setDollopProductionNumber("0293-982637");
        disc4.setRatedDiameter("500");

        Fabric fabric1 = new Fabric();
        fabric1.setItemNumber(123);
        fabric1.setManufacturer("Granit");
        fabric1.setPosition("UPPER");
        fabric1.setSize("10");

        disc1.getFabrics().add(fabric1);

        discRepository.save(Arrays.asList(disc1, disc2, disc3, disc4));

        StandardDiscTestDataSheet sheet = new StandardDiscTestDataSheet();
        sheet.setDate(LocalDate.now());
        sheet.setMachineType("Berner");
        sheet.setDisc(disc1);
        sheet.setTesterName("Cégény Zoltán");
        sheet.setTestMaterialQuality("Szerkezeti acél");
        sheet.setTestMaterialSize("100x2");
        sheet.setTestType("Kézi");
        sheet.getTestResults().addAll(Arrays.asList(standardDiscTestResult1, standardDiscTestResult2, standardDiscTestResult3));

        sheetRepository.save(sheet);
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
        size.setKey(DictionaryKey.FABRIC_SIZE);
        size.setValues(new HashSet<>(Arrays.asList("114", "124", "178", "228", "299", "445")));

        DictionaryCodomain position = new DictionaryCodomain();
        position.setKey(DictionaryKey.POSITION);
        position.setValues(new HashSet<>(Arrays.asList("alsó", "felső", "belső1", "belső2", "belső3")));

        DictionaryCodomain testers = new DictionaryCodomain();
        testers.setKey(DictionaryKey.TESTER_NAME);
        testers.setValues(new HashSet<>(Arrays.asList("Cégény Zoltán", "Székely Ádám")));

        DictionaryCodomain machineTypes = new DictionaryCodomain();
        machineTypes.setKey(DictionaryKey.MACHINE_TYPE);
        machineTypes.setValues(new HashSet<>(Arrays.asList("Berner", "DeWalt", "Ackermann 180", "Flex")));

        DictionaryCodomain testTypes = new DictionaryCodomain();
        testTypes.setKey(DictionaryKey.TEST_TYPE);
        testTypes.setValues(new HashSet<>(Arrays.asList("Kézi", "Automata")));

        DictionaryCodomain testMaterialQualities = new DictionaryCodomain();
        testMaterialQualities.setKey(DictionaryKey.TEST_MATERIAL_QUALITY);
        testMaterialQualities.setValues(new HashSet<>(
            Arrays.asList(  "Szerkezeti acél", "Laposvas zártszelvény 25x25x3", "Kroma kör 16",
                            "Alumínium kör 15", "Laposvas téglalap 40x10")
        ));

        DictionaryCodomain testMaterialSizes = new DictionaryCodomain();
        testMaterialSizes.setKey(DictionaryKey.TEST_MATERIAL_SIZE);
        testMaterialSizes.setValues(new HashSet<>(Arrays.asList("100x2", "40x10", "25x25x3", "∅15", "∅16")));

        DictionaryCodomain pressMachines = new DictionaryCodomain();
        pressMachines.setKey(DictionaryKey.PRESS_MACHINE);
        pressMachines.setValues(new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6")));

        DictionaryCodomain machineSides = new DictionaryCodomain();
        machineSides.setKey(DictionaryKey.MACHINE_SIDE);
        machineSides.setValues(new HashSet<>(Arrays.asList("A", "B")));

        DictionaryCodomain nestNumbers = new DictionaryCodomain();
        nestNumbers.setKey(DictionaryKey.NEST_NUMBER);
        nestNumbers.setValues(new HashSet<>(Arrays.asList("4", "6", "8", "24")));

        dictionaryCodomainRepository.save(
            Arrays.asList(
                diameter, manufacturer, size, position, testers, machineTypes, testTypes, testMaterialQualities,
                testMaterialSizes, pressMachines, machineSides, nestNumbers));
    }
}
