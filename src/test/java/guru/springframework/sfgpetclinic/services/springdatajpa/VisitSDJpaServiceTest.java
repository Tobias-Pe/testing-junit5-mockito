package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @InjectMocks
    VisitSDJpaService service;

    @Mock
    VisitRepository repository;

    @Test
    void findAll() {
        Set<Visit> set = new HashSet<>();
        when(repository.findAll()).thenReturn(set);
        Set<Visit> foundSet = service.findAll();
        assertNotNull(foundSet);
        verify(repository).findAll();
    }

    @Test
    void findById() {
        Visit visit = new Visit();
        when(repository.findById(1L)).thenReturn(Optional.of(visit));
        Visit foundVisit = service.findById(1L);
        assertNotNull(foundVisit);
        Visit foundVisit2 = service.findById(2L);
        assertNull(foundVisit2);
        verify(repository, times(2)).findById(anyLong());
    }

    @Test
    void save() {
        service.save(new Visit());
        verify(repository).save(any(Visit.class));
    }

    @Test
    void delete() {
        service.delete(new Visit());
        verify(repository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }
}