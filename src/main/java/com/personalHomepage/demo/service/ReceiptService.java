package com.personalHomepage.demo.service;

import com.personalHomepage.demo.domain.Receipt;
import com.personalHomepage.demo.dto.ReceiptDTO;
import com.personalHomepage.demo.repository.ReceiptRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReceiptService {
    private final ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public Receipt saveReceipt(ReceiptDTO receiptDTO) {
        Receipt receipt = convertToEntity(receiptDTO);
//        System.out.println("Receipt receipt = convertToEntity(receiptDTO)");
//        System.out.println(receipt);
            return receiptRepository.save(receipt);
    }

    public Receipt convertToEntity(ReceiptDTO receiptDTO) {
        Receipt receipt = new Receipt();
        receipt.setImage(receiptDTO.getImage());
        receipt.setTeam_id(receiptDTO.getTeam_id());
        receipt.setJson_data(receiptDTO.getJson_data());

        return receipt;
    }

}
