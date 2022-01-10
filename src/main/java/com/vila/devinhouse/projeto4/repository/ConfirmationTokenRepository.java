package com.vila.devinhouse.projeto4.repository;

import com.vila.devinhouse.projeto4.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public
interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findConfirmationTokenByToken(String token);
}