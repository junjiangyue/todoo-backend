package org.example.todoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
@ServletComponentScan
public class todooAplication {
    public static void main(String[] args) {
        SpringApplication.run(todooAplication.class, args);
    }
}
