package projetojogo.gamingtriad.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetojogo.gamingtriad.domain.Jogo;
import projetojogo.gamingtriad.exceptions.BadRequestException;
import projetojogo.gamingtriad.mapper.JogoMapper;
import projetojogo.gamingtriad.repository.JogoRepository;
import projetojogo.gamingtriad.requests.JogoPostRequestBody;
import projetojogo.gamingtriad.requests.JogoPutRequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogoService {

    private final JogoRepository jogoRepository;
    public List<Jogo> listAll(){
        return jogoRepository.findAll();
    }

    public List<Jogo> findByName(String name) {
        return jogoRepository.findByName(name);
    }

    public Jogo findByIdOrThrowBadRequestException(long id){
        return jogoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Jogo not Found"));
    }

    @Transactional
    public Jogo save(JogoPostRequestBody jogoPostRequestBody){
        return jogoRepository.save(JogoMapper.INSTANCE.toJogo(jogoPostRequestBody));
    }

    public void delete(long id){
        jogoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(JogoPutRequestBody jogoPutRequestBody){
        Jogo savedJogo = findByIdOrThrowBadRequestException(jogoPutRequestBody.getId());
        Jogo jogo = JogoMapper.INSTANCE.toJogo(jogoPutRequestBody);
        jogo.setId(savedJogo.getId());
        jogoRepository.save(jogo);
    }
}
