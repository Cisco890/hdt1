public class Radiogaga implements IRadio {
    private boolean ON;
    private boolean AM;
    private double station;
    private double[] AMList;
    private double[] FMList;
    private String frecuencia;
    private double emisora;

    public Radiogaga(boolean ON, boolean AM, double station, double[] AMList, double[] FMList){
        this.AM = true;
        this.ON = false;
        this.station = 530.0;
        this.AMList = new double[12];
        this.FMList = new double[12];
    }

    public void saveStation(int buttonId, double station) {
        if (this.AM == true){
            this.AMList[buttonId] = station;
        } else if(this.AM == false){
            this.FMList[buttonId] = station;
        }
    }

    public boolean isAM() {
       return this.AM;
    }
    
    public boolean isON() {
        return this.ON;
    }

    public double selectStation(int buttonId) {
        if(this.AM == true){
            return this.AMList[buttonId];
        } else {
            return this.FMList[buttonId];
        }
    }

    public void SwitchOnOff() {
        this.ON = !this.ON;
    }

    public void SwitchAMFM() {
        this.AM = !this.AM;
        if(this.AM == true){
            this.station = 530.0;
        } else {
            this.station = 87.9;
        }
    }

    public double nextStation() {
        if(this.AM == true){
            this.station += 10.0;
            if(this.station > 1610){
                this.station = 530.0;
            }
            return this.station;
        } else {
            this.station += 0.2;
            if(this.station > 107.9){
                this.station = 87.9;
            }
            return this.station;
        }
    }
    
        public String frecuencia() {
            if (isAM()) {
                return "AM";
            } else {
                return "FM";
            }
        }
        public double emisora(){
            return this.station; 
        }

}
