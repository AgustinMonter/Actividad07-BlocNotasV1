
package main;

import Controllers.ControllerBloc;
import Models.ModelBloc;
import Views.ViewBloc;

public class Main {

        public static void main(String[] args) {
            ModelBloc modelbloc = new ModelBloc();
            ViewBloc viewbloc = new ViewBloc();
            ControllerBloc ontrollerblocnotas = new ControllerBloc(modelbloc, viewbloc); 
    }
    
}
