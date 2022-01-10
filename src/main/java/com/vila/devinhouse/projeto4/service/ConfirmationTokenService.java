package com.vila.devinhouse.projeto4.service;

import com.vila.devinhouse.projeto4.model.ConfirmationToken;
import com.vila.devinhouse.projeto4.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public
class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    void saveConfirmationToken(ConfirmationToken confirmationToken) {

        confirmationTokenRepository.save(confirmationToken);
    }


    void deleteConfirmationToken(Long id){

        confirmationTokenRepository.deleteById(id);
    }


    public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {
        return confirmationTokenRepository.findConfirmationTokenByToken(token);
    }
}