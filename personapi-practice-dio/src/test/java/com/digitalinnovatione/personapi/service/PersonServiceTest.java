package com.digitalinnovatione.personapi.service;

import com.digitalinnovatione.personapi.dto.request.PersonDTO;
import com.digitalinnovatione.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovatione.personapi.entity.Person;
import com.digitalinnovatione.personapi.repository.PersonRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.digitalinnovatione.personapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class)))
                .thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedMessage = createExpectedResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedMessage, successMessage);

    }

    private MessageResponseDTO createExpectedResponse(Long id) {
        return MessageResponseDTO.builder()
                .message("Updated Person with ID " + id)
                .build();
    }
}
