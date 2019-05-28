package pl.sda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

@AllArgsConstructor

public class Shop {

    private String name;
    private String address;
    private String phoneNumber;
    private String mail;
    private String nip;
    private Company company;


}
