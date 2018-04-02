package dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PayerDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String email;

}
