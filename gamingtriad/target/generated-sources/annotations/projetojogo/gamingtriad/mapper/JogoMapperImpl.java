package projetojogo.gamingtriad.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import projetojogo.gamingtriad.domain.Jogo;
import projetojogo.gamingtriad.requests.JogoPostRequestBody;
import projetojogo.gamingtriad.requests.JogoPutRequestBody;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-01T11:55:42-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class JogoMapperImpl extends JogoMapper {

    @Override
    public Jogo toJogo(JogoPostRequestBody jogoPostRequestBody) {
        if ( jogoPostRequestBody == null ) {
            return null;
        }

        Jogo jogo = new Jogo();

        return jogo;
    }

    @Override
    public Jogo toJogo(JogoPutRequestBody jogoPutRequestBody) {
        if ( jogoPutRequestBody == null ) {
            return null;
        }

        Jogo jogo = new Jogo();

        return jogo;
    }
}
