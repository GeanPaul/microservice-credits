package com.nttdata.app.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "credit")
//Clase que representa a mi entidad crédito
public class Credit {

    //Atributo de numero de registro del crédito
    @Id
    private String idCredit;
    //Atributo de tipo de crédito
    private String typeCredit;
    //Atributo del número interno del banco del crédito
    private String numberCredit;
    //Atributo del monto del crédito
    private double creditAmount;
    //Atributo de saldo disponible
    private double availableBalance;
    //Atributo del id del usuario que tiene el crédito
    private String idCustomer;

}
