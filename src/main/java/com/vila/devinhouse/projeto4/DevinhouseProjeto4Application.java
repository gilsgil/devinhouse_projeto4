package com.vila.devinhouse.projeto4;

import com.vila.devinhouse.projeto4.model.User;
import com.vila.devinhouse.projeto4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DevinhouseProjeto4Application {

    public static void main(String[] args) {
        SpringApplication.run(DevinhouseProjeto4Application.class, args);
    }


}
