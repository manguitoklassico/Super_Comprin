/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DATOS.ClientesDAO;
import DATOS.EWalletDAO;
import DATOS.ProductoDAO;
import DOMINIO.Clientes;
import DOMINIO.EWallet;
import DOMINIO.Producto;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author alexg
 */
public class INTERFAZ extends JFrame {

    //Variables Comunes
    private JButton Volver, Volver2, Volver3, Volver4, Volver5, Volver6, Volver7, Volver8, Volver9, Volver10, Volver11, Volver12,Volver13, Volver14, Volver15, Volver16, Volver17;
    private JLabel Contraseña;
    private int ControlErrores;
    //Fin Variables Comunes

    //Variables RegistrarsePanel
    private JLabel FechaNacimiento, Nombre, Apellidos, DNI, Email;
    private JTextField TF1, TF2, TF3, TF4, TF5, TF6;
    private JButton button;
    private JPanel RegistrarsePanel = new JPanel();
    //fin Variables RegistrarsePanel

    //Variables MenuPrincipal
    private JPanel MenuPrincipal = new JPanel();
    private JButton Registrarse, iniciarSesion;
    private JLabel SuperComprin;
    //Fin Variables MenuPrincipal

    //Variables MenuCliente 
    private JPanel MenuCliente = new JPanel();
    private JButton Tienda, VerEWallet, Devolver;
    //Fin Variables MenuCliente

    //Variables IniciarSesionPanel
    private JPanel IniciarSesionPanel = new JPanel();
    private JLabel DNI2;
    private JTextField TF7, TF8;
    private JButton button2;
    //Fin Variables IniciarSesionPanel

    //Variables TiendaPanel
    private JPanel TiendaPanel = new JPanel();
    private JButton ComprarConDinero, ComprarConPuntos;
    private final JList Articulos;
    private JLabel Cantidad;
    private JTextField TF9;
    //Fin Variables TiendaPanel

    //Variables MenuE-Wallet
    private JPanel MenuCartera = new JPanel();
    private JButton VerDinero, VerPuntos, Recargar;
    //Fin Variables MenuE-Wallet   

    //Variables SaldoPanel
    private JPanel SaldoPanel = new JPanel();
    private JLabel Dinero2;
    //Fin Variables SaldoPanel

    //Variables PuntosPanel
    private JPanel PuntosPanel = new JPanel();
    private JLabel Puntos2;
    //Fin Variables PuntosPanel
    
    //Variables RecargarPanel
    private JPanel RecargarPanel = new JPanel();
    private JLabel AñadeDinero;
    private JTextField TF10;
    private JButton ConfirmarRecarga;
    //Fin Variables RecargarPanel
    
    //Variables DevolverPanel
    private JPanel DevolverPanel= new JPanel();
    private JButton DevolverEnDinero, DevolverEnPuntos;
    private final JList Articulos2;
    private JLabel Cantidad2;
    private JTextField TF11;
    //Fin Variables DevolverPanel
    
    //Variables errorPanel1
    private JPanel ErrorPanel1 = new JPanel();
    private JLabel Error;
    //Fin Variables errorPanel1

    //Variables errorPanel2
    private JPanel ErrorPanel2 = new JPanel();
    private JLabel Error2;
    //Fin Variables errorPanel2
        
    //Variables errorPanel3
    private JPanel ErrorPanel3 = new JPanel();
    private JLabel Error3;
    //Fin Variables errorPanel3

    //Variables errorPanel4
    private JPanel ErrorPanel4 = new JPanel();
    private JLabel Error4;
    //Fin Variables errorPanel4
    
    //Variables errorPanel5
    private JPanel ErrorPanel5 = new JPanel();
    private JLabel Error5;
    //Fin Variables errorPanel5

    //Variables errorPanel6
    private JPanel ErrorPanel6 = new JPanel();
    private JLabel Error6;
    //Fin Variables errorPanel6
        
    //Variables errorPanel7
    private JPanel ErrorPanel7 = new JPanel();
    private JLabel Error7;
    //Fin Variables errorPanel7

    //Variables errorPanel8
    private JPanel ErrorPanel8 = new JPanel();
    private JLabel Error8;
    //Fin Variables errorPanel8

