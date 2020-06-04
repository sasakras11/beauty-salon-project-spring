package com.salon.service.impl;

import com.salon.entity.Role;
import com.salon.entity.User;
import com.salon.exception.LoginCredentialsException;
import com.salon.exception.UserIsRegisteredException;
import com.salon.repository.UserRepository;
import com.salon.service.PasswordEncoder;
import com.salon.service.Validator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";

    private static final User USER =
            User.builder()
                    .role(Role.CLIENT)
                    .username(USERNAME)
                    .build();
    @Mock
    private UserRepository userRepository;

    @Mock
    private Validator validator;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl service;

    @After
    public void resetMocks() {
        reset(userRepository, validator, passwordEncoder);
    }

    @Test(expected = LoginCredentialsException.class)
    public void whenPasswordIsWrongShouldBeException() {
        when(userRepository.findUserByUsername(anyString())).thenReturn(Optional.of(USER));
        when(passwordEncoder.matches(any(), any())).thenReturn(false);

        User user = service.login(USERNAME, PASSWORD);

        verify(userRepository).findUserByUsername(eq(USERNAME));
        verify(passwordEncoder).matches(any(), any());

    }

    @Test(expected = LoginCredentialsException.class)
    public void whenThereIsNoSuchUserInDatabaseShouldBeException() {
        when(userRepository.findUserByUsername(anyString())).thenReturn(Optional.empty());
        when(passwordEncoder.matches(any(), any())).thenReturn(true);

        User user = service.login(USERNAME, PASSWORD);


        verify(userRepository).findUserByUsername(eq(USERNAME));
    }

    @Test
    public void whenCredentialsAreVerifiedLoginShouldReturnTrue() {
        when(userRepository.findUserByUsername(anyString())).thenReturn(Optional.of(USER));
        when(passwordEncoder.matches(any(), any())).thenReturn(true);
        User user = service.login(USERNAME, PASSWORD);

        Assert.assertEquals(USER,user);

        verify(userRepository).findUserByUsername(eq(USERNAME));
        verify(passwordEncoder).matches(any(), any());

    }

    @Test
    public void userShouldRegisterIfHeIsValidatedAndThereIsNoSuchUserInDatabase() {
        doNothing().when(validator).validate(any(), any());
        when(userRepository.findUserByUsername(any())).thenReturn(Optional.empty());


        Assert.assertEquals(USER, service.register(USERNAME, PASSWORD));

        verify(userRepository).findUserByUsername(eq(USERNAME));
    }

    @Test(expected = UserIsRegisteredException.class)
    public void ifUserIsAlreadyInDatabaseShouldBeException(){
        doNothing().when(validator).validate(USERNAME,PASSWORD);
        when(userRepository.findUserByUsername(USERNAME)).thenReturn(Optional.of(USER));

        service.register(USERNAME,PASSWORD);

        verify(userRepository).findUserByUsername(USERNAME);

    }








}