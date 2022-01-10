package com.vila.devinhouse.projeto4.repository;

import com.vila.devinhouse.projeto4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Lista todos os habitantes filtrando por nome
    List<UserIdAndName> findALlByNomeIgnoreCase(String nome);

    // Listar os habitantes por data de nascimento
    List<UserIdAndName> findAllByMesNascimento(int mes);

    // Lista todos os habitantes
    List<UserIdAndName> findAllBy();

    // Lista todos os habitantes com idade superior ao valor informado
    List<UserIdAndName> findAllOrderByIdadeGreaterThan(int idade);

    // Lista um habitante detalhadamento através de seu ID
    Optional<UserDetailed> findFirstById(Long id);

    // Lista um usuário por seu CPF
    Optional<User> findByCpf(String cpf);
}

interface UserIdAndName {
    int getId();

    String getNome();
}

interface UserDetailed {
    String getNome();

    String getSobrenome();

    LocalDate getNascimento();

    int getRenda();

    String getCpf();
}