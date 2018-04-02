package controller;

import dto.PaymentDTO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.PaymentsService;

@RestController
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @RequestMapping(value = "/payments/payment", method = RequestMethod.POST,
        produces = "application/json")
    public void createPayment(@RequestBody @Valid PaymentDTO paymentDTO) {
        paymentsService.createPayment(paymentDTO);
    }


}
