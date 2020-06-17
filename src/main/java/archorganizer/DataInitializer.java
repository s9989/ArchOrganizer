package archorganizer;

import archorganizer.model.user.Expert;
import archorganizer.model.user.User;
import archorganizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    public void initData()
    {
        User mku = new User("Marian", "Kuczyński", "mku", "mku");
        mku.addArchitect("University of Białystok");
        User pbz = new User("Paweł", "Bzdenkiweicz", "pbz", "pbz");
        pbz.addArchitect("University of Warsaw");
        User tsz = new User("Tomasz", "Szymański", "tsz", "tsz");
        tsz.addArchitect("University of Lublin");

        User ibo = new User("Iwona", "Bonagiweicz", "ibo", "ibo");
        ibo.addExpert("Dolkan", Expert.SPECIALISATION_SANITATION);
        User pad = new User("Piotr", "Adamowicz", "pad", "pad");
        pad.addExpert("PolBud", Expert.SPECIALISATION_FIRE);
        User lpa = new User("Łukasz", "Patenko", "lpa", "lpa");
        lpa.addExpert("PolBud", Expert.SPECIALISATION_CONSTRUCTION);
        User psw = new User("Przemysław", "Świerczewski", "psw", "psw");
        psw.addExpert("PolBud", Expert.SPECIALISATION_ELECTRICITY);
        User aku = new User("Aleksandra", "Kumańska", "aku", "aku");
        aku.addExpert("Reneges", Expert.SPECIALISATION_GREEN);

        User mal = new User("Michał", "Alekandriejewicz", "mal", "mal");
        mal.addInvestor("JW Construction", "jw@construction.net");
        User ate = new User("Antoni", "Terkowski", "ate", "ate");
        ate.addInvestor("Budimex", "kontakt@budimex.com");


        User mlo = new User("Milena", "Łosicka", "mlo", "mlo");
        mlo.addAccountant("KK-1043");

        userRepository.save(mku);
        userRepository.save(pbz);
        userRepository.save(tsz);
        userRepository.save(ibo);
        userRepository.save(pad);
        userRepository.save(lpa);
        userRepository.save(psw);
        userRepository.save(aku);
        userRepository.save(mal);
        userRepository.save(ate);
        userRepository.save(mlo);

    }

}
