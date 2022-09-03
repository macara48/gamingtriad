package projetojogo.gamingtriad.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class JogoPostRequestBody {
    @NotEmpty(message = "The game name cannot be empty!")
    @NotNull(message = "The game name cannot be null!")
    private String name;
}
