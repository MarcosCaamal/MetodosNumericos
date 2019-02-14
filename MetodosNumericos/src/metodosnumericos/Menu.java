
package metodosnumericos;

/**
 *
 * @author m
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JFrame{
    int opcionSeleccion=0;
    JTextField txtVReal, txtVAproximado, txtCifras, txtErrorA, txtErrorR, txtErrorRP;
    JLabel lblVReal, lblVAproximado, lblSeleccionar, lblCifras, lblErrorA, lblErrorR, lblErrorRP;
    JPanel pDatos, pSeleccion, pResultados;
    JButton btnCalcular;
    JRadioButton rbtnDefecto, rbtnTruncar, rbtnRedondear;
    ButtonGroup btngSeleccionar;
    Container cp;
    Menu(){
    super("Menú");
        setSize(320,270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //PanelDatos
        lblVReal =new JLabel("Valor Verdadero: ");
        lblVAproximado= new JLabel("Valor Aproximado: ");
        txtVReal =new JTextField(15);
        txtVAproximado =new JTextField(15);
        pDatos=new JPanel();
        pDatos.setLayout(new GridLayout(2,2));
        pDatos.add(lblVReal);
        pDatos.add(txtVReal);
        pDatos.add(lblVAproximado);
        pDatos.add(txtVAproximado);
        //Panel selección
        pSeleccion=new JPanel(new FlowLayout());
        lblSeleccionar=new JLabel("Elige una opcion para calcular tus resultado: ");
        lblCifras=new JLabel("Número de cifras: ");
        txtCifras=new JTextField(10);
        txtCifras.setEnabled(false);
        btnCalcular=new JButton("Calcular");
        rbtnDefecto=new JRadioButton("Por Defecto");
        rbtnTruncar=new JRadioButton("Truncar");
        rbtnRedondear=new JRadioButton("Redondear");
        btngSeleccionar =new ButtonGroup();
        btngSeleccionar.add(rbtnDefecto); 
        btngSeleccionar.add(rbtnTruncar); 
        btngSeleccionar.add(rbtnRedondear);
        pSeleccion.add(lblSeleccionar);
        pSeleccion.add(rbtnDefecto);
        pSeleccion.add(rbtnTruncar);
        pSeleccion.add(rbtnRedondear);
        pSeleccion.add(lblCifras);
        pSeleccion.add(txtCifras);
        pSeleccion.add(btnCalcular);
        //Panel Resultados
        pResultados=new JPanel(new GridLayout(3,2));
        lblErrorA=new JLabel("Error Absoluto: ");
        lblErrorR=new JLabel("Error Relativo: ");
        lblErrorRP=new JLabel("Error Relatvo Porcentual: ");
        txtErrorA=new JTextField(10);
        txtErrorR=new JTextField(10);
        txtErrorRP=new JTextField(10);
        pResultados.add(lblErrorA);
        pResultados.add(txtErrorA);
        pResultados.add(lblErrorR);
        pResultados.add(txtErrorR);
        pResultados.add(lblErrorRP);
        pResultados.add(txtErrorRP);
        //manejadores de eventos
        manejadorEventos Eventos=new manejadorEventos();
        rbtnDefecto.addActionListener(Eventos);
        rbtnTruncar.addActionListener(Eventos);
        rbtnRedondear.addActionListener(Eventos);
        btnCalcular.addActionListener(Eventos);
        //contenedor
        cp= getContentPane();
        cp.add(pDatos, BorderLayout.NORTH);
        cp.add(pSeleccion, BorderLayout.CENTER);
        cp.add(pResultados, BorderLayout.SOUTH);
     
        setVisible(true);
       
    }
    private class manejadorEventos implements ActionListener{
        public void actionPerformed(ActionEvent objetoEvento){
            if(objetoEvento.getSource()==rbtnTruncar){
                txtCifras.setEnabled(true);
                 opcionSeleccion=1;
                  if(rbtnTruncar.isSelected()){
                      
                      opcionSeleccion=1;
                }
            }
            if(objetoEvento.getSource()==rbtnRedondear){
                txtCifras.setEnabled(true);
                opcionSeleccion=2;
                if(rbtnTruncar.isSelected()){
                      opcionSeleccion=2;
                }
            }
            if(objetoEvento.getSource()==rbtnDefecto){
                 txtCifras.setEnabled(false);
                 opcionSeleccion=0;

                if(rbtnTruncar.isSelected()){
                      opcionSeleccion=0;
                }
            }
            if(objetoEvento.getSource()==btnCalcular){
                try{
                int cifras;
                 if (opcionSeleccion==0)
                {
                    cifras=0;
                }else
                cifras=Integer.parseInt(txtCifras.getText());
                String valorVerdadero, valorAproximado, resultadoErrorA;
                double vReal, vAproximado;
                valorVerdadero=txtVReal.getText();
                valorAproximado=txtVAproximado.getText();
                vReal=Double.parseDouble(valorVerdadero);
                vAproximado=Double.parseDouble(valorAproximado);
                
                CalculosErrores resultado=new CalculosErrores(vReal, vAproximado, opcionSeleccion, cifras);

                txtErrorA.setText(String.valueOf(resultado.calcularErrorAbsoluto()));
                txtErrorR.setText(String.valueOf(resultado.calcularErrorRelativo()));
                txtErrorRP.setText(String.valueOf(resultado.calcularErrorRelativoPorcentual()));}
                catch(Exception e){
                JOptionPane.showMessageDialog(null, "No ingresaste cifras");
                }
            }
        }
    }
    
}
