import java.io.*;
public class Main {

        // Alejandro Mosquera - Isaac Reyes

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gasolinera gas = new Gasolinera();
        int serv = 0;
        int serv1 = 0;
        int serv2 = 0;
        int serv3 = 0;
        int serv4 = 0;
        int turnoT = 0;
        int turnoM = 0;
        double totServ = 0;
        double totServ1 = 0;
        double totServ2 = 0;
        double totServ3 = 0;
        double totServ4 = 0;
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

        do{
            for ( int i = 1; i <= 4; i++) {
                do {
                    try {
                        System.out.println("\n\tIngrese el precio del servicio " + i);
                        precio = Double.parseDouble(br.readLine());
                        leido = true;
                        if( precio < 0) {
                            System.out.println("\n**solo ingrese valores positivos**");
                            leido = false;
                        }
                        if( i == 1)
                            gas.setValorServ1(precio);
                        if( i == 2)
                            gas.setValorServ2(precio);
                        if( i == 3)
                            gas.setValorServ3(precio);
                        if( i == 4)
                            gas.setValorServ4(precio);
                    } catch (IOException e) {}
                    catch(NumberFormatException err) {
                        System.out.println("\n**ERROR** " + err);
                        leido = false;
                    }
                }while(!leido);
            }
            do {
                try {
                    System.out.println("\n\tIngrese el la jornada en la que esta\n\t \'M\' para la jornada de la Mañana o \'T\' para la jornada de la Tarde");
                    turno = br.readLine();
                    leido = false;
                    if( turno.equals(jorndT) || turno.equals(jorndT.toLowerCase())) {
                        leido = true;
                        turnoT = gas.incrementar(turnoT);
                    }
                    if( turno.equals(jorndM) || turno.equals(jorndM.toLowerCase())) {
                        leido = true;
                        turnoM = gas.incrementar(turnoM);
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
                    gas.setServ(serv);
                    leido = true;
                    if ( gas.getServ() <= 0 || gas.getServ() > 4) {
                        System.out.println("\n**solo se aceptan valores del 1 al 4");
                        leido = false;
                    }
                    if ( gas.getServ() == 1){
                        serv1 = gas.incrementar(serv1);
                        totServ1 = gas.acumularServTot(totServ1, gas.getValorServ1());
                    }
                    if ( gas.getServ() == 2) {
                        serv2 = gas.incrementar(serv2);
                        totServ2 = gas.acumularServTot(totServ2, gas.getValorServ2());
                    }
                    if( gas.getServ() == 3) {
                        serv3 = gas.incrementar(serv3);
                        totServ3 = gas.acumularServTot(totServ3, gas.getValorServ3());
                    }
                    if( gas.getServ() == 4) {
                        serv4 = gas.incrementar(serv4);
                        totServ4 = gas.acumularServTot(totServ4, gas.getValorServ4());
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
                    System.out.println("\n\n\tDesea pedir otro servicio?\n\tIngrese 'Si' para Si o 'No' para No");
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

        totServ = gas.sumarServTot(totServ1, totServ2, totServ3, totServ4);
        maxServ = gas.calcularMaxServ(serv1, serv2, serv3, serv4);
        maxTurno = gas.calcularMaxTurno(turnoM, turnoT);

        System.out.println("\n\t---->   El valor total de todos los servicios prestados: " + totServ);

        System.out.println("\n\t---->   El servicio 1 se prestó " + serv1 + " veces y facturo un total de " + totServ1);
        System.out.println("\n\t---->   El servicio 2 se prestó " + serv2 + " veces y facturo un total de " + totServ2);
        System.out.println("\n\t---->   El servicio 3 se prestó " + serv3 + " veces y facturo un total de " + totServ3);
        System.out.println("\n\t---->   El servicio 4 se prestó " + serv4 + " veces y facturo un total de " + totServ4);

        System.out.println(maxServ);

        System.out.println(maxTurno);
    }
}