package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Mock
    SpecialtyRepository specialtyRepository;

    @Test
    void testDeleteById() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        verify(specialtyRepository, times(2)).deleteById(1l);
    }

    @Test
    void testDelete() {
        specialitySDJpaService.delete(new Speciality());
    }

    @Test
    void findById() {
        Speciality speciality = new Speciality();
        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
        Speciality foundSpeciality = specialitySDJpaService.findById(1L);
        assertNotNull(foundSpeciality);
        verify(specialtyRepository).findById(anyLong());
        assertEquals(speciality, foundSpeciality);
    }
}