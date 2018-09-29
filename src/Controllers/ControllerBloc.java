
package Controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.ModelBloc;
import Views.ViewBloc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ControllerBloc implements ActionListener  {
    
    private ModelBloc modelBloc;
     private ViewBloc viewBloc;

    public ControllerBloc(ModelBloc modelBloc, ViewBloc viewBloc) {
        this.modelBloc = modelBloc;
        this.viewBloc = viewBloc;
        this.viewBloc.jM_leer.addActionListener(this);
       this.viewBloc.jM_guardar.addActionListener(this);
       
       
       initComponents();
    }
    public void iniciar_vista(){
        viewBloc.setLocationRelativeTo(null);
    }
      @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==viewBloc.jM_leer){
                    jM_leer_action_performed();
               
            }
            if(e.getSource()==viewBloc.jM_guardar){
                    jM_guardar_action_performed();
            }
    }
    
    private void jM_leer_action_performed(){
        this.readFile(modelBloc.getPath()); 
    }
    
     private void jM_guardar_action_performed(){
        modelBloc.setMensaje(viewBloc.jta_escribir.getText()); 
        this.writeFile(modelBloc.getPath(), modelBloc.getMensaje()); 
    }
     
     
     public String readFile (String path) {
        try {
            String row; 
            try (FileReader archivo = new FileReader(path)) { 
                BufferedReader bufferedreader = new BufferedReader(archivo);
                while ((row = bufferedreader.readLine()) != null ) {
                    viewBloc.jta_escribir.setText(row);
                }
            }
        }
        catch (FileNotFoundException err) { // muestra error si el archivo no fue encontrado
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { // nestra error si el archivo no puede ser leeido 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
        return null;
    };
    
   
    public void writeFile (String path, String message) {
        try {
            File archivo = new File(path); // abre archivos o crea uno nuevo
            FileWriter filewriter = new FileWriter(archivo, false);
            
            try (PrintWriter printwriter = new PrintWriter(filewriter) ) {
                printwriter.println(message);
                printwriter.close();
            }
        }
        //busca errores 
        catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());//se acciona si el archivo no fue hallado 
        }
        catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }
    public void initComponents() {
        viewBloc.setVisible(true);
    }
    
    
}
