package br.edu.ifpi.fcclient.service;

import br.edu.ifpi.fcclient.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryService {
    private final WebClient client;

    @GetMapping
    public Mono<List<Category>> getCategories(){
        return client.get()
                .uri("/category")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }

    @GetMapping(path = "/{id}")
    public Mono<Category> getCategories(@PathVariable Long id){
        return client.get()
                .uri("/category/{id}", id)
                .retrieve()
                .bodyToMono(Category.class);
    }
}
