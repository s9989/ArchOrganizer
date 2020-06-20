package archorganizer;

import archorganizer.model.complex.ColorSet;
import archorganizer.model.complex.Subject;
import archorganizer.model.document.Guidelines;
import archorganizer.model.document.Invoice;
import archorganizer.model.document.attachment.Attachment;
import archorganizer.model.document.attachment.Office;
import archorganizer.model.project.Project;
import archorganizer.model.project.Stage;
import archorganizer.model.user.Expert;
import archorganizer.model.user.User;
import archorganizer.repository.ProjectRepository;
import archorganizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    private HashMap<String, User> initializeUsers()
    {
        HashMap<String, User> users = new HashMap<>();

        // architects
        User mku = new User("Marian", "Kuczyński", "mku", "mku");
        mku.addArchitect("University of Białystok");
        userRepository.save(mku);
        users.put("mku", mku);
        User pbz = new User("Paweł", "Bzdenkiewicz", "pbz", "pbz");
        pbz.addArchitect("University of Warsaw");
        userRepository.save(pbz);
        users.put("pbz", pbz);
        User tsz = new User("Tomasz", "Szymański", "tsz", "tsz");
        tsz.addArchitect("University of Lublin");
        userRepository.save(tsz);
        users.put("tsz", tsz);

        // experts
        User ibo = new User("Iwona", "Bonagiweicz", "ibo", "ibo");
        ibo.addExpert("Dorian", Expert.SPECIALISATION_SANITATION);
        userRepository.save(ibo);
        users.put("ibo", ibo);
        User pad = new User("Piotr", "Adamowicz", "pad", "pad");
        pad.addExpert("CzechBud", Expert.SPECIALISATION_FIRE);
        userRepository.save(pad);
        users.put("pad", pad);
        User lpa = new User("Łukasz", "Patenko", "lpa", "lpa");
        lpa.addExpert("CzechBud", Expert.SPECIALISATION_CONSTRUCTION);
        userRepository.save(lpa);
        users.put("lpa", lpa);
        User psw = new User("Przemysław", "Świerczewski", "psw", "psw");
        psw.addExpert("CzechBud", Expert.SPECIALISATION_ELECTRICITY);
        userRepository.save(psw);
        users.put("psw", psw);
        User aku = new User("Aleksandra", "Kumańska", "aku", "aku");
        aku.addExpert("ArchKrajex", Expert.SPECIALISATION_GREEN);
        userRepository.save(aku);
        users.put("aku", aku);
        User ado = new User("Adam", "Domaniewski", "ado", "ado");
        ado.addExpert("AsfaltBud", Expert.SPECIALISATION_ROADS);
        userRepository.save(ado);
        users.put("ado", ado);

        // investors
        User mal = new User("Michał", "Alekandriejewicz", "mal", "mal");
        mal.addInvestor("JW Construction", "jw@construction.net");
        userRepository.save(mal);
        users.put("mal", mal);
        User ate = new User("Antoni", "Terkowski", "ate", "ate");
        ate.addInvestor("Budimex", "kontakt@budimex.com");
        userRepository.save(ate);
        users.put("ate", ate);

        // accountants
        User mlo = new User("Milena", "Łosicka", "mlo", "mlo");
        mlo.addAccountant("KK-1043");
        userRepository.save(mlo);
        users.put("mlo", mlo);

        return users;
    }

    private HashMap<String, Project> initializeProjects(HashMap<String, User> users)
    {
        HashMap<String, Project> projects = new HashMap<>();
        List<String> emptyList = new ArrayList<String>();

        Project officeAndServiceBuilding = new Project("Budynek biurowo-usługowy");
        officeAndServiceBuilding.setManager(users.get("mku").getArchitect());
        Stage concept1 = officeAndServiceBuilding.addConcept(null);
        concept1.addExpert(users.get("aku").getExpert()); // green
        concept1.addExpert(users.get("ibo").getExpert()); // sanitation
        concept1.addExpert(users.get("psw").getExpert()); // electricity

        Stage building1 = officeAndServiceBuilding.addBuilding(emptyList);
        building1.addExpert(users.get("aku").getExpert()); // green
        building1.addExpert(users.get("ado").getExpert()); // roads
        building1.addExpert(users.get("ibo").getExpert()); // sanitation
        building1.addExpert(users.get("psw").getExpert()); // electricity
        building1.addExpert(users.get("lpa").getExpert()); // construction
        building1.addExpert(users.get("pad").getExpert()); // fire

        Stage execution1 = officeAndServiceBuilding.addExecution(emptyList, null);
        execution1.addExpert(users.get("ibo").getExpert()); // sanitation
        execution1.addExpert(users.get("psw").getExpert()); // electricity
        execution1.addExpert(users.get("lpa").getExpert()); // construction

        projects.put("officeAndServiceBuilding", officeAndServiceBuilding);
        projectRepository.save(officeAndServiceBuilding);

        Project multiFamilyApartmentBuilding = new Project("Budynek mieszkalny-wielorodzinny");
        multiFamilyApartmentBuilding .setManager(users.get("pbz").getArchitect());
        Stage concept2 = multiFamilyApartmentBuilding.addConcept(null);
        concept2.addExpert(users.get("ado").getExpert()); // roads
        concept2.addExpert(users.get("ibo").getExpert()); // sanitation
        concept2.addExpert(users.get("psw").getExpert()); // electricity

        Stage building2 = multiFamilyApartmentBuilding.addBuilding(emptyList);
        building2.addExpert(users.get("ibo").getExpert()); // sanitation
        building2.addExpert(users.get("psw").getExpert()); // electricity
        building2.addExpert(users.get("lpa").getExpert()); // construction
        building2.addExpert(users.get("pad").getExpert()); // fire

        projects.put("multiFamilyApartmentBuilding", multiFamilyApartmentBuilding);
        projectRepository.save(multiFamilyApartmentBuilding);

        Project retail = new Project("Budynek handowo-usługowy (Galeria handlowa)");
        retail .setManager(users.get("tsz").getArchitect());
        Stage concept3 = retail.addConcept(null);
        concept3.addExpert(users.get("aku").getExpert()); // green
        concept3.addExpert(users.get("ibo").getExpert()); // sanitation
        concept3.addExpert(users.get("psw").getExpert()); // electricity
        concept3.addExpert(users.get("lpa").getExpert()); // construction
        concept3.addExpert(users.get("pad").getExpert()); // fire

        Subject subject = new Subject();
        subject.setNIP("797987456");
        subject.setName("Firma X");
        subject.setFirstName("Jan");
        subject.setLastName("Kowalski");
        subject.setAddress("Panamska 1, 00-001 Warszawa");

        Invoice invoice = new Invoice();
        invoice.setIssueDate(LocalDate.now());
        invoice.setPaymentDate(LocalDate.now());
        invoice.setDocumentName("FV 2020/06/02");
        invoice.setIssuer(subject);
        invoice.setReceiver(subject);

        concept3.addInvoice(invoice);

        projects.put("retail", retail);
        projectRepository.save(retail);

        Project industrialBuilding = new Project("Budynek przemysłowy (Hala produkcyjna)");
        industrialBuilding .setManager(users.get("mku").getArchitect());
        Stage concept4 = industrialBuilding.addConcept(null);
        concept4.addExpert(users.get("ibo").getExpert()); // sanitation
        concept4.addExpert(users.get("psw").getExpert()); // electricity
        concept4.addExpert(users.get("lpa").getExpert()); // construction
        concept4.addExpert(users.get("pad").getExpert()); // fire

        Stage building4 = industrialBuilding.addBuilding(emptyList);
        building4.addExpert(users.get("ado").getExpert()); // roads
        building4.addExpert(users.get("ibo").getExpert()); // sanitation
        building4.addExpert(users.get("psw").getExpert()); // electricity
        building4.addExpert(users.get("lpa").getExpert()); // construction
        building4.addExpert(users.get("pad").getExpert()); // fire

        Stage execution4 = industrialBuilding.addExecution(emptyList, null);
        execution4.addExpert(users.get("ado").getExpert()); // roads
        execution4.addExpert(users.get("ibo").getExpert()); // sanitation
        execution4.addExpert(users.get("psw").getExpert()); // electricity
        execution4.addExpert(users.get("lpa").getExpert()); // construction

        projects.put("industrialBuilding", industrialBuilding);
        projectRepository.save(industrialBuilding);

//        Project biurowo_uslugowy(biurowiec)
        // numer 101
        // adres jakiś tam 2b
        // - 1 w + 2 + 3 w

        // attachments: pismo x 2, sieci, standard
        // P: Zarząd dróg miejskich - ustalenie lokalizacji zjazdu - data ważności
        // P: Urząd Dzielnicy, Wydział Ochrony Środowiska - Środowiskowa Decyzja lokalizacyjna - data ważności
        // Si: Warunki techniczne przyłącza energetycznego
        // St: Założenia kosztorysu inwestorskiego

        // zieleń 1 2 // aku
        // drogi 2 // ado
        // instalacje wszystkie 1 2 3 // ibo psw
        // konstruktor 2 3 // lpa
        // pożar 2 // pad

//        Project budynek_mieszkalny_wielorodzinny(blok)
        // numer 102
        // adres jakiś tam 1b
        // - 1 w + 2

        // attachments: pismo, standard x 2
        // P: Zarząd dróg miejskich - Uzgodnienie organizacji ruchu drogowego
        // St: Standard wykończenia powierzchi wspólnych
        // St: Kolorystyka elewacji

        // instalacje wszystkie 1 2 // ibo psw
        // konstruktor 2 // lpa
        // pożar 2 // pad
        // drogi 1 // ado

//        Project handowo_uslugowy(galeria)
        // numer 103
        // adres jakiś tam 1b
        // - 1

        // attachments: pismo, sieci x 3
        // P: Urząd miasta - Warunki zabudowy
        // Si: Uzgodnienie lokalizacji sieci ciepłowniczej
        // Si: Zgoda na przebudowę instalacji kanalizacyjnej
        // Si: Warunki techniczne przyłącza wodnego

        // zieleń 1 // aku
        // instalacje wszystkie 1 // ibo psw
        // konstruktor 1 // lpa
        // pożar 1 // pad

//        Project przemyslowy(hala produkcyjna)
        // numer 104
        // adres jakiś tam 1b
        // - 1 + 2 w + 3

        // attachments: pismo x 2
        // P: Urzad Miasta - Decyzycja o pozwoleniu na budowę
        // P: Sanepid - Odstępstwo od przepisów sanitarnych


        // drogi 2 3 // ado
        // instalacje wszystkie 1 2 3 // ibo psw
        // konstruktor 1 2 3 // lpa
        // pożar 1 2 // pad


        return projects;
    }

    private void initializeDocuments(HashMap<String, User> users, HashMap<String, Project> projects)
    {
        Attachment office1 = Attachment.createOffice("Zarząd dróg miejskich", "Ustalenie lokalizacji zjazdu", "ref-1402N");
        Attachment office2 = Attachment.createOffice("Urząd Dzielnicy, Wydział Ochrony Środowiska", "Środowiskowa Decyzja lokalizacyjna", "ref-5210K");
        Attachment office3 = Attachment.createOffice("Zarząd dróg miejskich", "Uzgodnienie organizacji ruchu drogowego", "ref-9403Z");
        Attachment office4 = Attachment.createOffice("Urząd miasta", "Warunki zabudowy", "ref-1555N");
        Attachment office5 = Attachment.createOffice("Urzad Miasta", "Decyzycja o pozwoleniu na budowę", "ref-9831J");
        Attachment office6 = Attachment.createOffice("Sanepid", "Odstępstwo od przepisów sanitarnych", "ref-6565K");

        Attachment network1 = Attachment.createNetwork("Warunki techniczne przyłącza energetycznego");
        Attachment network2 = Attachment.createNetwork("Uzgodnienie lokalizacji sieci ciepłowniczej");
        Attachment network3 = Attachment.createNetwork("Zgoda na przebudowę instalacji kanalizacyjnej");
        Attachment network4 = Attachment.createNetwork("Warunki techniczne przyłącza wodnego");

        Attachment standard1 = Attachment.createStandard("Założenia kosztorysu inwestorskiego", 10000.00);
        Attachment standard2 = Attachment.createStandard("Standard wykończenia powierzchi wspólnych", 20000.00);
        Attachment standard3 = Attachment.createStandard("Kolorystyka elewacji", 5000.00, new ColorSet("red"));


        Guidelines guidelines1 = new Guidelines("Wytyczne do koncepcji");
        guidelines1.addGuideline("example1");
        guidelines1.addGuideline("example2");
        guidelines1.addGuideline("example3");

        Guidelines guidelines2 = new Guidelines("Wytyczne do etapu wykonawczego");
        guidelines2.addGuideline("example1");

        try {
            projects.get("officeAndServiceBuilding").getConceptStage().addGuidelines(guidelines1);
            projects.get("officeAndServiceBuilding").getExecutionStage().addGuidelines(guidelines2);

            projects.get("officeAndServiceBuilding").addAttachment(office1);
            projects.get("officeAndServiceBuilding").addAttachment(office2);
            projects.get("officeAndServiceBuilding").addAttachment(network1);
            projects.get("officeAndServiceBuilding").addAttachment(standard1);
        } catch (Exception excepion) {
            System.out.println("Error while data initialization: " + excepion.getMessage());
        }

        projectRepository.save(projects.get("officeAndServiceBuilding"));

        Guidelines guidelines3 = new Guidelines("Wytyczne do koncepcji");
        guidelines3.addGuideline("example1");
        guidelines3.addGuideline("example2");

        try {
            projects.get("multiFamilyApartmentBuilding").getConceptStage().addGuidelines(guidelines3);

            projects.get("multiFamilyApartmentBuilding").addAttachment(office3);
            projects.get("multiFamilyApartmentBuilding").addAttachment(standard2);
            projects.get("multiFamilyApartmentBuilding").addAttachment(standard3);
        } catch (Exception excepion) {
            System.out.println("Error while data initialization: " + excepion.getMessage());
        }

        projectRepository.save(projects.get("multiFamilyApartmentBuilding"));

        projects.get("retail").addAttachment(office4);
        projects.get("retail").addAttachment(network2);
        projects.get("retail").addAttachment(network3);
        projects.get("retail").addAttachment(network4);

        projectRepository.save(projects.get("retail"));

        Guidelines guidelines4 = new Guidelines("Wytyczne do etapu budowlanego");
        guidelines4.addGuideline("example1");

        try {
            projects.get("industrialBuilding").getBuildingStage().addGuidelines(guidelines4);

            projects.get("industrialBuilding").addAttachment(office5);
            projects.get("industrialBuilding").addAttachment(office6);
        } catch (Exception excepion) {
            System.out.println("Error while data initialization: " + excepion.getMessage());
        }

        projectRepository.save(projects.get("industrialBuilding"));





    }

    public void initialize()
    {
        HashMap<String, User> users = initializeUsers();
        HashMap<String, Project> projects = initializeProjects(users);
        initializeDocuments(users, projects);
    }

}
