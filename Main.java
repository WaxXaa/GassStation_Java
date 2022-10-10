import java.io.*;
public class Main {

        // Alejandro Mosquera - Isaac Reyes

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gasolinera gas = new Gasolinera();
        Cuenta ser1 = new Cuenta();
        Cuenta ser2 = new Cuenta();
        Cuenta ser3 = new Cuenta();
        Cuenta ser4 = new Cuenta();
        int serv = 0; 
        double totServ = 0;
        double precio = 0;

        boolean leido = true;
        boolean rept = false;

        String maxServ = "";
        String maxTurno = "";
        String resp = "";
        String respS = "S";
        String respN = "N";
        String turno = "M";
        String jorndM = "M";
        String jorndT = "T";

        
            for ( int i = 1; i <= 4; i++) {
                do {
                    try {
                        System.out.println("\n\tIngrese el precio del servicio " + i);
                        precio = Double.parseDouble(br.readLine());
                        leido = true;
                        if( precio < 0) {
                            System.out.println("\n**solo ingrese valores positivos**");
                            leido = false;
                        } else {
                            if(i == 1)
                                gas.setValorServ1(precio);
                            if(i == 2)
                                gas.setValorServ2(precio);
                            if(i == 3)
                                gas.setValorServ3(precio);
                            if(i == 4)
                                gas.setValorServ4(precio);
                        }
                    } catch (IOException e) {}
                    catch(NumberFormatException err) {
                        System.out.println("\n**ERROR** " + err);
                        leido = false;
                    }
                }while(!leido);
            }
        do{
            do {
                try {
                    System.out.println("\n\tIngrese el la jornada en la que esta\n\t \'M\' para la jornada de la Mañana o \'T\' para la jornada de la Tarde");
                    turno = br.readLine();
                    leido = false;
                    if( turno.equals(jorndT) || turno.equals(jorndT.toLowerCase())) {
                        leido = true;
                        gas.setTurno(turno);
                    }
                    if( turno.equals(jorndM) || turno.equals(jorndM.toLowerCase())) {
                        leido = true;
                        gas.setTurno(turno);
                    }
                } catch (IOException e) {
                    leido = false;
                    System.out.println("\n\t**ERROR** " + e);
                }
            }while(!leido);
            do {
                try {
                    System.out.println("\n\n\tIngrese el numero del servicio");
                    System.out.println("\n\t1 ---- Revisado de llantas " + gas.getValorServ1() + "$");
                    System.out.println("\n\t2 ---- Cambio de aceite "  + gas.getValorServ2() + "$");
                    System.out.println("\n\t3 ---- Servicio completo "  + gas.getValorServ3() + "$");
                    System.out.println("\n\t4 ---- 1 Galon de gasolina "  + gas.getValorServ4() + "$");
                    serv = Integer.parseInt(br.readLine());
                   
                    leido = true;
                    if ( serv <= 0 || serv > 4) {
                        System.out.println("\n**solo se aceptan valores del 1 al 4");
                        leido = false;
                    } else {
                        gas.setServ(serv);
                        gas.totalizarS(ser1, ser2, ser3, ser4);
                    }
                    
                    
                }
                catch(IOException e){System.out.println(e);}
                catch(NumberFormatException err) {
                    leido = false;
                    System.out.println("**ERROR** " + err);
                }
            }while(!leido);
            do {
                try {
                    System.out.println("\n\n\tDesea pedir otro servicio?\n\tIngrese 'S' para Si o 'N' para No");
                    resp = br.readLine();
                    leido = false;
                    if( resp.equals(respS) || resp.equals(respS.toLowerCase())) {
                        rept = true;
                        leido = true;
                    }
                    if( resp.equals(respN) || resp.equals(respN.toLowerCase())) {
                        rept = false;
                        leido = true;
                    }
                }
                catch(IOException e){
                    System.out.println("***ERROR " + e);
                    leido = false;
                }
            } while(!leido);
        }while(rept);

        totServ = gas.sumarServTot(ser1.getTotVS(), ser2.getTotVS(), ser3.getTotVS(), ser4.getTotVS());
        maxServ = gas.calcularMaxServ(ser1.getCant(), ser2.getCant(), ser3.getCant(), ser4.getCant());
        maxTurno = gas.calcularMaxTurno(ser1.getTurnoM(), ser2.getTurnoM(), ser3.getTurnoM(), ser4.getTurnoM(), ser1.getTurnoT(), ser2.getTurnoT(), ser3.getTurnoT(), ser4.getTurnoT());

        System.out.println("\n\t---->   El valor total de todos los servicios prestados: " + totServ);

        System.out.println("\n\t---->   El servicio 1 se prestó " + ser1.getCant() + " veces y facturo un total de " + ser1.getTotVS());
        System.out.println("\n\t---->   El servicio 2 se prestó " + ser2.getCant() + " veces y facturo un total de " + ser2.getTotVS());
        System.out.println("\n\t---->   El servicio 3 se prestó " + ser3.getCant() + " veces y facturo un total de " + ser3.getTotVS());
        System.out.println("\n\t---->   El servicio 4 se prestó " + ser4.getCant() + " veces y facturo un total de " + ser4.getTotVS());

        System.out.println(maxServ);

        System.out.println(maxTurno);
    }
}
