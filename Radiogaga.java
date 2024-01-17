/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  * Radiogaga
 
  * @param Boolean_on,Boolean_AM,Double_station,Double[]_AMList,Double[]_FMList  
  * @throws Si esta encendida o apagada, si esta en FM o AM, el número de la estacion, la lista de AM y FM
  */
public class Radiogaga implements IRadio {
    private boolean ON;
    private boolean AM;
    private double station;
    private double[] AMList;
    private double[] FMList;

    public Radiogaga(boolean ON, boolean AM, double station, double[] AMList, double[] FMList){// objeto radio
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
    
    public boolean isOn() {
        return this.ON;
    }

    public double selectStation(int buttonId) {
        if (this.AM == true) {
            this.station = this.AMList[buttonId];
        } else {
            this.station = this.FMList[buttonId];
        }
        return this.station;
    }
    

    public void switchOnOff() {
        this.ON = !this.ON;
    }

    public void switchAMFM() {
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
    

        

}
