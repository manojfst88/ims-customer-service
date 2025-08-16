package com.ims.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;
    private String customerName;
    private String email;
    private String mobileNumber;
    private String billingAddress;
}
