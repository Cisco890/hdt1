interface IRadio {
    void saveStation (int buttonId, double station );
    boolean isAM();
    boolean isON();
    double selectStation(int buttonId);
    void SwitchOnOff();
    void SwitchAMFM();
    double nextStation();
}

