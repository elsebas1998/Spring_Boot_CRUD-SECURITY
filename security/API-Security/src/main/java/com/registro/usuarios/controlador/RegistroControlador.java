package com.registro.usuarios.controlador;


import com.registro.usuarios.reportes.UsuarioExporterPDF;
import com.registro.usuarios.repositorio.UsuarioRepositorio;
import com.registro.usuarios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.modelo.Usuario;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "/login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            modelo.addAttribute("usuarios", servicio.listarUsuarios());
            return "index";
        }
        else {
            modelo.addAttribute("usuarios", servicio.listarUsuarios());
            return "index";
        }
    }
    @GetMapping("/exportarPDF1")
    public void generarPDF(HttpServletResponse response) throws Exception {
        response.setContentType("aplication/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Usuarios_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        UsuarioExporterPDF exporter = new UsuarioExporterPDF(usuarios);
        exporter.exportar(response);
    }
}
