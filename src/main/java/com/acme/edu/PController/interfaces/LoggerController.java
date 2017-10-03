package com.acme.edu.PController.interfaces;

import com.acme.edu.PController.interfaces.accumulate.LoggerAccumulate;
import com.acme.edu.PController.interfaces.format.LoggerFormat;
import com.acme.edu.PController.interfaces.save.LoggerSaver;

import java.util.ArrayList;

public class LoggerController {

    private LoggerSaver sav;
    private LoggerFormat form;
    private LoggerAccumulate TargetAcc;
    //private LoggerAccumulate TargetACC;


    private int mode;
    private int deltaI;
    private byte deltaB;
    private String str;

    ArrayList setofAcc;
    private String log;

    public LoggerController()
    {
        mode = 0;
        deltaI = 0;
        deltaB = 0;
        //deltaS = "";
        log = "";
        setofAcc = new ArrayList<LoggerAccumulate>();
        setofAcc.add(new ByteAcc());
        setofAcc.add(new IntAcc());
        setofAcc.add(new StringAcc());

    }


    public void setDS(String DS) {
        this.str = DS;
    }

    public void setDB(byte DB) {
        this.deltaB = DB;
    }

    public void setDI(int DI) {
        this.deltaI = DI;
    }



    public void LoggingProcess(int mode)
    {
        //region Флаг
        switch(this.mode) {
            case 1: {
                if(mode == 1)
                {
                    TargetAcc.accumulate(1);
                }else if(mode == 2){
                    log += TargetAcc.accumulate(2)+"\n";
                }else if (mode == 3) {
                    log+= TargetAcc.accumulate(2)+"\n";
                }
                TargetAcc.setDeltaB(deltaB);
                TargetAcc = (ByteAcc) setofAcc.get(0);
                break;
            }
            case 2: {
                if(mode == 2)
                {
                    TargetAcc.accumulate(1);
                }else if(mode == 3){
                    log += TargetAcc.accumulate(2)+"\n";
                }else if(mode == 1)
                {
                    log+= TargetAcc.accumulate(2)+"\n";
                }
                TargetAcc.setDeltaI(deltaI);
                TargetAcc = (IntAcc) setofAcc.get(1);
                break;
            }
            case 3: {
                if (mode==3)
                {
                    if(TargetAcc.equals(str))
                        TargetAcc.accumulate(1);
                    else{
                        if(TargetAcc.getCountS() > 1)
                            log += str + " (x"+TargetAcc.accumulate(2)+")\n";
                        else
                            log += str;
                        TargetAcc.setStr(str);
                    }
                }
                else if(mode == 1){
                    log += str + " (x"+TargetAcc.accumulate(2)+")\n";
                } else if(mode == 2) {
                    log += TargetAcc.accumulate(2)+"\n";
                }
                TargetAcc.setStr(str);
                TargetAcc = (StringAcc) setofAcc.get(2);
                break;
            }
            default:
            {
                switch(mode)
                {
                    case 1:
                    {
                        TargetAcc = (ByteAcc) setofAcc.get(0);
                        TargetAcc.setDeltaB(deltaB);
                        break;
                    }
                    case 2:
                    {
                        TargetAcc = (IntAcc) setofAcc.get(1);
                        TargetAcc.setDeltaI(deltaI);
                        break;
                    }
                    case 3:
                    {
                        TargetAcc = (StringAcc) setofAcc.get(2);
                        TargetAcc.setStr(str);
                        break;
                    }
                }
                //TargetAcc.accumulate(0);
            }
        }
        //endregion

        setState(mode);
    }
    private void setState(int mode) {
        this.mode = mode;
    }

    public void end() {
        switch(this.mode) {
            case 1:
            {
                TargetAcc = (ByteAcc) setofAcc.get(0);
                log+=TargetAcc.accumulate(2);
                break;
            }
            case 2:
            {
                TargetAcc = (IntAcc) setofAcc.get(1);
                log+=TargetAcc.accumulate(2);
                break;
            }
            case 3:
            {
                TargetAcc = (StringAcc) setofAcc.get(2);
                log+=str + " (x" + TargetAcc.accumulate(2)+")\n";
                break;
            }
        }


        sav = new ConsoleSaver(log);
        sav.save();
        setofAcc.clear();
    }
}