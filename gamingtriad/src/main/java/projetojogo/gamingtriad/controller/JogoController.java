package projetojogo.gamingtriad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetojogo.gamingtriad.domain.Jogo;
import projetojogo.gamingtriad.requests.JogoPostRequestBody;
import projetojogo.gamingtriad.requests.JogoPutRequestBody;
import projetojogo.gamingtriad.service.JogoService;
import projetojogo.gamingtriad.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("jogos")
@Log4j2
@RequiredArgsConstructor
public class JogoController {
    private final DateUtil dateUtil;
    private final JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<Jogo>> list(){
        log.info(DateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(jogoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable long id){
        return ResponseEntity.ok(jogoService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Jogo>> findByName(@RequestParam String name){
        return ResponseEntity.ok(jogoService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Jogo> save(@RequestBody @Valid JogoPostRequestBody jogoPostRequestBody){
        return new ResponseEntity<>(jogoService.save(jogoPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        jogoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody JogoPutRequestBody jogoPutRequestBody){
        jogoService.replace(jogoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
