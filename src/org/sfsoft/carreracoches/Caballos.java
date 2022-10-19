package src.org.sfsoft.carreracoches;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.SwingWorker;



public class Caballos extends SwingWorker<Void, Integer> {
    private int velocidad;
    private int distanciaCarrera;
    private int distanciaRecorrida;
    private JLabel marcador;
    private String nombre;

    public Caballos(int i, int distancia, JLabel lbMarcador, String nombre) {
        this.velocidad = velocidad;
        this.distanciaCarrera = distanciaCarrera;
        this.distanciaRecorrida = distanciaRecorrida;
        this.marcador = marcador;
        this.nombre = nombre;
    }

    public Caballos(int distanciaCarrera,
                    JLabel marcador, String nombre) {

        this.velocidad = new Random().nextInt(30) + 5;
        this.distanciaCarrera = distanciaCarrera;
        distanciaRecorrida = 0;
        this.marcador = marcador;
        this.nombre = nombre;
    }

    protected Void doInBackground() throws Exception {

        while (distanciaRecorrida < distanciaCarrera) {
            Thread.sleep(100);
            distanciaRecorrida += velocidad;
            if (distanciaRecorrida > distanciaCarrera)
                distanciaRecorrida = distanciaCarrera;

            setProgress(distanciaRecorrida * 100 /
                    distanciaCarrera);

			/*if (isCancelled())
				return null;*/
        }

        marcador.setText(nombre + ": He ganado");
        firePropertyChange("ganador", "", nombre);

        return null;
    }



}
