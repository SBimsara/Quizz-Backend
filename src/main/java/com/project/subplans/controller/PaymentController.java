

package com.project.subplans.controller;


import com.project.subplans.dto.PaymentRequestDTO;
import com.project.subplans.dto.PaymentResponseDTO;
import com.project.subplans.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/payment")
@CrossOrigin(origins="http://10.10.19.51:19000")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponseDTO> initiatePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentResponseDTO responseDTO = paymentService.initiatePayment(paymentRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
