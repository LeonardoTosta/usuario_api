package com.usuario.Test;

import com.usuario.modificadorEstatico.Carro;
import org.junit.jupiter.api.Test;

public class CarroTest {

    @Test
    public void executaCarros(){
        Carro carro1 =  new Carro("BMW", 280);
        Carro carro2 =  new Carro("Mercedes", 275);
        Carro carro3 =  new Carro("Pajero", 290);

        Carro.velocidadeLimite = 180;

        carro1.imprime();
        carro2.imprime();
        carro3.imprime();

    }
}
