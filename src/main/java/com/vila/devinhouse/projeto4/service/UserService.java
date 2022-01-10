package com.vila.devinhouse.projeto4.service;

import com.vila.devinhouse.projeto4.model.ConfirmationToken;
import com.vila.devinhouse.projeto4.model.User;
import com.vila.devinhouse.projeto4.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        final Optional<User> optionalUser = userRepository.findByCpf(cpf);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("Usuário com CPF {0} não encontrado.", cpf));
        }
    }

    public void signUpUser(User user) {

        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

        final User createdUser = userRepository.save(user);

        final ConfirmationToken confirmationToken = new ConfirmationToken(user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

    }

    public void confirmUser(ConfirmationToken confirmationToken) {
    }
}
