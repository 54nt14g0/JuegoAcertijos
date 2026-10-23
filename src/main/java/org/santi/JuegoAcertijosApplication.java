package org.santi;

import org.santi.Entity.Acertijo;
import org.santi.Entity.Juego;
import org.santi.Entity.Nivel;
import org.santi.Entity.Usuario;
import org.santi.Repository.JuegoRepository;
import org.santi.Services.AuthService;
import org.santi.Services.JuegoService;
import org.santi.Services.NivelService;
import org.santi.Services.UsuarioService;
import org.santi.Services.impl.JuegoServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JuegoAcertijosApplication {


    public static void main(String[] args) {
        SpringApplication.run(JuegoAcertijosApplication.class, args);




    }

    @Bean
    CommandLineRunner ejecutar(JuegoService juegoService, UsuarioService usuarioService, AuthService authService, NivelService nivelService) {
        return args -> {
            Juego juego = juegoService.obtenerJuego(1L);
            Scanner sc = new Scanner(System.in);

            List<Nivel> niveles = juego.getNiveles();


            System.out.println("Ingrese su email");
            String email = sc.nextLine();
            System.out.println("Ingrese su contraseña");
            String pass = sc.nextLine();
            Usuario usuario = authService.login(email, pass);


            System.out.println("Bienvenido al juego");

            System.out.println("Estos son los niveles, escoja cual jugar");

            for  (int i = 0; i<niveles.size(); i++){
                System.out.println(i+ "  " + niveles.get(i).getNombre());
            }

            Long res = sc.nextLong();

            Nivel nivel = juegoService.obtenerNivelById(res);
            List <Acertijo> listaAcertijos = usuarioService.jugarNivel(usuario.getId(), res);

            System.out.println("Bien, comenzará el nivel");
            System.out.println("Estos son los acertijos del nivel");

            for (int i = 0 ; i<listaAcertijos.size(); i++){



            }










        };
    }




}
