import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class Principal {

    private JFrame frame;
    private Sesion historial;
    private Jugar partida;
    private Jugador j1, j2;
    private JMenu jugar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Principal window = new Principal();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Principal() {
        initialize();
    }

    private void initialize() {
    	//indicara cuando ya se realizo cierta accion que debe de tener una consecuencia
        Listener listener = new Listener();
        
        //titulo de la ventana y dimensiones
        frame = new JFrame("Juego de Memoria");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //esto indica las opciones que hay en el menu
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Menú Sesión
        JMenu newsesion = new JMenu("Nueva sesión");
        menuBar.add(newsesion);
        JMenuItem menuNewSesion = new JMenuItem("Crear nueva sesión");
        // se manda a crear una nueva sesion
        menuNewSesion.addActionListener(listener);
        newsesion.add(menuNewSesion);

        // Menú Jugadores
        JMenu jugadores = new JMenu("Crear jugadores");
        menuBar.add(jugadores);
        JMenuItem menuNewJugadores = new JMenuItem("Crear jugadores para esta sesión");
        //se crean a los jugadores de la sesion
        menuNewJugadores.addActionListener(listener);
        jugadores.add(menuNewJugadores);

        // Menú Jugar
        jugar = new JMenu("Jugar");
        menuBar.add(jugar);
        JMenuItem menuNewJuego = new JMenuItem("Empezar juego nuevo");
        //manda a iniciar la logica del juego
        menuNewJuego.addActionListener(listener);
        jugar.add(menuNewJuego);

        // Menú Reporte
        JMenu reporte = new JMenu("Reporte");
        menuBar.add(reporte);
        JMenuItem menuReporte = new JMenuItem("Mostrar reporte");
        //muestra el reporte de la sesion
        menuReporte.addActionListener(listener);
        reporte.add(menuReporte);
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            //se verifica que accion fue la que activo el listener y se realiza su accion determinada
            switch (comando) {
                case "Crear nueva sesión":
                	//se crea la nueva sesion
                    historial = new Sesion();
                    j1 = null;
                    j2 = null;
                    partida = null;
                    JOptionPane.showMessageDialog(frame, "Nueva sesión creada");
                    break;

                case "Crear jugadores para esta sesión":
                	//se verifica si ya se creo la sesion o no
                    if (historial == null) {
                        JOptionPane.showMessageDialog(frame, "Primero debes crear una sesión");
                        return;
                    }
                    //en caso de que si se haya creado
                    String nombre1 = JOptionPane.showInputDialog(frame, "Nombre jugador 1:");
                    String nombre2 = JOptionPane.showInputDialog(frame, "Nombre jugador 2:");
                    //validacion por si ingresan algo incorrecto
                    if (nombre1 == null || nombre2 == null || nombre1.isEmpty() || nombre2.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Nombres inválidos");
                        return;
                    }
                    j1 = new Jugador();
                    j1.setNombre(nombre1);
                    j2 = new Jugador();
                    j2.setNombre(nombre2);
                    JOptionPane.showMessageDialog(frame, "Jugadores creados: " + nombre1 + " y " + nombre2);
                    break;
                  
                case "Empezar juego nuevo":
                	//validacion para ver si ya se inicio sesion y los jugadores ya estan creados
                    if (historial == null || j1 == null || j2 == null) {
                        JOptionPane.showMessageDialog(frame, "Primero crea sesión y jugadores");
                        return;
                    }
                    //creacion del tablero con los valores pares ingresados por el usuario
                    try {
                        int filas = Integer.parseInt(JOptionPane.showInputDialog(frame, "Número de filas (par):"));
                        int columnas = Integer.parseInt(JOptionPane.showInputDialog(frame, "Número de columnas (par):"));

                        if (filas % 2 != 0 || columnas % 2 != 0) {
                            JOptionPane.showMessageDialog(frame, "Filas y columnas deben ser pares");
                            return;
                        }
                        //se crean las especificaciones para empezar a jugar
                        partida = new Jugar();
                        partida.setJugador(j1);
                        partida.setOponente(j2);
                        partida.setTablero(filas, columnas);

                        //// se muestra el tablero////
                        //creacion de la ventana en la que estara el tablero
                        Ficha[][] tablero = partida.getTablero();
                        JFrame tableroFrame = new JFrame("Tablero");
                        tableroFrame.setSize(600, 600);
                        tableroFrame.getContentPane().setLayout(new BorderLayout());
                        JPanel panelGrid = new JPanel(new GridLayout(tablero.length, tablero[0].length));
                        //se hace la matriz con botones
                        JButton[][] botones = new JButton[tablero.length][tablero[0].length];
                        //se recorre la matriz de botones con la informacion del tablero
                        for (int f = 0; f < tablero.length; f++) {
                            for (int c = 0; c < tablero[0].length; c++) {
                            	//se toma la ficha del tablero
                            	Ficha ficha = tablero[f][c];
                            	//es cuando inicia volteada
                            	ficha.setImagen(0, false);
                                JButton btn = new JButton(ficha.getImagen());
                                //se crea el listener de los botones
                                btn.addActionListener(apachado -> {
                                	//primero se valida
                                });
                                //solo hace la imagen/texto mas grande
                                btn.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
                                botones[f][c] = btn;
                                panelGrid.add(btn);
                                
                                
                                
                            }
                        }
                        //se crea el "guia" de turnos
                        JLabel lblInfo = new JLabel("Turno: " + partida.getTurnoActual().getNombre());
                        tableroFrame.getContentPane().add(lblInfo, BorderLayout.SOUTH);
                        //se habilita
                        tableroFrame.getContentPane().add(panelGrid, BorderLayout.CENTER);
                        tableroFrame.setVisible(true);

                    } 
                    catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Ingrese un número válido");
                    }
                    break;

                case "Mostrar reporte":
                	//se revisa si ya hay una sesion creada
                    if (historial == null || historial.getSesiones().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "No hay partidas para mostrar");
                        return;
                    }
                    //muestra el historial de las sesiones
                    StringBuilder sb = new StringBuilder();
                    for (String s : historial.getSesiones()) {
                        sb.append(s).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(frame, sb.toString(), "Historial de Sesiones", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }

        
    }
}

