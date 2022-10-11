class Gasolinera {
    private int servicio;
    private String turno;
    private double valorServ1;
    private double valorServ2;
    private double valorServ3;
    private double valorServ4;

    public int getServ() {
        return servicio;
    }
    public void setServ(int servicio) {
        this.servicio = servicio;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public double getValorServ1() {
        return valorServ1;
    }
    public void setValorServ1(double valorServ1) {
        this.valorServ1 = valorServ1;
    }
    public double getValorServ2() {
        return valorServ2;
    }
    public void setValorServ2(double valorServ2) {
        this.valorServ2 = valorServ2;
    }
    public double getValorServ3() {
        return valorServ3;
    }
    public void setValorServ3(double valorServ3) {
        this.valorServ3 = valorServ3;
    }
    public double getValorServ4() {
        return valorServ4;
    }
    public void setValorServ4(double valorServ4) {
        this.valorServ4 = valorServ4;
    }

    public double sumarServTot(double servT1, double servT2, double servT3, double servT4){
        return (servT1 + servT2 + servT3 + servT4);
    }
    public String calcularMaxServ(int serv1, int serv2, int serv3, int serv4) {
        String resp = "";
        int max = Math.max(Math.max(serv1, serv2), Math.max(serv3, serv4));
        if( max == serv1)
            resp = "\n\t---->   El servicio que mas se presto fue el 1 con: " + max + " veces";
        if( max == serv2)
            resp = "\n\t---->   El servicio que mas se presto fue el 2 con: " + max + " veces";
        if( max == serv3)
            resp = "\n\t---->   El servicio que mas se presto fue el 3 con: " + max + " veces";
        if( max == serv4)
            resp = "\n\t---->   El servicio que mas se presto fue el 4 con: " + max + " veces";
        return resp;
    }
    public String calcularMaxTurno(int ser1M, int ser2M, int ser3M, int ser4M, int ser1T, int ser2T, int ser3T, int ser4T) {
        int maxM = Math.max(Math.max(ser1M, ser2M), Math.max(ser3M, ser4M));
        int maxT = Math.max(Math.max(ser1T, ser2T), Math.max(ser3T, ser4T));
        String resp = "";
        int max = Math.max(maxM, maxT);
        if( max == maxT)
            resp = "\n\t---->   El turno en el que mas se presto servicios fue el turno de la tarde con: " + max + " veces";
        if( max == maxM)
            resp = "\n\t---->   El turno en el que mas se presto servicios fue el turno de la mañana con: " + max + " veces";
        return resp;
    }

    public void totalizarS( Cuenta ser1, Cuenta ser2, Cuenta ser3, Cuenta ser4) {
        if( servicio == 1) {
            ser1.incrementar();
            ser1.totalizar(valorServ1);
            ser1.incrementarTurno(turno);
        }
        if( servicio == 2) {
            ser2.incrementar();
            ser2.totalizar(valorServ2);
            ser2.incrementarTurno(turno);
        }
        if( servicio == 3) {
            ser3.incrementar();
            ser3.totalizar(valorServ3);
            ser3.incrementarTurno(turno);
        }
        if( servicio == 4) {
            ser4.incrementar();
            ser4.totalizar(valorServ4);
            ser4.incrementarTurno(turno);
        }
    }
}
