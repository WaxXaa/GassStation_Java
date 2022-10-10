class Cuenta {
    private int cant;
    private int turnoT;
    private int turnoM;
    private double totVS;
    public int getCant() {
        return cant;
    }
    public void setCant(int cant) {
        this.cant = cant;
    }
    public double getTotVS() {
        return totVS;
    }
    public void setTotVS( double totVS) {
        this.totVS = totVS;
    }    
    public int getTurnoT() {
        return turnoT;
    }
    public void setTurnoT(int turnoT) {
        this.turnoT = turnoT;
    }
    public int getTurnoM() {
        return turnoM;
    }
    public void setTurnoM(int turnoM) {
        this.turnoM = turnoM;
    }
    public void incrementar() {
        cant += 1;        
    }
    public void incrementarTT() {
        turnoT += 1;
    }
    public void incrementarMM() {
        turnoM += 1;
    }
    public void totalizar(double precio) {
        totVS += precio;
    }

}