    public INTERFAZ() {

        setSize(400, 400);
        setTitle("SuperComprin");

        //MenuPrincipal
        MenuPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints d = new GridBagConstraints();

        SuperComprin = new JLabel("SuperComprin");
        SuperComprin.setFont(new Font("Arial", Font.BOLD, 30));
        d.gridx = 0;
        d.gridy = 0;
        d.gridwidth = 3;
        d.insets = new Insets(0, 0, 50, 0);
        MenuPrincipal.add(SuperComprin, d);

        Registrarse = new JButton("Registrarse");
        d.gridx = 1;
        d.gridy = 1;
        d.gridwidth = 1;
        d.insets = new Insets(0, 50, 0, 0);
        Registrarse.addActionListener(new MenuButtonListener());
        MenuPrincipal.add(Registrarse, d);

        iniciarSesion = new JButton("Iniciar Sesion");
        d.gridx = 1;
        d.gridy = 2;
        d.gridwidth = 1;
        iniciarSesion.addActionListener(new MenuButtonListener());
        MenuPrincipal.add(iniciarSesion, d);

        add(MenuPrincipal);
        //Fin MenuPrincipal

        //MenuCliente
        MenuCliente.setLayout(new GridBagLayout());
        GridBagConstraints f = new GridBagConstraints();

        Tienda = new JButton("Tienda");
        f.gridx = 0;
        f.gridy = 0;
        Tienda.addActionListener(new MenuButtonListener());
        MenuCliente.add(Tienda, f);

        VerEWallet = new JButton("Ver E-Wallet");
        f.gridx = 0;
        f.gridy = 1;
        VerEWallet.addActionListener(new MenuButtonListener());
        MenuCliente.add(VerEWallet, f);

        Devolver = new JButton("Devolver");
        f.gridx = 0;
        f.gridy = 2;
        Devolver.addActionListener(new MenuButtonListener());
        MenuCliente.add(Devolver, f);

        Volver3 = new JButton("Volver");
        f.gridx = 0;
        f.gridy = 3;
        Volver3.addActionListener(new VolverButtonListener());
        MenuCliente.add(Volver3, f);
        //Fin MenuCliente

        //RegistrarsePanel
        RegistrarsePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        FechaNacimiento = new JLabel("Fecha de Nacimiento");
        c.gridx = 0;
        c.gridy = 4;
        RegistrarsePanel.add(FechaNacimiento, c);

        TF1 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 0;
        RegistrarsePanel.add(TF1, c);

        Nombre = new JLabel("Nombre");
        c.gridx = 0;
        c.gridy = 0;
        RegistrarsePanel.add(Nombre, c);

        TF2 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 1;
        RegistrarsePanel.add(TF2, c);

        Apellidos = new JLabel("Apellidos");
        c.gridx = 0;
        c.gridy = 1;
        RegistrarsePanel.add(Apellidos, c);

        TF3 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 2;
        RegistrarsePanel.add(TF3, c);

        DNI = new JLabel("DNI");
        c.gridx = 0;
        c.gridy = 2;
        RegistrarsePanel.add(DNI, c);

        TF4 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 3;
        RegistrarsePanel.add(TF4, c);

        Email = new JLabel("Email");
        c.gridx = 0;
        c.gridy = 3;
        RegistrarsePanel.add(Email, c);

        TF5 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 4;
        RegistrarsePanel.add(TF5, c);

        Contraseña = new JLabel("Contraseña");
        c.gridx = 0;
        c.gridy = 5;
        RegistrarsePanel.add(Contraseña, c);

        TF6 = new JTextField(10);
        c.gridx = 1;
        c.gridy = 5;
        RegistrarsePanel.add(TF6, c);

        button = new JButton("Registrarse");
        c.gridx = 0;
        c.gridy = 6;
        button.addActionListener(new MenuButtonListener());
        RegistrarsePanel.add(button, c);

        Volver = new JButton("Volver");
        c.gridx = 1;
        c.gridy = 6;
        Volver.addActionListener(new VolverButtonListener());
        RegistrarsePanel.add(Volver, c);
        //Fin RegistrarsePanel

        //IniciarSesionPanel
        IniciarSesionPanel.setLayout(new GridBagLayout());
        GridBagConstraints e = new GridBagConstraints();

        DNI2 = new JLabel("DNI");
        e.gridx = 0;
        e.gridy = 0;
        IniciarSesionPanel.add(DNI2, e);

        TF7 = new JTextField(10);
        e.gridx = 1;
        e.gridy = 0;
        IniciarSesionPanel.add(TF7, e);

        Contraseña = new JLabel("Contraseña");
        e.gridx = 0;
        e.gridy = 1;
        IniciarSesionPanel.add(Contraseña, e);

        TF8 = new JTextField(10);
        e.gridx = 1;
        e.gridy = 1;
        IniciarSesionPanel.add(TF8, e);

        button2 = new JButton("Iniciar Sesion");
        e.gridx = 0;
        e.gridy = 2;
        button2.addActionListener(new MenuButtonListener());
        IniciarSesionPanel.add(button2, e);

        Volver2 = new JButton("Volver");
        e.gridx = 1;
        e.gridy = 2;
        Volver2.addActionListener(new VolverButtonListener());
        IniciarSesionPanel.add(Volver2, e);
        //Fin IniciarsesionPanel

        //TiendaPanel
        TiendaPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        ProductoDAO productoDAO = new ProductoDAO();
        Articulos = new JList(productoDAO.ListaProductos());
        JScrollPane jsp = new JScrollPane(Articulos);
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 4;
        TiendaPanel.add(jsp, g);
        
        ComprarConDinero = new JButton("Pagar con €");
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 2;
        ComprarConDinero.addActionListener(new MenuButtonListener());
        TiendaPanel.add(ComprarConDinero, g);

        ComprarConPuntos = new JButton("Pagar con p");
        g.gridx = 2;
        g.gridy = 1;
        g.gridwidth = 2;
        ComprarConPuntos.addActionListener(new MenuButtonListener());
        TiendaPanel.add(ComprarConPuntos, g);
        
        Cantidad= new JLabel("<html><body>Cantidad a <br>comprar</body></html>");
        g.gridx=0;
        g.gridy=2;
        g.gridwidth = 1;
        TiendaPanel.add(Cantidad,g);
        
        TF9 = new JTextField(10);
        g.gridx=1;
        g.gridy=2;
        g.gridwidth = 1;
        TiendaPanel.add(TF9,g);
        
        Volver4 = new JButton("Volver");
        g.gridx = 2;
        g.gridy = 2;
        g.gridwidth = 2;
        Volver4.addActionListener(new VolverButtonListener());
        TiendaPanel.add(Volver4, g);
        //Fin TiendaPanel

        //MenuE-Wallet
        MenuCartera.setLayout(new GridBagLayout());
        GridBagConstraints i = new GridBagConstraints();

        VerDinero = new JButton("Ver Saldo");
        i.gridx = 0;
        i.gridy = 0;
        VerDinero.addActionListener(new MenuButtonListener());
        MenuCartera.add(VerDinero, i);

        VerPuntos = new JButton("Ver Puntos");
        i.gridx = 0;
        i.gridy = 1;
        VerPuntos.addActionListener(new MenuButtonListener());
        MenuCartera.add(VerPuntos, i);

        Recargar = new JButton("Recargar");
        i.gridx = 0;
        i.gridy = 2;
        Recargar.addActionListener(new MenuButtonListener());
        MenuCartera.add(Recargar, i);

        Volver6 = new JButton("Volver");
        i.gridx = 0;
        i.gridy = 3;
        Volver6.addActionListener(new VolverButtonListener());
        MenuCartera.add(Volver6, i);
        //Fin MenuE-Wallet

        //SaldoPanel
        SaldoPanel.setLayout(new GridBagLayout());
        GridBagConstraints h = new GridBagConstraints();

        Dinero2 = new JLabel();
        Dinero2.setFont(new Font("Arial", Font.BOLD, 60));
        h.gridx = 0;
        h.gridy = 0;
        h.gridheight = 2;
        h.gridwidth = 2;
        SaldoPanel.add(Dinero2, h);

        Volver5 = new JButton("Volver");
        h.gridx = 0;
        h.gridy = 2;
        h.gridheight = 1;
        h.gridwidth = 1;
        Volver5.addActionListener(new VolverButtonListener());
        SaldoPanel.add(Volver5, h);
        //Fin SaldoPanel

        //PuntosPanel
        PuntosPanel.setLayout(new GridBagLayout());
        GridBagConstraints j = new GridBagConstraints();

        Puntos2 = new JLabel();
        Puntos2.setFont(new Font("Arial", Font.BOLD, 60));
        j.gridx = 0;
        j.gridy = 0;
        j.gridheight = 2;
        j.gridwidth = 2;
        PuntosPanel.add(Puntos2, j);

        Volver7 = new JButton("Volver");
        j.gridx = 0;
        j.gridy = 2;
        j.gridheight = 1;
        j.gridwidth = 1;
        Volver7.addActionListener(new VolverButtonListener());
        PuntosPanel.add(Volver7, j);
        //Fin PuntosPanel

        //Variables RecargarPanel
        RecargarPanel.setLayout(new GridBagLayout()); 
        GridBagConstraints m = new GridBagConstraints();
        
        AñadeDinero = new JLabel("Añade el dinero a recargar");
        m.gridx = 0;
        m.gridy = 0;
        RecargarPanel.add(AñadeDinero, m);
        
        TF10 = new  JTextField (10);
        m.gridx = 1;
        m.gridy = 0;
        RecargarPanel.add(TF10, m);
        
        ConfirmarRecarga = new JButton("Recargar");
        m.gridx = 0;
        m.gridy = 1;
        ConfirmarRecarga.addActionListener(new MenuButtonListener()); 
        RecargarPanel.add(ConfirmarRecarga, m);
        
        Volver11 = new JButton("Volver");
        m.gridx = 1;
        m.gridy = 1;
        Volver11.addActionListener(new VolverButtonListener());
        RecargarPanel.add(Volver11, m);
        //Fin Variables RecargarPanel
        
        //DevolverPanel
        DevolverPanel.setLayout(new GridBagLayout());
        GridBagConstraints p = new GridBagConstraints();
        ProductoDAO productoDAO2 = new ProductoDAO();
        Articulos2 = new JList(productoDAO2.ListaProductos2());
        JScrollPane jsp2 = new JScrollPane(Articulos2);
        p.gridx = 0;
        p.gridy = 0;
        p.gridwidth = 4;
        DevolverPanel.add(jsp2, p);
        
        DevolverEnDinero = new JButton("Devolver en €");
        p.gridx = 0;
        p.gridy = 1;
        p.gridwidth = 2;
        DevolverEnDinero.addActionListener(new MenuButtonListener());
        DevolverPanel.add(DevolverEnDinero, p);

        DevolverEnPuntos = new JButton("Devolver en p");
        p.gridx = 2;
        p.gridy = 1;
        p.gridwidth = 2;
        DevolverEnPuntos.addActionListener(new MenuButtonListener());
        DevolverPanel.add(DevolverEnPuntos, p);
        
        Cantidad2= new JLabel("<html><body>Cantidad a <br>devolver</body></html>");
        p.gridx=0;
        p.gridy=2;
        p.gridwidth = 1;
        DevolverPanel.add(Cantidad2,p);
        
        TF11 = new JTextField(10);
        p.gridx=1;
        p.gridy=2;
        p.gridwidth = 1;
        DevolverPanel.add(TF11,p);
        
        Volver8 = new JButton("Volver");
        p.gridx = 2;
        p.gridy = 2;
        p.gridwidth = 2;
        Volver8.addActionListener(new VolverButtonListener());
        DevolverPanel.add(Volver8, p);
        //Fin DevolverPanel
        
        //ErrorPanel1
        ErrorPanel1.setLayout(new BorderLayout());
        Error = new JLabel();
        Error.setText("Error1: El DNI Ya se encuentra Registrado");
        Error.setForeground(Color.red);
        ErrorPanel1.add(Error);

        Volver9 = new JButton("Aceptar");
        Volver9.addActionListener(new VolverButtonListener());
        ErrorPanel1.add(Volver9, BorderLayout.PAGE_END);
        //Fin ErrorPanel1

        //ErrorPanel2
        ErrorPanel2.setLayout(new BorderLayout());
        Error2 = new JLabel();
        Error2.setText("Error2: Se necesita tener +18Años");
        Error2.setForeground(Color.red);
        ErrorPanel2.add(Error2);

        Volver10 = new JButton("Aceptar");
        Volver10.addActionListener(new VolverButtonListener());
        ErrorPanel2.add(Volver10, BorderLayout.PAGE_END);
        //Fin ErrorPanel2
        
        //ErrorPanel3
        ErrorPanel3.setLayout(new BorderLayout());
        Error3= new JLabel();
        Error3.setText("Error3: Valor Introducido no valido");
        Error3.setForeground(Color.red);
        ErrorPanel3.add(Error3);

        Volver12 = new JButton("Aceptar");
        Volver12.addActionListener(new VolverButtonListener());
        ErrorPanel3.add(Volver12, BorderLayout.PAGE_END);
        //Fin ErrorPanel3
        
        //ErrorPanel4
        ErrorPanel4.setLayout(new BorderLayout());
        Error4 = new JLabel();
        Error4.setText("Error4: El DNI y la contraseña no coinciden");
        Error4.setForeground(Color.red);
        ErrorPanel4.add(Error4);

        Volver13 = new JButton("Aceptar");
        Volver13.addActionListener(new VolverButtonListener());
        ErrorPanel4.add(Volver13, BorderLayout.PAGE_END);
        //Fin ErrorPanel4
        
        //ErrorPanel5
        ErrorPanel5.setLayout(new BorderLayout());
        Error5 = new JLabel();
        Error5.setText("Error5: Producto no seleccionado");
        Error5.setForeground(Color.red);
        ErrorPanel5.add(Error5);

        Volver14 = new JButton("Aceptar");
        Volver14.addActionListener(new VolverButtonListener());
        ErrorPanel5.add(Volver14, BorderLayout.PAGE_END);
        //Fin ErrorPanel5
        
        //ErrorPanel6
        ErrorPanel6.setLayout(new BorderLayout());
        Error6 = new JLabel();
        Error6.setText("Error6: Cantidad introducida Inabastecible");
        Error6.setForeground(Color.red);
        ErrorPanel6.add(Error6);

        Volver15 = new JButton("Aceptar");
        Volver15.addActionListener(new VolverButtonListener());
        ErrorPanel6.add(Volver15, BorderLayout.PAGE_END);
        //Fin ErrorPanel6
        
        //ErrorPanel7
        ErrorPanel7.setLayout(new BorderLayout());
        Error7 = new JLabel();
        Error7.setText("Error7: Saldo Insuficiente");
        Error7.setForeground(Color.red);
        ErrorPanel7.add(Error7);

        Volver16 = new JButton("Aceptar");
        Volver16.addActionListener(new VolverButtonListener());
        ErrorPanel7.add(Volver16, BorderLayout.PAGE_END);
        //Fin ErrorPanel7
        
        //ErrorPanel8
        ErrorPanel8.setLayout(new BorderLayout());
        Error8 = new JLabel();
        Error8.setText("Error8: Puntos insuficientes");
        Error8.setForeground(Color.red);
        ErrorPanel8.add(Error8);

        Volver17 = new JButton("Aceptar");
        Volver17.addActionListener(new VolverButtonListener());
        ErrorPanel8.add(Volver17, BorderLayout.PAGE_END);
        //Fin ErrorPanel8
        
    }

