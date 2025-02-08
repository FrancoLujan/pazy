package com.example.APiGateway.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {

    @Bean
    public RouteLocator rutas(RouteLocatorBuilder builder,
                              @Value("${api-gateway.url-microservicio-Profesores}") String uriProfesro,
                              @Value("${api-gateway.url-microservicio-Usuarios}") String uriUsuario,
                              @Value("${api-gateway.url-microservicio-GestorPagos}") String uriGestor) {
    return builder.routes()
            .route(serv -> serv.path("/api/profesor").uri(uriProfesro))
            .route(serv -> serv.path("/api/usuario").uri(uriUsuario))
            .route(serv -> serv.path("/api/gestorPagos").uri(uriGestor)).build() ;
    }
}
