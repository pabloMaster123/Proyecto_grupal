package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServicioImpl implements AdministardorServicio {

    @Autowired
    private AdministradorRepo administradorRepo;


    @Override
    public Administrador login(String email, String pasword) throws Exception {
        return  administradorRepo.findByEmailAndAndPassword(email,pasword).orElseThrow(() -> new Exception("Datos Incorrectos"));
    }

}
