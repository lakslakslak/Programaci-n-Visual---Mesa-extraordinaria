package ar.edu.unju.fi;

import ar.edu.unju.fi.model.Comida.Categoria;
import ar.edu.unju.fi.dto.ComidaDTO;
import ar.edu.unju.fi.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ComidaService comidaService;

    @Override
    public void run(String... args) throws Exception {
        // Inicializar algunas comidas de ejemplo
        ComidaDTO comida1 = new ComidaDTO(null, "Ensalada César", "Ensalada con pollo y aderezo César", Categoria.ENTRADA, 12.50, null, true, null);
        ComidaDTO comida2 = new ComidaDTO(null, "Lomo Saltado", "Plato típico peruano con carne y papas fritas", Categoria.PLATO_PRINCIPAL, 25.00, null, true, null);
        ComidaDTO comida3 = new ComidaDTO(null, "Tiramisú", "Postre italiano con mascarpone y café", Categoria.POSTRE, 8.00, null, true, null);

        comidaService.createComida(comida1);
        comidaService.createComida(comida2);
        comidaService.createComida(comida3);
    }
}