    public class MenuButtonListener implements ActionListener {

        String Nombre;
        String Apellidos;
        String DNI;
        String Email;
        Date FechaDeNacimiento;
        String Contraseña;

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Registrarse) {
                add(RegistrarsePanel);
                RegistrarsePanel.setVisible(true);
                MenuPrincipal.setVisible(false);
            }
            if (e.getSource() == iniciarSesion) {
                add(IniciarSesionPanel);
                IniciarSesionPanel.setVisible(true);
                MenuPrincipal.setVisible(false);
            }
            if (e.getSource() == Tienda) {
                add(TiendaPanel);
                TiendaPanel.setVisible(true);
                MenuCliente.setVisible(false);
            }
            if (e.getSource() == VerEWallet) {
                add(MenuCartera);
                MenuCartera.setVisible(true);
                MenuCliente.setVisible(false);
            }
            if (e.getSource() == button) {
                
                    Nombre = TF1.getText();
                    Apellidos = TF2.getText();
                    DNI = TF3.getText();
                    Email = TF4.getText();
                    Date date1;
                    String fecha;
                    fecha = TF5.getText();

                    try{
                    date1 = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
                    java.util.Date utilDate = date1;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    final String stringDate = dateFormat.format(utilDate);
                    final java.sql.Date sqlDate = java.sql.Date.valueOf(stringDate);
                    FechaDeNacimiento = sqlDate;
                    Contraseña = TF6.getText();
                    ClientesDAO clienteDAO = new ClientesDAO();
                    Clientes NuevoCliente = new Clientes(Nombre, Apellidos, DNI, Email, FechaDeNacimiento, Contraseña);

                    EWalletDAO carteraDAO = new EWalletDAO();
                    EWallet NuevaCartera = new EWallet(DNI);
                    
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaNac = LocalDate.parse((CharSequence) fecha, fmt);
                    LocalDate ahora = LocalDate.now();
                    Period periodo = Period.between(fechaNac, ahora);
                    

                    if(Nombre.length()!=0 && Apellidos.length()!=0 && DNI.length()!=0 && Email.length()!=0 && FechaDeNacimiento.toString().length()!=0 && Contraseña.length()!=0){
                        
                        if(periodo.getYears() >= 18){
                            
                            if (clienteDAO.Registrarse(NuevoCliente) != 10) {
                                clienteDAO.Registrarse(NuevoCliente);
                                carteraDAO.CrearCartera(NuevaCartera);
                                add(IniciarSesionPanel);
                                IniciarSesionPanel.setVisible(true);
                                RegistrarsePanel.setVisible(false);
                        
                            } else {
                                add(ErrorPanel1);
                                ErrorPanel1.setVisible(true);
                                RegistrarsePanel.setVisible(false);
                                ControlErrores=1;
                            }
                        } else{
                            add(ErrorPanel2);
                            ErrorPanel2.setVisible(true);
                            RegistrarsePanel.setVisible(false);
                            ControlErrores=1;
                        }
                    } else{
                            add(ErrorPanel3);
                            ErrorPanel3.setVisible(true);
                            RegistrarsePanel.setVisible(false);
                            ControlErrores=1;
                    }
                } catch (ParseException ex) {
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true);
                    RegistrarsePanel.setVisible(false);
                    ControlErrores=1;
                }
            }
            if (e.getSource() == button2) {
                DNI = TF7.getText();
                Contraseña = TF8.getText();
                ClientesDAO clienteDAO2 = new ClientesDAO();
                Clientes NuevoCliente2 = new Clientes(DNI, Contraseña);
                EWalletDAO carteraDAO2 = new EWalletDAO();
                EWallet NuevaCartera2 = new EWallet(DNI);
                if(DNI.length()!=0 && Contraseña.length()!=0){
                    if (clienteDAO2.IniciarSesion(NuevoCliente2) != 40) {
                        add(MenuCliente);
                        MenuCliente.setVisible(true);
                        MenuPrincipal.setVisible(false);
                        IniciarSesionPanel.setVisible(false);
                        Puntos2.setText(carteraDAO2.VisualizarPuntos(NuevaCartera2));
                        Dinero2.setText(carteraDAO2.VisualizarSaldo(NuevaCartera2));
                    } else {
                        add(ErrorPanel4);
                        ErrorPanel4.setVisible(true);
                        IniciarSesionPanel.setVisible(false);
                        ControlErrores=2;
                    }
                }else{
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true);
                    IniciarSesionPanel.setVisible(false);
                    ControlErrores=2;
                }
            }
            if (e.getSource() == VerDinero) {
                add(SaldoPanel);
                DNI = TF7.getText();
                EWalletDAO carteraDAO2 = new EWalletDAO();
                EWallet NuevaCartera2 = new EWallet(DNI);
                Dinero2.setText(carteraDAO2.VisualizarSaldo(NuevaCartera2));
                SaldoPanel.setVisible(true);
                MenuCartera.setVisible(false);
            }
            if (e.getSource() == VerPuntos) {
                add(PuntosPanel);
                DNI = TF7.getText();
                EWalletDAO carteraDAO2 = new EWalletDAO();
                EWallet NuevaCartera2 = new EWallet(DNI);
                Puntos2.setText(carteraDAO2.VisualizarPuntos(NuevaCartera2));
                PuntosPanel.setVisible(true);
                MenuCartera.setVisible(false);
            }
            if (e.getSource() == VerEWallet) {
                add(MenuCartera);
                MenuCartera.setVisible(true);
                MenuCliente.setVisible(false);
            }
            if (e.getSource() == Devolver) {
                add(DevolverPanel);
                DevolverPanel.setVisible(true);
                MenuCliente.setVisible(false);
            }
            if (e.getSource() == Recargar) {
                add(RecargarPanel);
                RecargarPanel.setVisible(true);
                MenuCartera.setVisible(false);
            }
            if (e.getSource() == ComprarConDinero) {
                try {
                DNI=TF7.getText();
                ProductoDAO productoDAO = new ProductoDAO();
                int ID = Articulos.getSelectedIndex()+1;
                int Stock2=0;
                if(TF9.getText().length()!=0){
                    Stock2 = Integer.parseInt(TF9.getText());
                }else{
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true); 
                    TiendaPanel.setVisible(false); 
                    ControlErrores=3; 
                }
                EWallet NuevaCartera3 = new EWallet(DNI);
                Producto producto = new Producto(Stock2, ID);
                
                    if(TF9.getText().length()!=0){
                        if(Articulos.isSelectionEmpty()==false){
                            if(productoDAO.Comprobar(producto)!=60){
                                EWallet NuevaCartera4 = new EWallet(DNI);
                                if(productoDAO.Comprar(producto,NuevaCartera4)!=70){
                                  
                                }else{
                                    add(ErrorPanel7);
                                    ErrorPanel7.setVisible(true); 
                                    TiendaPanel.setVisible(false); 
                                    ControlErrores=3;
                                }
                            }else{
                                add(ErrorPanel6);
                                ErrorPanel6.setVisible(true); 
                                TiendaPanel.setVisible(false); 
                                ControlErrores=3;
                            } 
                        
                        }else {
                            add(ErrorPanel5);
                            ErrorPanel5.setVisible(true); 
                            TiendaPanel.setVisible(false); 
                            ControlErrores=3;
                        }
                    }else{
                        add(ErrorPanel3);
                        ErrorPanel3.setVisible(true); 
                        TiendaPanel.setVisible(false); 
                        ControlErrores=3;       
                      }
                } catch (SQLException ex) {
                    Logger.getLogger(INTERFAZ.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == ComprarConPuntos) {
                try {
                DNI=TF7.getText();
                int ID = Articulos.getSelectedIndex()+1;
                int Stock2=0;
                if(TF9.getText().length()!=0){
                    Stock2 = Integer.parseInt(TF9.getText());
                }else{
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true); 
                    TiendaPanel.setVisible(false); 
                    ControlErrores=4; 
                }
                EWallet NuevaCartera3 = new EWallet(DNI);
                ProductoDAO productoDAO = new ProductoDAO();
                Producto producto = new Producto(Stock2, ID);
                
                    if(TF9.getText().length()!=0){
                        if(Articulos.isSelectionEmpty()==false){
                            if(productoDAO.Comprobar(producto)!=60){
                                EWallet NuevaCartera4 = new EWallet(DNI);
                                if(productoDAO.ComprarConPuntos(producto,NuevaCartera4)!=80){
                                  
                                }else{
                                    add(ErrorPanel8);
                                    ErrorPanel8.setVisible(true); 
                                    TiendaPanel.setVisible(false); 
                                    ControlErrores=4;
                                }
                            }else{
                                add(ErrorPanel6);
                                ErrorPanel6.setVisible(true); 
                                TiendaPanel.setVisible(false); 
                                ControlErrores=4;
                            } 
                        
                        }else {
                            add(ErrorPanel5);
                            ErrorPanel5.setVisible(true); 
                            TiendaPanel.setVisible(false); 
                            ControlErrores=4;
                        }
                    }else{
                        add(ErrorPanel3);
                        ErrorPanel3.setVisible(true); 
                        TiendaPanel.setVisible(false); 
                        ControlErrores=4;       
                      }   
                } catch (SQLException ex) {
                    Logger.getLogger(INTERFAZ.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == DevolverEnDinero) {
                
                try{
                DNI=TF7.getText();
                int ID = Articulos2.getSelectedIndex()+1;
                int Stock2=0;
                if(TF11.getText().length()!=0){
                    Stock2 = Integer.parseInt(TF11.getText());
                }else{
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true); 
                    DevolverPanel.setVisible(false); 
                    ControlErrores=6; 
                }
                EWallet NuevaCartera3 = new EWallet(DNI);
                
                ProductoDAO productoDAO = new ProductoDAO();
                Producto producto = new Producto(Stock2, ID);
                if(TF11.getText().length()!=0){
                    if(Articulos2.isSelectionEmpty() == false){
                        if(productoDAO.Devolver(producto,NuevaCartera3)!=80){
                        }else{
                            add(ErrorPanel8);
                            ErrorPanel8.setVisible(true); 
                            DevolverPanel.setVisible(false); 
                            ControlErrores=6;
                        }
                    }else {
                        add(ErrorPanel5);
                        ErrorPanel5.setVisible(true); 
                        DevolverPanel.setVisible(false); 
                        ControlErrores=6;
                    }
                }else{
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true); 
                    DevolverPanel.setVisible(false); 
                    ControlErrores=6;       
                }   
                } catch (SQLException ex) {
                    Logger.getLogger(INTERFAZ.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == DevolverEnPuntos) {
                try{
                DNI=TF7.getText();
                int ID = Articulos2.getSelectedIndex()+1;
                int Stock2=0;
                if(TF11.getText().length()!=0){
                    Stock2 = Integer.parseInt(TF11.getText());
                }else{
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true); 
                    DevolverPanel.setVisible(false); 
                    ControlErrores=7; 
                }
                EWallet NuevaCartera3 = new EWallet(DNI);
                
                ProductoDAO productoDAO = new ProductoDAO();
                Producto producto = new Producto(Stock2, ID);
                
                if(TF11.getText().length()!=0){
                    if(Articulos2.isSelectionEmpty() == false){
                        if(productoDAO.DevolverEnPuntos(producto,NuevaCartera3)!=80){
                        }else{
                            add(ErrorPanel8);
                            ErrorPanel8.setVisible(true); 
                            DevolverPanel.setVisible(false); 
                            ControlErrores=7;
                        }
                    }else {
                        add(ErrorPanel5);
                        ErrorPanel5.setVisible(true); 
                        DevolverPanel.setVisible(false); 
                        ControlErrores=7;
                    }
                }else{
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true); 
                    DevolverPanel.setVisible(false); 
                    ControlErrores=7;       
                }   
                } catch (SQLException ex) {
                    Logger.getLogger(INTERFAZ.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource()==ConfirmarRecarga){
                String h;
                h = TF7.getText();
                int a=0;
                if(TF10.getText().length()!=0){
                    a = Integer.parseInt(TF10.getText());
                }else{
                    add(ErrorPanel3);
                    ErrorPanel3.setVisible(true); 
                    RecargarPanel.setVisible(false); 
                    ControlErrores=5; 
                }
                EWalletDAO ewalletDAO = new EWalletDAO();
                EWallet nuevaEwallet = new EWallet(h,a);
                ewalletDAO.recargar(nuevaEwallet);
            }
        }
    }

    public class VolverButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Volver) {
                RegistrarsePanel.setVisible(false);
                MenuPrincipal.setVisible(true);
            }
            if (e.getSource() == Volver2) {
                IniciarSesionPanel.setVisible(false);
                MenuPrincipal.setVisible(true);
            }
            if (e.getSource() == Volver3) {
                MenuCliente.setVisible(false);
                MenuPrincipal.setVisible(true);
            }
            if (e.getSource() == Volver4) {
                TiendaPanel.setVisible(false);
                MenuCliente.setVisible(true);
            }
            if (e.getSource() == Volver5) {
                SaldoPanel.setVisible(false);
                MenuCartera.setVisible(true);
            }
            if (e.getSource() == Volver6) {
                MenuCartera.setVisible(false);
                MenuCliente.setVisible(true);
            }
            if (e.getSource() == Volver7) {
                PuntosPanel.setVisible(false);
                MenuCartera.setVisible(true);
            }
            if (e.getSource() == Volver8) {
                DevolverPanel.setVisible(false);
                MenuCliente.setVisible(true);
            }
             if (e.getSource() == Volver11) {
                RecargarPanel.setVisible(false);
                MenuCartera.setVisible(true);
            }
            if (e.getSource() == Volver9) {
                if(ControlErrores==1){
                   ErrorPanel1.setVisible(false);
                   RegistrarsePanel.setVisible(true);
                }
            }
            if (e.getSource() == Volver10) {
                if(ControlErrores==1){
                   ErrorPanel2.setVisible(false);
                   RegistrarsePanel.setVisible(true);
                }
            }
            if (e.getSource() == Volver12) {
                if(ControlErrores==1){
                   ErrorPanel3.setVisible(false);
                   RegistrarsePanel.setVisible(true);
                }
                if(ControlErrores==2){
                   ErrorPanel3.setVisible(false);
                   IniciarSesionPanel.setVisible(true);
                }
                if(ControlErrores==3){
                   ErrorPanel3.setVisible(false); 
                   TiendaPanel.setVisible(true); 
                }
                if(ControlErrores==4){
                   ErrorPanel3.setVisible(false); 
                   TiendaPanel.setVisible(true); 
                }
                if(ControlErrores==5){
                   ErrorPanel3.setVisible(false); 
                   RecargarPanel.setVisible(true);
                }
                if(ControlErrores==6){
                   ErrorPanel3.setVisible(false); 
                   DevolverPanel.setVisible(true);
                }
                if(ControlErrores==7){
                   ErrorPanel3.setVisible(false); 
                   DevolverPanel.setVisible(true);
                }
            }
            if (e.getSource() == Volver13) {
                if(ControlErrores==2){
                   ErrorPanel4.setVisible(false);
                   IniciarSesionPanel.setVisible(true);
                }
            }
            if (e.getSource() == Volver14) {
                if(ControlErrores==3){
                   ErrorPanel5.setVisible(false); 
                   TiendaPanel.setVisible(true); 
                }
                if(ControlErrores==4){
                   ErrorPanel5.setVisible(false); 
                   TiendaPanel.setVisible(true);
                }
                if(ControlErrores==6){
                   ErrorPanel5.setVisible(false); 
                   DevolverPanel.setVisible(true);
                }
                if(ControlErrores==7){
                   ErrorPanel5.setVisible(false); 
                   DevolverPanel.setVisible(true);
                }
            }
            if (e.getSource() == Volver15) {
                if(ControlErrores==3){
                    ErrorPanel6.setVisible(false); 
                    TiendaPanel.setVisible(true);
                }
                if(ControlErrores==4){
                    ErrorPanel6.setVisible(false); 
                    TiendaPanel.setVisible(true);
                }
            }
            if (e.getSource() == Volver16) {
                if(ControlErrores==3){
                   ErrorPanel7.setVisible(false); 
                   TiendaPanel.setVisible(true); 
                }
            }
            if (e.getSource() == Volver17) {
                if(ControlErrores==4){
                   ErrorPanel8.setVisible(false); 
                   TiendaPanel.setVisible(true);
                }
                if(ControlErrores==6){
                    ErrorPanel8.setVisible(false); 
                    DevolverPanel.setVisible(true);
                }
                if(ControlErrores==7){
                   ErrorPanel8.setVisible(false); 
                   DevolverPanel.setVisible(true);
                }
            }
        }
    }
}
