package br.com.vanzele.encurtador.service;

import br.com.vanzele.encurtador.dto.UrlRequest;
import br.com.vanzele.encurtador.exception.ObjetoNaoEncontradoException;
import br.com.vanzele.encurtador.model.Url;
import br.com.vanzele.encurtador.repository.UrlRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String encurtar(UrlRequest request) {

        String urlPadronizada = padronizarUrl(request.url());

        Optional<Url> urlExistente = urlRepository.findByUrlOriginal(urlPadronizada);
        if (urlExistente.isPresent()) {
            return urlExistente.get().getCodigo();
        }

        Url url = new Url();
        url.setUrlOriginal(urlPadronizada);
        url.setCodigo(gerarCodigoUnico());

        urlRepository.save(url);

        return url.getCodigo();
    }

    public String buscarUrl(String codigo) {
        Url url = urlRepository.findByCodigo(codigo)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("URL não encontrada"));

        url.setTotalCliques(url.getTotalCliques() + 1L);
        urlRepository.save(url);

        return url.getUrlOriginal();
    }

    private String gerarCodigo() {
        Random random = new Random();
        CharSequence alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(alfabeto.length());
            sb.append(alfabeto.charAt(index));
        }

        return sb.toString();
    }

    private String gerarCodigoUnico() {
        String codigo;
        do {
            codigo = gerarCodigo();
        } while (urlRepository.findByCodigo(codigo).isPresent());
        return codigo;
    }

    private String padronizarUrl(String urlOriginal) {
        String url = urlOriginal.trim();

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        String inicioUrl = url.startsWith("http://") ? "http://" : "https://";
        String finalUrl = url.substring(inicioUrl.length());

        if (!finalUrl.contains("www.")) {
            finalUrl = "www." + finalUrl;
        }

        return inicioUrl + finalUrl;
    }

}
