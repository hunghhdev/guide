package dev.hunghh.jpaentitylistener;

import javassist.NotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class JpaEntityListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEntityListenerApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            UserEntity user = UserEntity.builder()
                    .username("xin chao")
                    .password("123123")
                    .build();
            repository.saveAndFlush(user);

            Optional<UserEntity> userOptional = repository.findById(user.getId());
            if (userOptional.isEmpty()) throw new NotFoundException("not found");
            userOptional.get().setUsername("hello");
            repository.save(userOptional.get());

            repository.delete(user);
        };
    }

}
