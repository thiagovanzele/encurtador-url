package br.com.vanzele.encurtador.controller;

import br.com.vanzele.encurtador.dto.UrlRequest;
import br.com.vanzele.encurtador.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/encurtar")
    public ResponseEntity<String> encurtarUrl(@RequestBody UrlRequest request) {
        String codigo = urlService.encurtar(request);

        String url = "http://localhost:8080/api/" + codigo;
        return ResponseEntity.created(URI.create(url)).body(url);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<String> buscarUrlOriginal(@PathVariable String codigo) {
        String urlOriginal = urlService.buscarUrl(codigo);

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(urlOriginal)).build();
    }
}
