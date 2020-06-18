package archorganizer;

import archorganizer.model.project.Project;
import archorganizer.model.project.Stage;
import archorganizer.model.user.Expert;
import archorganizer.model.user.User;
import archorganizer.repository.ProjectRepository;
import archorganizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

        Project officeAndServiceBuilding = new Project();
        officeAndServiceBuilding.setManager(users.get("mku").getArchitect());
        Stage concept1 = officeAndServiceBuilding.addConcept(null);
        Stage building1 = officeAndServiceBuilding.addBuilding(emptyList);
        Stage execution1 = officeAndServiceBuilding.addExecution(emptyList, null);
        projects.put("officeAndServiceBuilding", officeAndServiceBuilding);
        projectRepository.save(officeAndServiceBuilding);

        Project multiFamilyApartmentBuilding = new Project();
        multiFamilyApartmentBuilding .setManager(users.get("pbz").getArchitect());
        Stage concept2 = multiFamilyApartmentBuilding.addConcept(null);
        Stage building2 = multiFamilyApartmentBuilding.addBuilding(emptyList);
        projects.put("multiFamilyApartmentBuilding", multiFamilyApartmentBuilding);
        projectRepository.save(multiFamilyApartmentBuilding);

        Project retail = new Project();
        retail .setManager(users.get("tsz").getArchitect());
        Stage concept3 = retail.addConcept(null);
        projects.put("retail", retail);
        projectRepository.save(retail);

        Project industrialBuilding = new Project();
        industrialBuilding .setManager(users.get("mku").getArchitect());
        Stage concept4 = industrialBuilding.addConcept(null);
        Stage building4 = industrialBuilding.addBuilding(emptyList);
        Stage execution4 = industrialBuilding.addExecution(emptyList, null);
        projects.put("industrialBuilding", industrialBuilding);
        projectRepository.save(industrialBuilding);

//        Project biurowo_uslugowy(biurowiec) = new Project();
        // numer 101
        // adres jakiś tam 2b
        // - 1 w + 2 + 3 w

        // attachments: pismo x 2, sieci, standard
        // P: Zarząd dróg miejskich - ustalenie lokalizacji zjazdu - data ważności
        // P: Urząd Dzielnicy, Wydział Ochrony Środowiska - Środowiskowa Decyzja lokalizacyjna - data ważności
        // Si: Warunki techniczne przyłącza energetycznego
        // St: Założenia kosztorysu inwestorskiego

        // zieleń 1 2
        // drogi 2
        // instalacje wszystkie 1 2 3
        // konstruktor 2 3
        // pożar 2

//        Project budynek_mieszkalny_wielorodzinny(blok) = new Project();
        // numer 102
        // adres jakiś tam 1b
        // - 1 w + 2

        // attachments: pismo, standard x 2
        // P: Zarząd dróg miejskich - Uzgodnienie organizacji ruchu drogowego
        // St: Standard wykończenia powierzchi wspólnych
        // St: Kolorystyka elewacji

        // instalacje wszystkie 1 2
        // konstruktor 2
        // pożar 2
        // drogi 1

//        Project handowo_uslugowy(galeria) = new Project();
        // numer 103
        // adres jakiś tam 1b
        // - 1

        // attachments: pismo, sieci x 3
        // P: Urząd miasta - Warunki zabudowy
        // Si: Uzgodnienie lokalizacji sieci ciepłowniczej
        // Si: Zgoda na przebudowę instalacji kanalizacyjnej
        // Si: Warunki techniczne przyłącza wodnego

        // zieleń 1
        // instalacje wszystkie 1
        // konstruktor 1
        // pożar 1

//        Project przemyslowy(hala produkcyjna) = new Project();
        // numer 104
        // adres jakiś tam 1b
        // - 1 + 2 w + 3

        // attachments: pismo x 2
        // P: Urzad Miasta - Decyzycja o pozwoleniu na budowę
        // P: Sanepid - Odstępstwo od przepisów sanitarnych


        // drogi 2 3
        // instalacje wszystkie 1 2 3
        // konstruktor 1 2 3
        // pożar 1 2


        return projects;
    }

    private void initializeDocuments(HashMap<String, User> users, HashMap<String, Project> projects)
    {
        //
    }

    public void initialize()
    {
        HashMap<String, User> users = initializeUsers();
        HashMap<String, Project> projects = initializeProjects(users);
        initializeDocuments(users, projects);
    }

}
