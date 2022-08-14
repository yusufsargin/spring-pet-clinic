package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;
import guru.springframework.sfgpetclinic.services.common.CommonRepositoryImplement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService extends CommonRepositoryImplement<Visit, VisitRepository> implements VisitService {

    public VisitSDJpaService(VisitRepository repository) {
        super(repository);
    }

}
