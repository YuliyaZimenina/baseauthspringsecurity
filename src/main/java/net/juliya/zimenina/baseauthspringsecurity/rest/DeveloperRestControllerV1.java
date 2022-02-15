package net.juliya.zimenina.baseauthspringsecurity.rest;


import net.juliya.zimenina.baseauthspringsecurity.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    //Collection to simulate a database
    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Bob", "Martin"),
            new Developer(2L, "Max", "Point"),
            new Developer(3L, "Andre", "Almond")
            ).collect(Collectors.toList());


    // Method that returns a list of all developers
    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    //Method for finding Developer by ID
    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
