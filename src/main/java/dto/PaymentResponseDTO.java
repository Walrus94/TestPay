package dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class PaymentResponseDTO {

    private Long id;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private String date;

}
