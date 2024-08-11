package com.example.zegel.devices.negocio;

import com.example.zegel.devices.repositorio.DispositivoRepositorio;
import com.example.zegel.devices.entidades.Dispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoNegocio {

    @Autowired
    private DispositivoRepositorio dispositivoRepositorio;

    public Dispositivo grabar(Dispositivo dispositivo) {
        return dispositivoRepositorio.save(dispositivo);
    }

    public List<Dispositivo> obtenerDispositivos() {
        return (List<Dispositivo>) dispositivoRepositorio.findAll();
    }

    public Dispositivo actualizar(Dispositivo dispositivo) {
        Dispositivo c = dispositivoRepositorio.findById(dispositivo.getIdClaim()).get();
        if (c != null) {
            return dispositivoRepositorio.save(dispositivo);
        } else {
            return null;
        }
    }

    public Dispositivo borrarDispositivo(Long idClaim) {
        Dispositivo c = dispositivoRepositorio.findById(idClaim).get();
        if (c != null) {
            dispositivoRepositorio.delete(c);
        } else {
            return null;
        }
        return c;
    }
}
