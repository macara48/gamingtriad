package projetojogo.gamingtriad.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import projetojogo.gamingtriad.domain.Jogo;
import projetojogo.gamingtriad.requests.JogoPostRequestBody;
import projetojogo.gamingtriad.requests.JogoPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class JogoMapper {
    public static final JogoMapper INSTANCE = Mappers.getMapper(JogoMapper.class);

    public abstract Jogo toJogo(JogoPostRequestBody jogoPostRequestBody);

    public abstract Jogo toJogo(JogoPutRequestBody jogoPutRequestBody);
}
