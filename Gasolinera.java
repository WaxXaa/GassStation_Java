class Gasolinera {
    private int serv;
    private int turno;
    private double valorServ1;
    private double valorServ2;
    private double valorServ3;
    private double valorServ4;

    public int getServ() {
        return serv;
    }
    public void setServ(int serv) {
        this.serv = serv;
    }
    public int getTurno() {
        return turno;
    }
    public void setTurno(int turno) {
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
    public int incrementar(int var) {
        return var + 1;
    }
    public double acumularServTot(double servAcum,double precio) {
        double acum = servAcum + precio;
        return  acum;
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
    public String calcularMaxTurno(int turnoM, int turnoT) {
        String resp = "";
        int max = Math.max(turnoT, turnoM);
        if( max == turnoT)
            resp = "\n\t---->   El turno en el que mas se presto servicios fue el turno T con: " + max + " veces";
        if( max == turnoM)
            resp = "\n\t---->   El turno en el que mas se presto servicios fue el turno M con: " + max + " veces";
        return resp;
    }
}