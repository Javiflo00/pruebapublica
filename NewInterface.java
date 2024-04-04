/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroaleatorioventana2;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public interface NewInterface extends ActionListener {

    void actionPerformed(ActionEvent e);

    void altaDepartamento(final String existeDepartamento);

    void borrarDepartamento(final String existeDepartamento) throws HeadlessException;

    void cerrar();

    int consultaDepartamento(final String existeDepartamento, String param2);

    void limpiarDatos();

    void verDatos();

    void verporconsola() throws IOException;
    
}
