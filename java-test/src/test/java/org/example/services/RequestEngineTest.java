package org.example.services;

import org.example.employees.Employees;
import org.example.vm.Desktop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RequestEngineTest {
    @Mock
    AuthorisingService authorisingServiceMock;
    @Mock
    Desktop desktop;

    RequestEngine newRequest;

    @Mock
    Employees employees;


    @BeforeEach
    void setUp() {
        newRequest = new RequestEngine("Emma");
        authorisingServiceMock = mock(AuthorisingService.class);
        when(authorisingServiceMock.isAuthorised(anyString())).thenReturn(true);

        desktop = mock(Desktop.class);

        employees = mock(Employees.class);
        when(employees.isEntitlement()).thenReturn(true);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createNewRequestUserNotEntitledTest() throws UserNotEntitledException, MachineNotCreatedException{
        assertThrows(UserNotEntitledException.class, ()-> {newRequest.createNewRequest(desktop);});
    }
    @Test
    void createNewRequestMachineNotCreatedExceptionTest() throws UserNotEntitledException, MachineNotCreatedException{
        assertThrows(MachineNotCreatedException.class, ()-> {newRequest.createNewRequest(desktop);});
    }
    void createNewRequestTest() throws UserNotEntitledException, MachineNotCreatedException{
        assertDoesNotThrow(()-> {newRequest.createNewRequest(desktop);});
    }



    @Test
    void totalBuildsByUserForDay() {
        assertNotNull(newRequest.totalFailedBuildsForDay());
    }

    @Test
    void totalFailedBuildsForDay() {

    }
}