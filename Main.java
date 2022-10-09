import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Servicio gas = new Servicio();
        int serv1 = 0;
        int serv2 = 2;
        int serv3 = 0;
        int serv4 = 0;
        int turnoT = 0;
        int turnoM = 0;
        double totServ = 0;
        double totServ1 = 0;
        double totServ2 = 0;
        double totServ3 = 0;
        double totServ4 = 0;

        String maxServ = "";
        String maxTurno = "";
        String resp = "S";
        String turno = "M";
        int serv = 0;
        double precio = 0;
        boolean leido = true;
        boolean rept = false;


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

                // falto lo del turno


            do {
                try {
                    System.out.println("\n\n\tIngrese el numero del servicio");
                    System.out.println("\n\t1 - Revisado de llantas " + gas.getValorServ1() + "$");
                    System.out.println("\n\t2 - Cambio de aceite "  + gas.getValorServ2() + "$");
                    System.out.println("\n\t3 - Servicio completo "  + gas.getValorServ3() + "$");
                    System.out.println("\n\t4 - 1 Galon de gasolina "  + gas.getValorServ4() + "$");
                    serv = Integer.parseInt(br.readLine());
                    gas.setServ(serv);
                    leido = true;
                    if ( gas.getServ() <= 0 || gas.getServ() > 4) {
                        System.out.println("\n**solo se aceptan valores del 1 al 4");
                        leido = false;
                    }
                    if ( gas.getServ() == 1)
                        serv1 = gas.incrementar(serv1);
                    if ( gas.getServ() == 2)
                        serv2 = gas.incrementar(serv2);
                    if( gas.getServ() == 3)
                        serv3 = gas.incrementar(serv3);
                    if( gas.getServ() == 4)
                        serv4 = gas.incrementar(serv4);
                }
                catch(IOException e){System.out.println(e);}
                catch(NumberFormatException err) {
                    leido = false;
                    System.out.println("**ERROR** " + err);
                }
            }while(!leido);
            do {
                try {
                    System.out.println("\n\n\tDesea pedir otro servicio?\n\tIngrese 'Si para Si o 'No' para No");
                    resp = br.readLine();
                    leido = false;

                    // por alguna razon no esta entrando en el if y se vuelve ciclo infinito
                    if( resp == "Si" || resp == "No") {
                        if( resp == "Si")
                            rept = true;
                        if( resp == "No")
                            rept = false;
                        leido =  true;
                    }
                }
                catch(IOException e){
                    System.out.println("***ERROR " + e);
                }
            } while(!leido);
        }while(rept);
        totServ = gas.sumarServTot(totServ1, totServ2, totServ3, totServ4);
        maxServ = gas.calcularMaxServ(serv1, serv2, serv3, serv4);
      //  maxTurno = gas.calcularMaxTurno(turnoM, turnoT);


        System.out.println("el valor total de todos los servicios prestados: " + totServ);

        System.out.println("\n\tEl servicio 1 se prestó " + serv1 + "veces y facturo un total de " + gas.calcularServTot(serv1, gas.getValorServ1()));
        System.out.println("\n\tEl servicio 2 se prestó " + serv2 + "veces y facturo un total de " + gas.calcularServTot(serv2, gas.getValorServ2()));
        System.out.println("\n\tEl servicio 3 se prestó " + serv3 + "veces y facturo un total de " + gas.calcularServTot(serv3, gas.getValorServ3()));
        System.out.println("\n\tEl servicio 4 se prestó " + serv4 + "veces y facturo un total de " + gas.calcularServTot(serv4, gas.getValorServ4()));

        System.out.println(maxServ);

        //System.out.println(maxTurno);
    }
}